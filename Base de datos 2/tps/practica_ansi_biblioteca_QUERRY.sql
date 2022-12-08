--3)	Consultas SQL:
/*a.	Listar todas las personas que viven en Buenos Aires. Ordenar por nombre de persona.*/
SELECT P.Nombre,P.Apellido
FROM  Persona P,Localidad L,Provincia Pr
WHERE Pr.Descripcion = 'Buenos Aires' AND P.ID_localidad_per = L.ID_localidad AND L.ID_provincia = Pr.ID_provincia;

/*b.	Listar los libros, con sus respectivos autores (para el caso de autor mostrar datos de persona y autor). Ordenar por nombre de libro.*/
SELECT L.Titulo,P.Nombre, A.Referencia
FROM  Persona P,Libro L,Autor A,Autor_libro AL
WHERE P.ID_persona = A.ID_persona_aut AND L.ID_libro = AL.ID_libro_aut_lib;

/*c.	Listar todas las personas (de cualquier tipo) que viven en Buenos Aires. Mostrar solo los datos generales de personas. Ordenar por nombre de persona.*/
SELECT P.Nombre, P.Apellido,P.Direccion,P.Telefono
FROM  Persona P,Localidad L,Provincia Pr
WHERE Pr.Descripcion = 'Buenos Aires' AND ID_localidad_per = L.ID_localidad AND Pr.ID_provincia = L.ID_provincia
ORDER BY P.Nombre DESC;

/*d.	Listar todas las personas y según su tipo los datos correspondientes (Autor, docente o alumno). Ordenar por nombre de persona. */
SELECT DISTINCT P.Nombre,P.Apellido, P.Direccion, P.Telefono,
CASE
    WHEN A.ID_persona_aut = P.ID_persona THEN 'autor'
    WHEN Alu.ID_persona_alum = P.ID_persona THEN 'alumno'
    ELSE 'docente'
END AS tipo
FROM  Persona P, Autor A, Alumno Alu,Docente D
WHERE P.ID_persona = A.ID_persona_aut OR P.ID_persona = Alu.ID_persona_alum OR P.ID_persona = D.ID_persona_doc
ORDER BY P.Nombre;

/*e.	Listar todas las personas, agrupadas por tipo. Mostrar solo los datos generales de personas y su tipo. */
SELECT DISTINCT P.Nombre,P.Apellido, P.Direccion, P.Telefono,
CASE
    WHEN A.ID_persona_aut = P.ID_persona THEN 'autor'
    WHEN Alu.ID_persona_alum = P.ID_persona THEN 'alumno'
    ELSE 'docente'
END AS tipo
FROM  Persona P, Autor A, Alumno Alu,Docente D
WHERE P.ID_persona = A.ID_persona_aut OR P.ID_persona = Alu.ID_persona_alum OR P.ID_persona = D.ID_persona_doc
ORDER BY tipo;

/*f.	Contabilizar la cantidad de personas de cada tipo.*/
SELECT DISTINCT CASE
    WHEN A.ID_persona_aut = P.ID_persona THEN 'autor'
    WHEN Alu.ID_persona_alum = P.ID_persona THEN 'alumno'
    ELSE 'docente'
END AS tipo
, COUNT(CASE  WHEN A.ID_persona_aut = P.ID_persona THEN 'autor'
              WHEN Alu.ID_persona_alum = P.ID_persona THEN 'alumno'
              ELSE 'docente' END) AS contador
FROM  Persona P, Autor A, Alumno Alu,Docente D
WHERE P.ID_persona = A.ID_persona_aut OR P.ID_persona = Alu.ID_persona_alum OR P.ID_persona = D.ID_persona_doc
GROUP BY P.ID_persona,A.ID_persona_aut,Alu.ID_persona_alum,D.ID_persona_doc;

/*g.	Listar todos los prestamos realizados. Mostrar datos del préstamo, nombre y apellido de la persona, datos del libro, datos de la editorial, categoría del libro y datos del autor.*/
SELECT Pe.Nombre, Pe.Apellido,L.Titulo, CASE
                                        WHEN A.ID_persona_aut = Pe.ID_persona Then Pe.Nombre ELSE 'Samuel Perez' END AS autor, E.Direccion, C.Descripcion
FROM Prestamo Pr, Persona Pe, Libro L, Editorial E, Categoria C, Autor A 
WHERE Pr.ID_persona_pres = Pe.ID_persona and Pr.ID_libro_pres = L.ID_libro and L.ID_editorial_lib = E.ID_editorial and L.ID_categoria_lib = C.ID_categoria ;

/*h.	Listar los docentes que son autores. Para dichos docentes mostrar los datos de persona, los de docentes y los de autor.*/
SELECT P.Nombre AS docentes_no_son_autores, D.Titulo
FROM Docente D,Autor A, Persona P
WHERE D.ID_persona_doc = P.ID_persona AND NOT A.ID_persona_aut = P.ID_persona;

SELECT P.Nombre, D.Titulo, A.Referencia
FROM Docente D,Autor A, Persona P
WHERE D.ID_persona_doc = P.ID_persona AND A.ID_persona_aut = P.ID_persona;

/*i.	Listar todos los libros que alguna vez fueron prestados.*/
SELECT L.Titulo
FROM Libro L,Prestamo P
WHERE L.ID_libro = P.ID_libro_pres;

/*j.	Listar todos los libros que nunca fueron prestados.*/
SELECT L.Titulo
FROM Libro L
where L.ID_libro in (SELECT 1
                     FROM Prestamo P
                     WHERE P.ID_libro_pres = L.ID_libro);

/*k.	Listar los autores de libros que alguna vez hayan realizado un préstamo.*/
SELECT DISTINCT CASE WHEN Pe.ID_persona <> P.ID_persona_pres Then Pe.Nombre ELSE 'no se realizo prestamo' END AS autor
FROM Persona Pe,Prestamo P
WHERE Pe.ID_persona = P.ID_persona_pres;

/*l.	Listar los alumnos que realizaron préstamos. Mostrar datos del alumno, del préstamo y libros.*/
SELECT P.Nombre,P.Apellido, A.Turno, A.Divicion,PR.Fecha_prestamo,L.Titulo
FROM Alumno A,Libro L, Persona P,Prestamo PR
WHERE P.ID_persona = A.ID_persona_alum AND PR.ID_persona_pres = A.ID_persona_alum AND L.ID_libro = PR.ID_libro_pres;

/*m.	Listar los préstamos de personas de la provincia de Buenos aires. Mostrar los datos del prestamos, de las personas y localidad.*/
SELECT P.Nombre,P.Apellido,PR.Fecha_prestamo,PRO.Descripcion,L.Descripcion
FROM Provincia PRO,Localidad L, Persona P,Prestamo PR
WHERE P.ID_persona = PR.ID_persona_pres AND L.ID_provincia = P.ID_localidad_per AND PRO.ID_provincia = L.ID_provincia AND PRO.Descripcion = 'Buenos Aires';

/*n.	Listar todos los préstamos que se realizaron en el periodo de 1/7/2022 hasta 1/9/2022. Mostrar datos de personas en general. En el caso de docentes mostrar los datos del mismo.*/
SELECT *
FROM Prestamo P
WHERE P.Fecha_prestamo BETWEEN '2022/7/1' AND '2022/9/1';

/*o.	Listar todos los préstamos que se realizaron en el periodo de 1/7/2022 hasta 1/9/2022 agrupados por personas.*/
SELECT P.ID_persona_pres,P.ID_libro_pres,P.Fecha_prestamo,P.Fecha_devolucion,PE.Nombre
FROM Prestamo P,Persona PE
WHERE P.ID_persona_pres = PE.ID_persona AND P.Fecha_prestamo BETWEEN '2022/7/1' AND '2022/9/1'
ORDER BY PE.Nombre;

/*p.	Mostrar la cantidad de préstamos realizados por persona.*/
SELECT COUNT(P.ID_persona_pres) AS cant_prestamos,PE.Nombre
FROM Prestamo P,Persona PE
WHERE P.ID_persona_pres = PE.ID_persona
GROUP BY PE.Nombre;

/*q.	Mostrar la cantidad de préstamos realizados por alumno.*/
SELECT COUNT(P.ID_persona_pres) AS cant_prestamos,PE.Nombre
FROM Prestamo P,Persona PE,Alumno A
WHERE P.ID_persona_pres = PE.ID_persona AND A.ID_persona_alum = PE.ID_persona
GROUP BY PE.Nombre;

/*r.	Mostrar la cantidad de veces que fue prestado cada libro.*/
SELECT COUNT(P.ID_libro_pres) AS cant_prestamos,L.Titulo
FROM Prestamo P,Libro L
WHERE P.ID_libro_pres = L.ID_libro
GROUP BY L.Titulo;

/*s.	Mostrar lo datos del libro más solicitado.*/
SELECT AVG(P.ID_libro_pres) AS libro_mas_solicitado,L.Titulo
FROM Prestamo P,Libro L
WHERE P.ID_libro_pres = L.ID_libro
GROUP BY L.Titulo;

/*t.	Mostrar los datos del autor que escribió más libros.*/
SELECT AVG(AL.ID_persona_aut_lib) AS autor_mas_libros,P.Nombre,A.Referencia
FROM Autor A,Libro L,Autor_libro AL,Persona P
WHERE AL.ID_libro_aut_lib = L.ID_libro AND AL.ID_persona_aut_lib = A.ID_persona_aut AND P.ID_persona = AL.ID_persona_aut_lib 
GROUP BY P.Nombre,A.Referencia;

/*u.	Mostrar la categoría de libros más solicitada.*/
SELECT AVG(P.ID_libro_pres) AS categoría_más_solicitada,C.Descripcion
FROM Prestamo P,Libro L,Categoria C
WHERE P.ID_libro_pres = L.ID_libro AND L.ID_categoria_lib = C.ID_categoria 
GROUP BY C.Descripcion;

