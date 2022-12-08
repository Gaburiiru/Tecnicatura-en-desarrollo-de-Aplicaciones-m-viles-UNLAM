/*IF EXISTS(select * from sys.databases where name='origen')
    USE origen
	SELECT name
    FROM sys.tables
    
    IF EXISTS(select * from sys.databases where name='destino')
        USE destino
        SELECT name
        FROM sys.tables
GO*/

--CREANDO PROCEDIMIENTOS
    -- USE origen
    -- GO
    -- CREATE PROCEDURE b
    -- AS
    -- SELECT name
    -- FROM sys.tables

    -- EXEC b

    -- USE destino
    -- GO
    -- CREATE PROCEDURE a
    -- AS
    -- SELECT name
    -- FROM sys.tables

    -- EXEC a

--CREAR VISTA
    -- CREATE VIEW tabla
    -- AS
    -- SELECT name
    -- FROM sys.tables

    -- SELECT * FROM tabla
-- USE MASTER
-- IF EXISTS(select * from sys.databases where name='VIDEOCLUB')    
--     DROP DATABASE VIDEOCLUB
-- GO

-- CREATE DATABASE VIDEOCLUB;
-- GO
-- USE VIDEOCLUB;
-- GO

-- Insert Into [origen].[dbo].[@CONVERSION] (campo)
-- select campo from [destino].[dbo].[@CONVERSION]

--wea
-- SELECT *
-- FROM sys.schemas
-- WHERE(SELECT TABLE_SCHEMA ,
--         TABLE_NAME ,
--         COLUMN_NAME
--         FROM   INFORMATION_SCHEMA.COLUMNS
--         where TABLE_SCHEMA in ('dbo','meta')
--         and table_name in (select name from sys.tables)
--         order by TABLE_SCHEMA ,TABLE_NAME) 
--         <> 
--         (SELECT TABLE_SCHEMA ,
--                 TABLE_NAME ,
--                 COLUMN_NAME
--         FROM   INFORMATION_SCHEMA.COLUMNS
--         where TABLE_SCHEMA in ('dbo','meta')
--         and table_name in (select name from sys.tables)
--         order by TABLE_SCHEMA ,TABLE_NAME)

/* NO FUNCA
Declare @Temp table (TABLE_NAME varchar(40));
declare @tablas varchar(500)

SELECT @tablas = name
FROM sys.tables

Insert into @Temp
    exec(@tablas);

SELECT * FROM @Temp
*/

-- SELECT (SELECT TOP 1
--            name
--            FROM origen.sys.schemas WHERE schema_id = D1O.schema_id) AS Schema_Name, 
--            D1O.name AS Object_Name
--         FROM origen.sys.syscomments D1C INNER JOIN origen.sys.objects D1O
--         ON D1O.object_id = D1C.id INNER JOIN destino.sys.objects D2O
--         ON D1O.name = D2O.name INNER JOIN destino.sys.syscomments D2C
--         ON D2O.object_id = D2C.id
--         WHERE D1C.text <> D2C.text;


-- USE origen;  -- <<<<<<<<<<<< CHANGE THIS VALUE to Schema you want to dump
-- ;


-- WITH vars
-- AS (
--   SELECT DB_NAME() AS v_SchemaName
-- )

-- , baseTbl
-- AS (
--   SELECT TABLE_CATALOG AS SchemaName, table_type, table_name 
--   FROM INFORMATION_SCHEMA.TABLES
--   WHERE TABLE_CATALOG = (SELECT v_SchemaName FROM vars) 
-- )

-- , metaForTbl
-- AS (
--   SELECT t.SchemaName
--   , t.table_name  AS TableName
--   , '(' + CASE WHEN t.table_type = 'BASE TABLE' THEN 'Table' WHEN t.table_type = 'VIEW' THEN 'View' ELSE 'UK' END + ')' AS ObjectType
--   , t.table_name  AS ObjectName
--   , '(Exists)' AS PropertyName 
--   , ' ' AS PropertyValue
--   FROM baseTbl t
-- )

-- , metaForCol_dataType
-- AS (
--   SELECT ft.SchemaName, ft.table_name AS TableName, 'Column' AS ObjectType, tut.column_name AS ObjectName 
--   , '2' AS PropertyName
--   , COALESCE(tut.data_type, 'unknown') + '(' 
--     + CASE WHEN tut.CHARACTER_MAXIMUM_LENGTH  IS NOT NULL THEN       CAST(tut.CHARACTER_MAXIMUM_LENGTH AS VARCHAR(10)) ELSE '' END 
--     + CASE WHEN tut.DATA_TYPE IN('date','datetime')       THEN ',' + CAST(tut.DATETIME_PRECISION AS VARCHAR(10)) 
-- 	       WHEN tut.NUMERIC_PRECISION IS NULL             THEN ''
-- 		   ELSE ',' + CAST(tut.NUMERIC_PRECISION AS VARCHAR(10)) 
-- 	  END 
--     + CASE WHEN tut.NUMERIC_SCALE IS NOT NULL             THEN ',' + CAST(tut.NUMERIC_SCALE AS VARCHAR(10)) ELSE '' END
--     + ')' AS PropertyValue 
--   FROM INFORMATION_SCHEMA.COLUMNS tut
--   INNER JOIN baseTbl ft ON ft.SchemaName = tut.TABLE_CATALOG AND ft.table_name = tut.table_name
-- )

-- , metaForCol_nullable
-- AS (
--   SELECT ft.SchemaName, ft.table_name AS TableName, 'Column' AS ObjectType, tut.column_name AS ObjectName 
--   , '3' AS PropertyName, CASE WHEN tut.IS_NULLABLE = 'YES' THEN 'NULL' ELSE 'NOT NULL' END AS PropertyValue 
--   FROM INFORMATION_SCHEMA.COLUMNS tut
--   INNER JOIN baseTbl ft ON ft.SchemaName = tut.TABLE_CATALOG  AND ft.table_name = tut.table_name
-- )

-- , metaForCol_ordpos
-- AS (
--   SELECT ft.SchemaName, ft.table_name AS TableName, 'Column' AS ObjectType, tut.column_name AS ObjectName 
--   , '1' AS PropertyName, RIGHT('000' + CAST(tut.ORDINAL_POSITION AS VARCHAR(3)), 3) AS PropertyValue 
--   FROM INFORMATION_SCHEMA.COLUMNS tut
--   INNER JOIN baseTbl ft ON ft.SchemaName = tut.TABLE_CATALOG AND ft.table_name = tut.table_name
-- )

-- , metaAllCols
-- AS (
--   SELECT schemaname, tablename, objecttype, objectname, 'Properties' AS propertyname
--   /* NOTE: STRING_AGG was added in SQL Server 2017 and forward.
--      If you have and older version, use FOR XML PATH approach here: https://stackoverflow.com/questions/15477743/listagg-in-sqlserver
--   */
--   , STRING_AGG(propertyvalue, ' | ') 
--     WITHIN GROUP (ORDER BY propertyname, propertyvalue) AS propertyvalue
--   FROM (
--           SELECT * FROM metaForCol_dataType
--     UNION SELECT * FROM metaForCol_nullable
--     UNION SELECT * FROM metaForCol_ordpos
--   ) t
--   GROUP BY schemaname, tablename, objecttype, objectname
-- )

-- , metaForKeys
-- AS (
--   SELECT cons.TABLE_CATALOG AS SchemaName, cons.TABLE_NAME AS TableName
--   , CASE WHEN cons.constraint_type = 'PRIMARY KEY' THEN 'PKey'
--          WHEN cons.constraint_type = 'UNIQUE' THEN 'UKey'
--          WHEN cons.constraint_type = 'FOREIGN KEY' THEN 'FKey'
-- 		 ELSE 'X'
--     END AS ObjectType
--   , cons.constraint_name AS ObjectName
--   , 'FieldList' AS PropertyName 
--   /* NOTE: STRING_AGG was added in SQL Server 2017 and forward.
--      If you have and older version, use FOR XML PATH approach here: https://stackoverflow.com/questions/15477743/listagg-in-sqlserver
--   */
--   , STRING_AGG(kcu.COLUMN_NAME, ',') WITHIN GROUP (ORDER BY kcu.ORDINAL_POSITION) AS PropertyValue 
--   FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS      cons 
--   INNER JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE kcu 
--      ON cons.TABLE_CATALOG = kcu.TABLE_CATALOG  
--     AND cons.TABLE_NAME = kcu.TABLE_NAME
-- 	AND cons.CONSTRAINT_NAME = kcu.CONSTRAINT_NAME
--   WHERE cons.TABLE_CATALOG = (SELECT v_SchemaName FROM vars)
--     AND cons.table_name IN(SELECT DISTINCT table_name FROM baseTbl)
--     AND cons.constraint_type IN('PRIMARY KEY','FOREIGN KEY','UNIQUE') 
--   GROUP BY cons.TABLE_CATALOG, cons.TABLE_NAME, cons.CONSTRAINT_TYPE, cons.CONSTRAINT_NAME
-- )

-- , metaForIdxs
-- AS (
-- SELECT (SELECT v_SchemaName FROM vars) AS SchemaName, o.name AS TableName
-- , 'Index' AS ObjectType, i.name AS ObjectName 
-- , 'FieldList' AS PropertyName 
--   /* NOTE: STRING_AGG was added in SQL Server 2017 and forward.
--      If you have and older version, use FOR XML PATH approach here: https://stackoverflow.com/questions/15477743/listagg-in-sqlserver
--   */
-- , STRING_AGG(c.name, ',') WITHIN GROUP (ORDER BY ic.key_ordinal /*column_store_order_ordinal*/) AS PropertyValue 
-- FROM sys.indexes               i
--   INNER JOIN sys.objects       o  ON i.object_id = o.object_id
--   INNER JOIN sys.index_columns ic ON ic.object_id = i.object_id AND  ic.index_id = i.index_id
--   INNER JOIN sys.columns       c  ON c.object_id = i.object_id  AND c.column_id = ic.column_id
-- WHERE i.[Type] = 2
--   AND i.is_unique = 0
--   AND i.is_primary_key = 0
--   AND o.[type] = 'U'
-- GROUP BY o.name, i.name
-- )

-- , allMetadata
-- AS (
--         SELECT * FROM metaForTbl
--   UNION SELECT * FROM metaAllCols
--   UNION SELECT * FROM metaForKeys
--   UNION SELECT * FROM metaForIdxs
-- )

-- SELECT CASE WHEN objecttype IN('(Table)','(View)') THEN schemaname ELSE ' ' END AS schema_nm
-- , CASE WHEN objecttype IN('(Table)','(View)') THEN tablename ELSE ' ' END AS tbl_nm
-- , objecttype AS obj_typ, objectname AS obj_nm, /*propertyname,*/ propertyvalue AS properties
-- FROM allMetadata 
-- ORDER BY schemaname, tablename, objecttype
-- , CASE WHEN objecttype='Column' THEN propertyvalue ELSE ' ' END
-- , objectname, propertyname

-- DECLARE @tabla VARCHAR(5000)

-- SET @tabla =(SELECT name FROM origen.sys.tables
-- EXCEPT 
-- SELECT name FROM destino.sys.tables)

-- SELECT @tabla


-- SELECT TABLE_NAME
-- FROM   INFORMATION_SCHEMA.COLUMNS
-- where table_name in (select name from sys.tables)


set nocount on;
-- Establezca las dos variables newmodel y oldmodel en los nombres de base de datos apropiados y ejecute el script
declare @newmodel varchar(50), @oldmodel varchar(50);
Set @newmodel = '[destino]';
set @oldmodel = '[origen]';

Declare @Temp table (TABLE_SCHEMA varchar(40),
                     TABLE_NAME varchar(40),
                     COLUMN_NAME varchar(50),
                     Comment varchar(50));
Declare @script varchar(5000);

set @script = '
    Select nc.TABLE_SCHEMA, nc.TABLE_NAME, nc.COLUMN_NAME, convert(varchar(20), ''--'') as Comment
    from {NEW}.INFORMATION_SCHEMA.COLUMNS nc LEFT join {OLD}.INFORMATION_SCHEMA.COLUMNS oc 
    on nc.TABLE_NAME = oc.TABLE_NAME and nc.COLUMN_NAME = oc.COLUMN_NAME
    UNION ALL
    Select oc.TABLE_SCHEMA, oc.TABLE_NAME, oc.COLUMN_NAME, ''DELETED COLUMN'' as Comment
    from {OLD}.INFORMATION_SCHEMA.COLUMNS oc
    where CONCAT(oc.TABLE_NAME, ''.'', oc.COLUMN_NAME) 
    not in (Select CONCAT(TABLE_NAME, ''.'', COLUMN_NAME) from {NEW}.INFORMATION_SCHEMA.COLUMNS)
';

Set @script = replace(@script, '{OLD}', @oldmodel);
Set @script = replace(@script, '{NEW}', @newmodel);

Insert into @Temp
    exec(@script);

Select * from @Temp where Comment <> '--'
ORDER by TABLE_NAME;
go








SELECT t.object_id
FROM destino.sys.tables t inner JOIN destino.sys.objects o ON t.object_id = o.object_id


-- DECLARE @DescriptionERROR VARCHAR(20)
-- DECLARE @nombre VARCHAR(10)
-- SELECT @DescriptionERROR = 'nombre invalido'
-- IF @nombre IS NULL OR RTRIM(LTRIM(@nombre))=''
-- BEGIN
--     THROW @DescriptionERROR
-- END

--no funca
-- USE origen
-- DECLARE hola CURSOR
-- FOR SELECT * FROM sys.tables

-- OPEN hola
-- FETCH NEXT FROM hola

-- CLOSE hola
-- DEALLOCATE hola






/*Insert Databases names into Temp Table*/
-- BEGIN TRY
-- DROP TABLE #DBRecovery
-- END TRY
-- BEGIN CATCH SELECT 1 END CATCH
 
-- SELECT ROWNUM = ROW_NUMBER() OVER (ORDER BY sys.databases),
-- 		DBName = name,
-- 		RecoveryModel = recovery_model_desc
-- INTO #DBRecovery
-- FROM sys.databases
-- WHERE recovery_model_desc NOT IN ('Simple')
 
-- /*Declare Variables*/
-- DECLARE @DBNAME NVARCHAR(100),
-- 		@RECOVERYMODE NVARCHAR(100),
-- 		@MAXRECORD INT,
-- 		@CURRENTRECORD INT,
-- 		@SQLL NVARCHAR(MAX)
 
-- /*Initialize Variables*/
-- SET @MAXRECORD = (SELECT MAX(ROWNUM) FROM [#DBRecovery])
-- SET @CURRENTRECORD = 1
-- SET @SQLL = ''
 
-- /*BEGIN LOOP*/
-- WHILE @CURRENTRECORD <= @MAXRECORD
 
-- BEGIN
-- 	SELECT @DBNAME = '['+DBName+']'
-- 	FROM #DBRecovery
-- 	WHERE [ROWNUM] = @CURRENTRECORD
 
-- 	/*Build Command*/
-- 	SET @SQLL = 'ALTER DATABASE ' + @DBNAME + ' SET RECOVERY SIMPLE'
 
-- 	EXEC sys.sp_executesql @SQLL
 
-- /*Next Record*/
-- SET @CURRENTRECORD = @CURRENTRECORD + 1
 
-- END
-- DROP TABLE #DBRecovery
 
DECLARE @hola VARCHAR(20), @wea NVARCHAR(MAX),@v bit=0
SET @hola = 'destino'

set @wea = 'SELECT NAME FROM '+ @hola + '.sys.tables'
EXEC sp_executesql @wea, @v=1
if (@v=1)
    PRINT 'hola'


/*---------------------------------------------------*/


ALTER TABLE hola3 ALTER COLUMN campo2 varchar(10)  

SELECT right(name,2)
FROM origen.sys.tables

DECLARE @n VARCHAR(10)=''
SET @n='SELECT t.name
    FROM origen.sys.tables t
    WHERE t.name Like ''%S'''
if(@n ='')
    PRINT 'god'
ELSE
    Print 'nombre la tabla en prural'