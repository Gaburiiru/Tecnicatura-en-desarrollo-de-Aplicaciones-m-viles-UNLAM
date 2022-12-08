CREATE DATABASE MusicaDB ON PRIMARY
( NAME = 'Musica',
FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Musica.mdf' ,
SIZE = 4096KB ,
MAXSIZE = 20480KB ,
FILEGROWTH = 1024KB
)
 LOG ON
( NAME = 'Musica_log',
FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Musica_log.ldf' ,
SIZE = 2048KB ,
MAXSIZE = 10240KB ,
FILEGROWTH = 10%
);
/*2.1. �Qu� se ha definido como pol�tica de retenci�n de log?
se establecio un size,maxsize y filegrowth.

2.2. �Se crear�n estad�sticas autom�ticamente?
no. falto agregar AUTO_CREATE_STATISTICS.

2.3. �Ser� compatible con una base de datos de SQL Server 2000?
si es compatible,pero se debe cambiar al uso de las vistas de cat�logo.

2.4. �Cu�l es el juego de caracteres que se utilizar� y qu� significa?
no tiene un Collate.
*/

/*3. Crear el esquema discos. */
CREATE SCHEMA Discos;

/*4. Se desea crear el siguiente modelo relacional. Recordar que se deben crear
cada una de las tablas involucradas y de sus relaciones. */
/*creacion de tablas*/
USE MusicaDB;
CREATE TABLE Discos.Artista(
 artno smallint NOT NULL,
 nombre varchar(50) NOT NULL,
 clasificacion char(1) NULL,
 bio text NULL,
 foto image null,
 CONSTRAINT Artista_PK PRIMARY KEY (artno)
);
CREATE TABLE Discos.Concierto(
 artno_conc smallint NOT NULL,
 fecha datetime NOT NULL,
 cuidad varchar(25) NOT NULL,
 CONSTRAINT artno_conc_FK FOREIGN KEY (artno_conc) REFERENCES Discos.Artista(artno),
 CONSTRAINT concierto_PK PRIMARY KEY (artno_conc,fecha)
);
CREATE TABLE Discos.Album(
 itemno smallint NOT NULL,
 artno_art smallint NOT NULL,
 titulo varchar(50),
 CONSTRAINT artno_PK PRIMARY KEY (itemno),
 CONSTRAINT artno_art_FK FOREIGN KEY (artno_art) REFERENCES Discos.Artista(artno)
);
CREATE TABLE Discos.Stock(
 itemno_stock smallint NOT NULL,
 artno_art smallint NOT NULL,
 titulo varchar(50) NULL,
 CONSTRAINT itemno_stock_FK FOREIGN KEY (itemno_stock) REFERENCES Discos.Album(itemno),
 CONSTRAINT stock_PK PRIMARY KEY (itemno_stock)
);
CREATE TABLE Discos.Orden(
 itemno_orden smallint NOT NULL,
 times_tamp timestamp NOT NULL,
 CONSTRAINT itemno_orden_FK FOREIGN KEY (itemno_orden) REFERENCES Discos.Album(itemno),
 CONSTRAINT orden_PK PRIMARY KEY (itemno_orden)
);

/*5. Crear un diagrama con el modelo relacional generado. */

/*6. Realizar los siguientes cambios en el modelo:
6.1. Cambiar el tama�o de campo ciudad en la tabla ciudad para que sea de 30 en lugar de 25.*/
ALTER TABLE Discos.Concierto
ALTER COLUMN cuidad VARCHAR(30);

/*6.2. En la tabla de Stock, colocar el precio con un valor por defecto en 0(cero).*/
ALTER TABLE Discos.Stock ADD precio INT;
ALTER TABLE Discos.Stock ADD DEFAULT 0 FOR precio;

/*6.3. En la tabla de �lbumes el nombre del t�tulo no puede ser nulo.*/
ALTER TABLE Discos.Albunes
ALTER COLUMN titulo varchar(50) NOT NULL;

/*7. Agregar los siguientes registros dentro de la base de datos creada:
- 3 artistas*/
INSERT INTO Discos.Artista (artno,nombre,clasificacion,bio,foto) VALUES (1,'gustavo cerati',1,'musico y compositor',NULL),
                                                                        (2,'charly garcia',2,'musico y compositor',NULL),
                                                                        (3,'luis alberto spinetta',3,'musico y compositor',NULL);

/*- 2 conciertos por cada uno de los artistas en diferentes fechas y ciudades*/
INSERT INTO Discos.Concierto (artno_conc,fecha,cuidad) VALUES (1,'2022/12/01','quilmes'),
                                                              (1,'2023/01/01','bahia blanca'),
                                                              (2,'2022/12/20','La plata'),
                                                              (2,'2023/02/01','quilmes'),
                                                              (3,'2022/11/25','La plata'),
                                                              (3,'2023/03/01','lanus');

/*- 2 �lbumes por cada uno de los artistas*/
INSERT INTO Discos.Album (itemno,artno_art,titulo) VALUES (1,1,'bocanada'),
                                                          (2,1,'fuerza natural'),
                                                          (3,2,'piano bar'),
                                                          (4,2,'clics modernos'),
                                                          (5,3,'artaud'),
                                                          (6,3,'don lucero');

/*- Stock s�lo de 2 �lbumes de diferentes artistas */
INSERT INTO Discos.Stock (itemno_stock,artno_art,titulo,precio) VALUES (1,1,'bocanada',NULL),
                                                                       (2,2,'piano bar',NULL);