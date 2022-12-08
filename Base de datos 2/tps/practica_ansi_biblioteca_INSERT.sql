/*2)	Inserción de registros en todas las tablas.
a.	Sentencias de INSERT para las diferentes tablas. Se pide al alumno que inserte ejemplos significativos para la prueba de las consultas.
*/
USE Biblioteca;
INSERT INTO Provincia(ID_provincia,Descripcion) VALUES (1,'Buenos Aires'),
                                                       (2,'Entre rios'),
                                                       (3,'Formosa'),
                                                       (4,'Jujuy'),
                                                       (5,'Misiones');

INSERT INTO Localidad(ID_localidad,Descripcion,ID_provincia) VALUES (1,'La matanza',1),
                                                                    (2,'Federacion',2),
                                                                    (3,'Palo santo',3),
                                                                    (4,'San Salvador Jujuy',4),
                                                                    (5,'El dorado',5);

INSERT INTO Categoria(ID_categoria,Descripcion) VALUES (1,'Biografía'),
                                                       (2,'DRAMA'),
                                                       (3,'DRAMA ROMANTICO'),
                                                       (4,'COMEDIA'),
                                                       (5,'NOVELA');

INSERT INTO Editorial(ID_editorial,Nombre,Direccion,Telefono,ID_localidad_edi) VALUES   (1,'AUSTRAL','Calle 10 No. 9 - 78','5927949000',1),
                                                                                        (2,'ALIENTA EDITORIAL','Carrera 56A No. 51','5116060000',2),
                                                                                        (3,'BOOKET','Calle 33B  No. 38','8852052000',3),
                                                                                        (4,'CLICK EDICIONES','Calle 16 No. 23-57','3581397000',4),
                                                                                        (5,'CROSSBOOKS','Carrera 7A No. 32','6223452000',5);

INSERT INTO Libro(ID_libro,Titulo,Descripcion,ID_editorial_lib,ID_categoria_lib) VALUES (1,'¡Absalom, Absalom!','NOVELA',1,5),
                                                                                        (2,'Divina comedia','COMEDIA',2,2),
                                                                                        (3,'Orgullo y prejuicio','DRAMA ROMANTICO',3,3),
                                                                                        (4,'Papá Goriot','NOVELA',4,5),
                                                                                        (5,'El extranjero','DRAMA',5,2);

INSERT INTO Persona(ID_persona,Nombre,Apellido,Direccion,Telefono,ID_localidad_per) VALUES  (1,'Juan','Acosta','Calle 28 No. 8-69','7583527950',1),
                                                                                            (2,'Pedro','Aznar','Carrera 7A No. 32','5719173000',2),
                                                                                            (3,'Ramon','Houston','Calle 7 No. 5-25','7236158000',3),
                                                                                            (4,'Romina','Rodriguez','Carrera 9 No. 7-34','6733643000',4),
                                                                                            (5,'Samuel','Perez','Calle 20 No. 3-22','4210220000',5);

INSERT INTO Autor(ID_persona_aut,Referencia) VALUES (5,'MODERNO');

INSERT INTO Alumno(ID_persona_alum,Anio_ingreso,Anio_cursa,Turno,Divicion) VALUES   (1,'2019/5/1',1,'Vespertino','a1'),
                                                                                    (2,'2018/8/19',3,'Vespertino','b2');

INSERT INTO Docente(ID_persona_doc,Anio_ingreso,Titulo) VALUES  (3,'2020/5/3','profesorado lengua'),
                                                                (4,'2021/6/5','profesorado fisica');

INSERT INTO Autor_libro(ID_persona_aut_lib,ID_libro_aut_lib) VALUES (5,1),
                                                                    (5,2),
                                                                    (5,3),
                                                                    (5,4),
                                                                    (5,5);

INSERT INTO Prestamo(ID_persona_pres,ID_libro_pres,Fecha_prestamo,Fecha_devolucion) VALUES  (1,3,'2022/8/19','2022/9/19'),
                                                                                            (3,1,'2022/9/11','2022/9/30'),                                                                                            
                                                                                            (2,5,'2022/7/11','2022/7/30'),
                                                                                            (4,4,'2022/9/1','2022/10/10');

