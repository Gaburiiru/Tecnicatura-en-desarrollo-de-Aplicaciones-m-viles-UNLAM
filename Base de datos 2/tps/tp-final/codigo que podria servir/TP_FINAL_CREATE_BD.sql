/*================	CREACION DE BDD DONDE ESTARAN LAS TABLAS	================*/
USE MASTER

IF EXISTS(select * from sys.databases where name='VIDEOCLUB')
	DROP DATABASE VIDEOCLUB
GO

CREATE DATABASE VIDEOCLUB
GO	
USE VIDEOCLUB
GO

/*CREAR TABLE*/
CREATE TABLE Localidad (
    id_Localidad SMALLINT,
    CP INT NOT NULL,
    Descripcion VARCHAR(40) NOT NULL,

    CONSTRAINT id_Localidad_pk PRIMARY KEY (id_Localidad)
);
GO
CREATE TABLE Cliente (
    id_Cliente SMALLINT,
    tipo_doc CHAR(3) NOT NULL,
    nro_doc VARCHAR(15) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    telefono VARCHAR(10),
    domicilio_Calle VARCHAR(30) NOT NULL,
    Domicilio_Nro INT NOT NULL,
    domicilio_Piso INT,
    Domicilio_Depto VARCHAR(4),
    id_Localidad_C SMALLINT,
    fecha_Nac DATE NOT NULL,
    id_cliente_tit SMALLINT,

    CONSTRAINT id_Cliente_pk PRIMARY KEY (id_Cliente),
    CONSTRAINT id_Cliente_tit_fk FOREIGN KEY (id_cliente_tit) REFERENCES Cliente(id_Cliente),
    CONSTRAINT id_Localidad_fk FOREIGN KEY (id_Localidad_C) REFERENCES Localidad(id_Localidad)
);
GO
CREATE TABLE Proveedor (
    CUIT NUMERIC NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    domicilio VARCHAR(20),
    telefono INT NOT NULL,
    mail VARCHAR(40),

    CONSTRAINT CUIT_pk PRIMARY KEY (CUIT)
);
GO
CREATE TABLE Genero_Pelicula (
    id_Genero SMALLINT NOT NULL,
    Abrev VARCHAR(10) NOT NULL,
    Descripcion VARCHAR(40) NOT NULL,
    
    CONSTRAINT id_Genero_pk PRIMARY KEY (id_Genero)
);
GO
CREATE TABLE Pelicula (
    cod_pel VARCHAR(4),
    titulo VARCHAR(50) NOT NULL,
    id_Genero_P SMALLINT NOT NULL,
    CUIT_prov NUMERIC,

    CONSTRAINT cod_pel_pk PRIMARY KEY (cod_pel),
    CONSTRAINT CUIT_prov_fk FOREIGN KEY (CUIT_prov) REFERENCES Proveedor(CUIT),
    CONSTRAINT id_Genero_P_fk FOREIGN KEY (id_Genero_P) REFERENCES Genero_Pelicula(id_Genero)
);
GO
CREATE TABLE Alquiler (
    cod_pel_A VARCHAR(4),
    id_Cliente_A SMALLINT,
    fecha DATE NOT NULL,
    fecha_Dev DATE NOT NULL,
    importe_Alquiler FLOAT,

    CONSTRAINT id_alquiler PRIMARY KEY (cod_pel_A,id_Cliente_A),
    CONSTRAINT cod_pel_A_fk FOREIGN KEY (cod_pel_A) REFERENCES Pelicula(cod_pel),
    CONSTRAINT id_Cliente_A_fk FOREIGN KEY (id_Cliente_A) REFERENCES Cliente(id_Cliente)
);
GO
/*INSERTAR DATOS*/
INSERT INTO proveedor(CUIT,nombre,domicilio,telefono,mail) VALUES (23252221117,'Distribuidora10','arieta1555',54662200,'hola@hotmail.com'),
                                                                (45254544571,'Juan Perez',NULL,23523256,NULL),
                                                                (3365465410,'Andres Gonzales',NULL,33665544,'andres@gmail.com');

INSERT INTO Localidad(id_localidad,CP,Descripcion)VALUES (1,1753,'VILLA LUZURIAGA'),
                                                        (2,1752,'LOMAS DEL MIRADOR'),
                                                        (3,1754,'SAN JUSTO'),
                                                        (4,1778,'CIUDAD EVITA'),
                                                        (5,1785,'ALDO BONZI'),
                                                        (6,1768,'CIUDAD MADERO'),
                                                        (7,1704,'RAMOS MEJIA');

INSERT INTO Genero_Pelicula(id_Genero,Abrev,Descripcion) VALUES	(1,'COM','COMEDIA'),
                                                                (2,'COMR','COMEDIA ROMANTICA'),
                                                                (3,'ACC','ACCION'),
                                                                (4,'AVE','AVENTURA'),
                                                                (5,'DRA','DRAMA'),
                                                                (6,'TER','TERROR'),
                                                                (7,'MUS','MUSICAL'),
                                                                (8,'CFIC','CIENCIA FICCION'),
                                                                (9,'BEL','BELICA'),
                                                                (10,'INF','INFANTIL'),
                                                                (11,'SUSP','SUSPENSO');

INSERT INTO pelicula(cod_pel,titulo,id_Genero_P,CUIT_prov)VALUES    ('A1','EL PADRINO',5,23252221117),
                                                                    ('A2','CINEMA PARADISO',5,23252221117),
                                                                    ('A3','FORREST GUMP',5,3365465410),
                                                                    ('A4','EL CLUB DE LA PELEA',5,3365465410),
                                                                    ('A5','MAGO DE OZ',7,45254544571),
                                                                    ('A6','CANTANDO BAJO LA LLUVIA',7,45254544571),
                                                                    ('A7','DIRTY DANCING',7,45254544571),
                                                                    ('A8','MOULING ROUGE',7,45254544571),
                                                                    ('A9','TOY STORY 1',10,3365465410),
                                                                    ('A10','RATATUILLE',10,3365465410),
                                                                    ('A11','UP',10,23252221117),
                                                                    ('A12','LA MASCARA',1,23252221117),
                                                                    ('A13','LOCO POR MARY',1,3365465410),
                                                                    ('A14','SCARY MOVIE',1,3365465410),
                                                                    ('A15','2001:ODISEA DEL ESPACIO',8,23252221117),
                                                                    ('A16','E.T EL EXTRATERRESTE',8,23252221117),
                                                                    ('A17','MATRIX',8,23252221117),
                                                                    ('A18','INDIANA JONE:EN BUSCA DEL ARCA PERDIDA',4,3365465410),
                                                                    ('A19','CUENTA CONMIGO',4,3365465410),
                                                                    ('A20','NAUFRAGO',4,3365465410),
                                                                    ('A21','SENDEROS DE GLORIA',9,23252221117),
                                                                    ('A22','LA VIDA ES BELLA',9,23252221117);
        
INSERT INTO Cliente  VALUES     (1,'DNI',1111,'JUAN',111223344,'ARIETA',1522,1,'A',1,'1995/5/1',NULL),
                                (2,'DNI',2222,'ANDRES',111234556,'ARIETA',3522,NULL,NULL,3,'1985/12/18',1),
                                (3,'DNI',3333,'MARCELA',111223355,'AVENIDA DE MAYO',522,4,'C',7,'1999/6/3',1),
                                (4,'DNI',4444,'JOSE',111234577,'BOLIVAR',650,6,'41',7,'1977/2/4',NULL),
                                (5,'DNI',5555,'DIEGO',111223399,'ROSALES',322,1,'A',7,'1979/9/8',NULL),
                                (6,'DNI',6666,'MAURO',NULL,'REPUBLICA DE CHILE',3052,NULL,NULL,3,'1996/11/5',NULL), 
                                (7,'DNI',7777,'KARINA',NULL,'JUJUY',3501,NULL,NULL,3,'1999/8/10',6),
                                (8,'DNI',8888,'VALERIA',111234556,'ALSINA',155,3,'C',7,'1987/4/5',NULL),
                                (9,'DNI',9999,'LARA',111234556,'REPUBLICA DE CHILE',155,NULL,NULL,1,'1999/9/10',NULL);
                                
INSERT INTO Alquiler VALUES     ('A5',2,'2021/05/02','2021/05/03',150),
                                ('A6',2,'2021/07/16','2021/07/17',300),
                                ('A12',3,'2021/09/29','2021/10/02',300),
                                ('A17',4,'2021/05/27','2021/05/28',150),
                                ('A20',3,'2021/09/25','2021/09/26',150),
                                ('A17',3,'2021/09/25','2021/09/26',150),
                                ('A20',7,'2021/07/17','2021/07/18',150),
                                ('A12',8,'2021/09/09','2021/09/11',250),
                                ('A19',3,'2021/06/26','2021/06/28',250),
                                ('A7',7,'2021/06/11','2021/06/14',300),
                                ('A8',2,'2021/09/09','2021/09/10',150),
                                ('A20',2,'2021/06/21','2021/06/22',150),
                                ('A12',7,'2021/06/10','2021/06/11',150),
                                ('A7',8,'2021/08/29','2021/08/30',150),
                                ('A6',9,'2021/07/17','2021/07/18',150),
                                ('A5',7,'2021/08/19','2021/08/21',250);
GO