/*==================================ASIGNACION_DB´S=====================================*/
USE master

Declare @Log_Errores table(
    ID NUMERIC(18,0) IDENTITY(1,1) NOT NULL,
    ERROR_LINE INT NULL,
    ERROR_MESSAGE NVARCHAR(2048) NULL,
    ERROR_PROCEDURE NVARCHAR(126) NULL,
    ERROR_NUMBER INT NULL,
    ERROR_SEVERITY INT NULL,
    ERROR_STATE INT NULL,
    FECTRANS DATETIME NULL,
    USERID VARCHAR(255) NULL
)

DECLARE @nombredb1 VARCHAR(20), @nombredb2 VARCHAR(20),@value int
IF EXISTS(select * from sys.databases where name='VIDEOCLUB')
    IF EXISTS(select * from sys.databases where name='VIDEOCLUB2')
        SET @value = 0
    ELSE
        SET @value = 1
ELSE
    SET @value = 1

BEGIN TRY
IF(@value = 0)
    PRINT 'LAS BASES DE DATOS EXISTEN :)'
ELSE
    PRINT 'LAS BASES DE DATOS NO EXISTEN :(' RAISERROR('ERROR!!: LAS BASES DE DATOS NO EXISTEN',16,1)
    SELECT * FROM @Log_Errores
END TRY
BEGIN CATCH
  INSERT INTO @Log_Errores(ERROR_LINE,ERROR_MESSAGE,ERROR_PROCEDURE,ERROR_NUMBER,ERROR_SEVERITY,ERROR_STATE,FECTRANS,USERID)
  VALUES(ERROR_LINE(),ERROR_MESSAGE(),ERROR_PROCEDURE(),ERROR_NUMBER(),ERROR_SEVERITY(),ERROR_STATE(),GETDATE(),USER)
  PRINT 'Consulta con errores. Revise la tabla Log_Errores: ' + ERROR_MESSAGE() 
END CATCH

/*=======================================FUNCION_PRINCIAL==================================*/
IF(@value = 0)
    DECLARE @nombrebd NVARCHAR(MAX), @nombrebd2 NVARCHAR(MAX)
    SET @nombrebd = DB_NAME(DB_ID('VIDEOCLUB'))
    SET @nombrebd2 = DB_NAME(DB_ID('VIDEOCLUB2'))
    DECLARE @nombre AS nvarchar(MAX), @columna AS nvarchar(MAX), @tipo AS nvarchar(MAX), @table varchar(MAX)
    Declare @Temp table (nombre varchar(40),columna varchar(40),tipo varchar(40))
    DECLARE cursor_tabla CURSOR FOR SELECT nombre FROM @Temp
    DECLARE cursor_columna CURSOR FOR SELECT columna FROM @Temp
    DECLARE cursor_tipo CURSOR FOR SELECT tipo FROM @Temp
    set @table= 'SELECT n.name,c.name,t.name
        FROM ' + @nombrebd + '.sys.tables n inner join ' + @nombrebd + '.sys.columns c on n.object_id = c.object_id 
        inner join ' + @nombrebd + '.sys.systypes t ON c.system_type_id= t.xtype
        EXCEPT
        SELECT n.name,c.name,t.name
        FROM ' + @nombrebd2 + '.sys.tables n inner join ' + @nombrebd2 +'.sys.columns c on n.object_id = c.object_id 
        inner join ' + @nombrebd2 +'.sys.systypes t ON c.system_type_id= t.xtype'
    Insert into @Temp
        exec(@table);

    OPEN cursor_tabla
    OPEN cursor_columna
    OPEN cursor_tipo

    FETCH NEXT FROM cursor_columna INTO @columna
    FETCH NEXT FROM cursor_tipo INTO @tipo
    FETCH NEXT FROM cursor_tabla INTO @nombre

    WHILE @@fetch_status = 0
    BEGIN
        DECLARE @SQL_CREAR NVARCHAR(MAX)
        USE VIDEOCLUB2
        IF EXISTS (SELECT t.name FROM VIDEOCLUB2.sys.tables t where t.name = @nombre)
            SET @SQL_CREAR = 'ALTER TABLE ' + @nombre + ' ADD ' + @columna +' '+ @tipo 
        ELSE
            SET @SQL_CREAR = 'CREATE TABLE ' + @nombre + '('+@columna+ ' '+@tipo+')'
        IF EXISTS (SELECT t.name FROM VIDEOCLUB2.sys.tables t inner join VIDEOCLUB2.sys.columns c on t.object_id = c.object_id where t.name = @nombre and c.name = @columna)
            SET @SQL_CREAR = 'ALTER TABLE ' + @nombre + ' ALTER COLUMN ' + @columna +' '+ @tipo
        EXEC sp_executesql @SQL_CREAR 
        FETCH NEXT FROM cursor_tabla INTO @nombre
        FETCH NEXT FROM cursor_columna INTO @columna
        FETCH NEXT FROM cursor_tipo INTO @tipo
    END
    CLOSE cursor_tabla
    CLOSE cursor_columna
    CLOSE cursor_tipo
    DEALLOCATE cursor_tabla
    DEALLOCATE cursor_columna
    DEALLOCATE cursor_tipo
    PRINT 'TABLAS INSERTADAS SATISFACTORIAMENTE,QUE TENGA UN HERMOSO DIA UWU'