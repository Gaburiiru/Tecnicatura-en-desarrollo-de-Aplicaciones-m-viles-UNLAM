DROP DATABASE video_club;
CREATE DATABASE video_club;
USE video_club;

CREATE TABLE Cliente (
    id_Cliente SMALLINT,
    tipo_doc CHAR(3) NOT NULL,
    nro_doc VARCHAR(15) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    domicilio VARCHAR(20) NOT NULL,
    edad INT NOT NULL,
    id_cliente_tit SMALLINT,

    CONSTRAINT id_Cliente_pk PRIMARY KEY (id_Cliente),
    CONSTRAINT id_Cliente_tit_fk FOREIGN KEY (id_cliente_tit) REFERENCES Cliente(id_Cliente)
);

CREATE TABLE Localidad (
    id_Localidad SMALLINT,
	CP INT(4) NOT NULL,
    Descripcion VARCHAR(40) NOT NULL,
    id_Cliente_L SMALLINT,

    CONSTRAINT id_Localidad_pk PRIMARY KEY (id_Localidad)
);

CREATE TABLE Proveedor (
    CUIT SMALLINT,
    nombre VARCHAR(40) NOT NULL,
    domicilio VARCHAR(20) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    mail VARCHAR(20) NOT NULL,

    CONSTRAINT CUIT_pk PRIMARY KEY (CUIT)
);

CREATE TABLE Pelicula (
    cod_pel SMALLINT,
    titulo VARCHAR(20) NOT NULL,
    genero VARCHAR(20) NOT NULL,
    CUIT_prov SMALLINT,

    CONSTRAINT cod_pel_pk PRIMARY KEY (cod_pel),
    CONSTRAINT CUIT_prov_fk FOREIGN KEY (CUIT_prov) REFERENCES Proveedor(CUIT)
);

CREATE TABLE Genero_Pelicula (
    id_Genero SMALLINT,
    id_Genero_P SMALLINT,
    Abreviatura VARCHAR(5) NOT NULL,
    Descripcion VARCHAR(40) NOT NULL,
    
    CONSTRAINT id_Genero_pk PRIMARY KEY (id_Genero)
);

CREATE TABLE Alquiler (
    id_alquiler SMALLINT,
    cod_pel_A SMALLINT,
    id_Cliente_A SMALLINT,
    fecha DATETIME  NOT NULL,

    CONSTRAINT id_alquiler_pk PRIMARY KEY (id_alquiler),
    CONSTRAINT cod_pel_A_fk FOREIGN KEY (cod_pel_A) REFERENCES Pelicula(cod_pel),
    CONSTRAINT id_Cliente_A_fk FOREIGN KEY (id_Cliente_A) REFERENCES Cliente(id_Cliente)

);