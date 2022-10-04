--1. Listar todas las películas y la descripción del género de cada una
SELECT P.titulo AS titPel, G.Descripcion As Descrip
FROM Pelicula P INNER JOIN Genero_Pelicula G
ON P.id_Genero_P = G.id_Genero
ORDER BY P.titulo;

--2. Informar Nombre, Fecha de Nacimiento y Descripción de la localidad, de todos los clientes de San Justo y Ramos Mejía
SELECT C.nombre,C.fecha_Nac,L.Descripcion
FROM Cliente C INNER JOIN Localidad L
ON C.id_Localidad_C = L.id_Localidad
WHERE L.Descripcion = 'SAN JUSTO' OR L.Descripcion = 'RAMOS MEJIA';

--3. Listar el Nombre y género de las películas que fueron alquiladas en algún momento, ordenadas por descripción del género y fecha de alquiler
SELECT P.titulo, G.Descripcion
FROM Pelicula P, Genero_Pelicula G, Alquiler A
WHERE P.cod_pel = A.cod_pel_A AND G.id_Genero = P.id_Genero_P;

--4. Listar el Nombre y género de las películas que nunca fueron alquiladas
SELECT P.titulo, G.Descripcion
FROM Pelicula P JOIN Genero_Pelicula G
ON P.id_Genero_P = G.id_Genero
where NOT EXISTS (SELECT 1
                    FROM alquiler A
                    WHERE P.cod_pel = A.cod_pel_A);

--5. Listar el nombre de los clientes que tardaron mas de un día en devolver alguna película alquilada
SELECT C.nombre ,DATEDIFF(day,A.fecha,A.fecha_Dev) AS Dias
FROM Alquiler A INNER JOIN Cliente C
ON A.id_Cliente_A = C.id_Cliente
WHERE DATEDIFF(day,A.fecha,A.fecha_Dev) > 1

--6. Listar el nombre de la película, y el nombre del proveedor que la provee, ordenado por nombre del proveedor.
SELECT PR.nombre,P.titulo
FROM Pelicula P INNER JOIN Proveedor PR
ON P.CUIT_prov = PR.CUIT
ORDER BY PR.nombre;

--7. Listar el tipo y número de documento, de los clientes que alquilaron alguna comedia
SELECT C.tipo_doc, C.nro_doc
FROM Cliente C, Alquiler A, Genero_Pelicula G,Pelicula P
WHERE G.Descripcion = 'COMEDIA'AND G.id_Genero = P.id_Genero_P AND P.cod_pel = A.cod_pel_A AND C.id_Cliente = A.id_Cliente_A;

--8. Listar el género, Nombre y fecha de alquiler, de todas las películas alquiladas, ordenado por género, y nombre
SELECT G.Descripcion, P.titulo, A.fecha
FROM Genero_Pelicula G, Pelicula P, Alquiler A
WHERE G.id_Genero = P.id_Genero_P AND P.cod_pel = A.cod_pel_A
ORDER BY G.Descripcion, P.titulo;

--9. Informar Nombre de película, fecha de alquiler y nombre de cliente, de todos los alquileres del mes de Septiembre 2021
SELECT P.titulo, A.fecha, C.nombre
FROM Pelicula P, Alquiler A, Cliente C
WHERE P.cod_pel = A.cod_pel_A AND C.id_Cliente = A.id_Cliente_A 
AND A.fecha BETWEEN ('2021/09/01') AND ('2021/09/30');

--10.Para cada cliente, informar el id y nombre del titular de su cuenta
SELECT CT.id_cliente AS ID,C.id_cliente AS ID_CLIENTE_TIT, C.nombre AS NOM_CLIENTE_TIT
FROM Cliente CT LEFT JOIN Cliente C
ON C.id_Cliente = CT.id_cliente_tit
ORDER BY CT.id_Cliente;

--11.Para cada cliente, informar el id y nombre del titular de su cuenta, si es que tiene
SELECT C.id_cliente, C.nombre
FROM Cliente C JOIN Cliente CT
ON C.id_Cliente = CT.id_cliente_tit;                                                                                                                                                                                            

--12.Listar el nombre de las películas, alquiladas del mes de Septiembre,
-- que hayan sido realizados por los clientes de San Justo que viven en la calle Arieta
SELECT P.titulo
FROM Pelicula P JOIN Alquiler A
ON P.cod_pel = A.cod_pel_A
WHERE A.fecha BETWEEN ('2021/09/01') AND ('2021/09/30') AND EXISTS (SELECT 1
                                                                FROM Cliente C JOIN Localidad L
                                                                ON C.id_Localidad_C = L.id_Localidad
                                                                WHERE C.domicilio_Calle = 'ARIETA' AND L.Descripcion ='SAN JUSTO');
