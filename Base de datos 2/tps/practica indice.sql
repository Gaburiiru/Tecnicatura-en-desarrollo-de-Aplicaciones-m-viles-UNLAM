--tabla sin primary key
CREATE TABLE empTest1 ( 
empId INT, 
empNombre VARCHAR(1000))

SELECT OBJECT_NAME(i.id) AS tabla, i.name AS iName, i.indid AS iId
FROM sysindexes AS i
GO

INSERT INTO empTest1 VALUES(4, REPLICATE ('a', 1000))
GO
INSERT INTO empTest1 VALUES(6, REPLICATE ('a', 1000))
GO
INSERT INTO empTest1 VALUES(1, REPLICATE ('a', 1000))
GO
INSERT INTO empTest1 VALUES(3, REPLICATE ('a', 1000))
GO

SELECT empID FROM empTest1
GO

DBCC TRACEON(3604)-- imprimir la salida en la ventana de consulta
GO
DECLARE @DBID Int, @TableID Int
SELECT @DBID = DB_ID(), @TableID = OBJECT_ID('empTest1')
DBCC ind(@DBID, @TableID, -1)--El comando lista todas las páginas que se asignan a un índice
GO

DBCC TRACEON (3604)
GO
Declare @DBID Int
Select @DBID = db_id() 
DBCC page(@DBID, 1, 9653, 3)
GO

CREATE UNIQUE NONCLUSTERED INDEX empTest1_empId
ON empTest1(empId)
GO

DBCC TRACEON (3604) 
GO
Declare @DBID Int, @TableID Int
Select @DBID = db_id(), @TableID = object_id('empTest1')
DBCC ind(@DBID, @TableID, -1)
GO

INSERT INTO empTest1 VALUES(8, REPLICATE ('a', 1000))
GO
INSERT INTO empTest1 VALUES(7, REPLICATE ('a', 1000))
GO
INSERT INTO empTest1 VALUES(2, REPLICATE ('a', 1000))
GO
INSERT INTO empTest1 VALUES(10, REPLICATE ('a', 1000))
GO
INSERT INTO empTest1 VALUES(5, REPLICATE ('a', 1000))
GO
INSERT INTO empTest1 VALUES(9, REPLICATE ('a', 1000))
GO

ALTER TABLE empTest1 ADD EmpIndex Int IDENTITY(1,1)
GO
CREATE UNIQUE CLUSTERED INDEX clust_emp ON empTest1 (EmpIndex)
GO

DBCC TRACEON (3604) 
GO
Declare @DBID Int, @TableID Int
Select @DBID = db_id(), @TableID = object_id('empTest1')
DBCC ind(@DBID, @TableID, -1)
GO

CREATE TABLE empTest2 (
    EmpId INT,

    EmpName VARCHAR(1000)
)
GO
INSERT INTO empTest2 VALUES (4, REPLICATE('a', 1000))
GO
INSERT INTO empTest2 VALUES (6, REPLICATE('a', 1000))
GO
INSERT INTO empTest2 VALUES (1, REPLICATE('a', 1000))
GO
INSERT INTO empTest2 VALUES (3, REPLICATE('a', 1000))
GO

DBCC TRACEON (3604)
GO
Declare @DBID Int, @TableID Int
Select @DBID = db_id(), @TableID = object_id('empTest2')
DBCC ind(@DBID, @TableID, -1)
GO

CREATE UNIQUE CLUSTERED INDEX empTest2_EmpIndex
ON empTest2 (EmpId)
GO

DBCC TRACEON (3604)
GO
Declare @DBID Int, @TableID Int
Select @DBID = db_id(), @TableID = object_id('empTest2')

DBCC ind(@DBID, @TableID, -1)
GO

INSERT INTO empTest2 VALUES (10, REPLICATE('a', 1000))
GO
INSERT INTO empTest2 VALUES (2, REPLICATE('a', 1000))
GO
INSERT INTO empTest2 VALUES (5, REPLICATE('a', 1000))
GO
INSERT INTO empTest2 VALUES (8, REPLICATE('a', 1000))
GO
INSERT INTO empTest2 VALUES (9, REPLICATE('a', 1000))
GO
INSERT INTO empTest2 VALUES (7, REPLICATE('a', 1000))
GO
