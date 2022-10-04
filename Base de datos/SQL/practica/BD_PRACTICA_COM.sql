--DROP DATABASE PRACTICAXD;
--CREATE DATABASE PRACTICAXD;
USE PRACTICAXD;
CREATE TABLE Almacen(
    nro SMALLINT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    responsable VARCHAR(30) NOT NULL
    CONSTRAINT nro_pk PRIMARY KEY(nro)
);

CREATE TABLE Articulo(
    cod_art SMALLINT NOT NULL,
    descripcion VARCHAR(30) NOT NULL,
    precio FLOAT NOT NULL,
    CONSTRAINT cod_art_pk PRIMARY KEY(cod_art)
);
 		
CREATE TABLE Material(
    cod_mat SMALLINT NOT NULL,
    descripcion VARCHAR(30) NOT NULL,
    CONSTRAINT cod_mat_pk PRIMARY KEY(cod_mat)
);

CREATE TABLE Ciudad(
    cod_ciu SMALLINT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    CONSTRAINT cod_ciu_pk PRIMARY KEY(cod_ciu)
);

CREATE TABLE Proveedor(
    cod_prov SMALLINT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    domicilio VARCHAR(50) NOT NULL,
    cod_ciu_C SMALLINT NOT NULL,
    fecha_alta DATE NOT NULL,
    CONSTRAINT cod_prov_pk PRIMARY KEY(cod_prov),
    CONSTRAINT cod_ciu_C_fk FOREIGN KEY (cod_ciu_C) REFERENCES Ciudad(cod_ciu)
);

CREATE TABLE Contiene(
    nro_C SMALLINT NOT NULL,
    cod_art_C SMALLINT NOT NULL,
    CONSTRAINT id_contiene_pk PRIMARY KEY(nro_C,cod_art_C),
    CONSTRAINT nro_C_fk FOREIGN KEY (nro_C) REFERENCES Almacen(nro),
    CONSTRAINT cod_art_C_fk FOREIGN KEY (cod_art_C) REFERENCES Articulo(cod_art)
);

CREATE TABLE Compuesto_por(
    cod_art_C SMALLINT NOT NULL,
    cod_mat_C SMALLINT NOT NULL,
    CONSTRAINT id_compuesto_pk PRIMARY KEY(cod_art_C,cod_mat_C),
    CONSTRAINT cod_art_Con_fk FOREIGN KEY (cod_art_C) REFERENCES Articulo(cod_art),
    CONSTRAINT cod_mat_Con_fk FOREIGN KEY (cod_mat_C) REFERENCES Material(cod_mat)
);

CREATE TABLE Provisto_por(
    cod_mat_P SMALLINT NOT NULL,
    cod_prov_P SMALLINT NOT NULL,
    CONSTRAINT id_provisto_por_pk PRIMARY KEY(cod_mat_P,cod_prov_P),
    CONSTRAINT cod_mat_P_fk FOREIGN KEY (cod_mat_P) REFERENCES Material(cod_mat),
    CONSTRAINT cod_prov_P_fk FOREIGN KEY (cod_prov_P) REFERENCES Material(cod_mat)
);