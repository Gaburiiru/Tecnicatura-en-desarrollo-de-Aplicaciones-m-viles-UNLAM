/*1)	Scripts de creación de todas las tablas. 
a.	En estas sentencias de creación son importantes los tipos de datos, primary key y foreign key.
*/
--DROP DATABASE biblioteca;
CREATE DATABASE biblioteca;

CREATE TABLE Provincia(
    ID_provincia INT NOT NULL,
    Descripcion VARCHAR(20) NOT NULL,
    CONSTRAINT ID_provincia_PK PRIMARY KEY (ID_provincia)
);

CREATE TABLE Localidad(
    ID_localidad INT NOT NULL,
    Descripcion VARCHAR(20) NOT NULL,
    ID_provincia INT NOT NULL,
    CONSTRAINT ID_provincia_FK FOREIGN KEY (ID_provincia) REFERENCES Provincia(ID_provincia),
    CONSTRAINT ID_localidad_PK PRIMARY KEY (ID_localidad)   
);

CREATE TABLE Categoria(
    ID_categoria INT NOT NULL,
    Descripcion VARCHAR(20) NOT NULL,
    CONSTRAINT ID_categoria_PK PRIMARY KEY (ID_categoria)
);

CREATE TABLE Editorial(
    ID_editorial INT NOT NULL,
    Nombre VARCHAR(20) NOT NULL,
    Direccion VARCHAR(20) NOT NULL, 
    Telefono VARCHAR(10) NOT NULL,
    ID_localidad_edi INT NOT NULL,
    CONSTRAINT ID_editorial_PK PRIMARY KEY (ID_editorial),
    CONSTRAINT ID_localidad_edi_FK FOREIGN KEY (ID_localidad_edi) REFERENCES Localidad(ID_localidad)
);

CREATE TABLE Libro(
    ID_libro INT NOT NULL,
    Titulo VARCHAR(20) NOT NULL,
    Descripcion VARCHAR(20) NOT NULL, 
    ID_editorial_lib INT NOT NULL,
    ID_categoria_lib INT NOT NULL,
    CONSTRAINT ID_libro_PK PRIMARY KEY (ID_libro),
    CONSTRAINT ID_editorial_lib_FK FOREIGN KEY (ID_editorial_lib) REFERENCES Editorial(ID_editorial),
    CONSTRAINT ID_categoria_lib_FK FOREIGN KEY (ID_categoria_lib) REFERENCES Categoria(ID_categoria)
);

CREATE TABLE Persona(
    ID_persona INT NOT NULL,
    Nombre VARCHAR(20) NOT NULL,
    Apellido VARCHAR(20) NOT NULL, 
    Direccion VARCHAR(20) NOT NULL, 
    Telefono VARCHAR(10) NOT NULL,
    ID_localidad_per INT NOT NULL,
    CONSTRAINT ID_persona_PK PRIMARY KEY (ID_persona),
    CONSTRAINT ID_localidad_per_FK FOREIGN KEY (ID_localidad_per) REFERENCES Localidad(ID_localidad)
);

CREATE TABLE Autor(
    CONSTRAINT ID_persona_aut_FK FOREIGN KEY (ID_persona_aut) REFERENCES Persona(ID_persona),
    ID_persona_aut INT NOT NULL,
    Referencia VARCHAR(20) NOT NULL,
    CONSTRAINT ID_persona_aut_PK PRIMARY KEY (ID_persona_aut)
);

CREATE TABLE Alumno(
    CONSTRAINT ID_persona_alum_FK FOREIGN KEY (ID_persona_alum) REFERENCES Persona(ID_persona),
    ID_persona_alum INT NOT NULL,
    Anio_ingreso DATETIME NOT NULL,
    Anio_cursa INT NOT NULL,
    Turno VARCHAR(10) NOT NULL,
    Divicion VARCHAR(10) NOT NULL,
    CONSTRAINT ID_persona_alum_PK PRIMARY KEY (ID_persona_alum)
);

CREATE TABLE Docente(
    CONSTRAINT ID_persona_doc_FK FOREIGN KEY (ID_persona_doc) REFERENCES Persona(ID_persona),
    ID_persona_doc INT NOT NULL,
    Anio_ingreso DATETIME NOT NULL,
    Titulo VARCHAR(20) NOT NULL,
    CONSTRAINT ID_persona_doc_PK PRIMARY KEY (ID_persona_doc)
);

CREATE TABLE Autor_libro(
    CONSTRAINT ID_persona_aut_lib_FK FOREIGN KEY (ID_persona_aut_lib) REFERENCES Persona(ID_persona),
    CONSTRAINT ID_libro_aut_lib_FK FOREIGN KEY (ID_libro_aut_lib) REFERENCES Libro(ID_libro),
    ID_persona_aut_lib INT NOT NULL,
    ID_libro_aut_lib INT NOT NULL,
    CONSTRAINT ID_autor_libro_PK PRIMARY KEY (ID_persona_aut_lib,ID_libro_aut_lib)
);

CREATE TABLE Prestamo(
    CONSTRAINT ID_persona_pres_FK FOREIGN KEY (ID_persona_pres) REFERENCES Persona(ID_persona),
    CONSTRAINT ID_libro_pres_FK FOREIGN KEY (ID_libro_pres) REFERENCES Libro(ID_libro),
    ID_persona_pres INT NOT NULL,
    ID_libro_pres INT NOT NULL,
    Fecha_prestamo DATETIME,
    Fecha_devolucion DATETIME,
    CONSTRAINT ID_prestamo_PK PRIMARY KEY (ID_persona_pres,ID_libro_pres)
);