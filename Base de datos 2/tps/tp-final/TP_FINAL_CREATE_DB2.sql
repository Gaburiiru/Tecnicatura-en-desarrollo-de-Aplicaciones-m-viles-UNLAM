/*================	CREACION DE DB================*/
USE MASTER
GO
IF EXISTS(select * from sys.databases where name='VIDEOCLUB2')
	DROP DATABASE VIDEOCLUB2
GO

CREATE DATABASE VIDEOCLUB2
GO	
USE VIDEOCLUB2
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