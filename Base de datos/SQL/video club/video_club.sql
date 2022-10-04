-- DROP DATABASE video_club;
-- CREATE DATABASE video_club;
-- USE video_club;

CREATE TABLE Localidad (
    id_Localidad SMALLINT,
	CP INT(4) NOT NULL,
    Descripcion VARCHAR(40) NOT NULL,

    CONSTRAINT id_Localidad_pk PRIMARY KEY (id_Localidad)
);

CREATE TABLE Cliente (
    id_Cliente SMALLINT,
    tipo_doc CHAR(3) NOT NULL,
    nro_doc VARCHAR(15) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    telefono VARCHAR(10),
    domicilio_Calle VARCHAR(30) NOT NULL,
    domicilio_Nun INT NOT NULL,
    domicilio_Piso INT,
    domicilio_Dep VARCHAR(4),
    id_Localidad_C SMALLINT,
    fecha_Nac DATE NOT NULL,
    id_cliente_tit SMALLINT,

    CONSTRAINT id_Cliente_pk PRIMARY KEY (id_Cliente),
    CONSTRAINT id_Cliente_tit_fk FOREIGN KEY (id_cliente_tit) REFERENCES Cliente(id_Cliente),
    CONSTRAINT id_Localidad_fk FOREIGN KEY (id_Localidad_C) REFERENCES Localidad(id_Localidad)
);

CREATE TABLE Proveedor (
    CUIT BIGINT(11) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    domicilio VARCHAR(20),
    telefono INT(8) NOT NULL,
    mail VARCHAR(40),

    CONSTRAINT CUIT_pk PRIMARY KEY (CUIT)
);

CREATE TABLE Genero_Pelicula (
    id_Genero SMALLINT NOT NULL,
    Abreviatura VARCHAR(10) NOT NULL,
    Descripcion VARCHAR(40) NOT NULL,
    
    CONSTRAINT id_Genero_pk PRIMARY KEY (id_Genero)
);

CREATE TABLE Pelicula (
    cod_pel VARCHAR(4),
    titulo VARCHAR(20) NOT NULL,
    id_Genero_P SMALLINT NOT NULL,
    CUIT_prov BIGINT,

    CONSTRAINT cod_pel_pk PRIMARY KEY (cod_pel),
    CONSTRAINT CUIT_prov_fk FOREIGN KEY (CUIT_prov) REFERENCES Proveedor(CUIT),
    CONSTRAINT id_Genero_P_fk FOREIGN KEY (id_Genero_P) REFERENCES Genero_Pelicula(id_Genero)
);

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