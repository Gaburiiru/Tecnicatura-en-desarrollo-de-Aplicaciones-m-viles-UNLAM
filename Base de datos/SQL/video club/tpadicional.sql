--Informar la cantidad y el importe de alquileres recaudado para el género “Acción”
SELECT COUNT(P.cod_pel) AS cantidad, SUM(A.importe_Alquiler) AS importe_recaudado
FROM Pelicula P INNER JOIN Alquiler A
ON P.cod_pel = A.cod_pel_A
WHERE EXISTS (SELECT 1
                FROM  Genero_Pelicula G
                WHERE  G.Descripcion = 'ACCION' AND P.id_Genero_P = G.id_Genero) 

--Informar la cantidad de películas que nunca se alquiló
SELECT COUNT(P.cod_pel) AS Pel_nunca_alquiladas
FROM Pelicula P
WHERE NOT EXISTS (SELECT 1
                FROM Alquiler A
                WHERE P.cod_pel = A.cod_pel_A);

-- Se desea conocer cuantas películas y de cuantos géneros distintos provee cada proveedor
SELECT PR.nombre,COUNT(P.titulo) AS PELIS, COUNT(DISTINCT G.Descripcion) AS GENEROS
FROM Proveedor PR, Pelicula P,Genero_Pelicula G
WHERE PR.CUIT = P.CUIT_prov AND P.id_Genero_P = G.id_Genero
GROUP BY PR.nombre;

--Informar Nombre, Fecha de Nacimiento y Descripción de la localidad,
-- de todos los clientes de San Justo y Ramos Mejía
SELECT C.nombre,C.fecha_Nac,L.Descripcion
FROM Cliente C INNER JOIN Localidad L
ON C.id_Localidad_C = L.id_Localidad
WHERE L.Descripcion = 'SAN JUSTO' OR L.Descripcion = 'RAMOS MEJIA'
ORDER BY L.Descripcion;

--Listar el tipo y número de documento, de los clientes que alquilaron alguna película infantil
SELECT DISTINCT C.tipo_doc, C.nro_doc
FROM Cliente C INNER JOIN Alquiler A
ON C.id_Cliente = A.id_Cliente_A
WHERE EXISTS (SELECT 1
                FROM  Genero_Pelicula G INNER JOIN Pelicula P
                ON G.id_Genero = P.id_Genero_P
                WHERE  G.Descripcion = 'INFANTIL' AND P.cod_pel = A.cod_pel_A)

--Listar el nombre de las películas, alquiladas del mes de octubre 2022, que hayan sido
-- realizados por los clientes de San Justo que viven en la calle América
SELECT P.titulo
FROM Pelicula P INNER JOIN Alquiler A
ON P.cod_pel = A.cod_pel_A
WHERE A.fecha BETWEEN '2022/10/01' AND '2022/10/31' AND EXISTS (SELECT 1
                                                                FROM Cliente C INNER JOIN Localidad L
                                                                ON C.id_Localidad_C = L.id_Localidad
                                                                WHERE L.Descripcion = 'SAN JUSTO' AND C.domicilio_Calle = 'América')

--Informar los códigos de películas coincidentes entre el cliente con DNI 3333 y DNI 4444
SELECT cod_pel_A
FROM Alquiler A INNER JOIN Cliente C
ON A.id_Cliente_A = C.id_Cliente
WHERE C.nro_doc = 3333
INTERSECT
SELECT cod_pel_A
FROM Alquiler A INNER JOIN Cliente C
ON A.id_Cliente_A = C.id_Cliente
WHERE C.nro_doc = 4444

--Informar el género con menor recaudación
SELECT G.Descripcion,SUM(A.importe_Alquiler) AS GANANCIAS
FROM Alquiler A, Genero_Pelicula G, Pelicula P
WHERE A.cod_pel_A = P.cod_pel AND G.id_Genero = P.id_Genero_P
GROUP BY G.Descripcion
HAVING MIN(A.importe_Alquiler) > 1

-- Se desea conocer el detalle de las películas que nunca se alquilaron
SELECT *
FROM Pelicula P
WHERE NOT EXISTS (SELECT 1
                    FROM Alquiler A
                    WHERE P.cod_pel = A.cod_pel_A);

--Cual fue el valor Minimo cobrado en los alquileres
SELECT MIN(importe_Alquiler) AS Alquiler_minimo
FROM Alquiler;