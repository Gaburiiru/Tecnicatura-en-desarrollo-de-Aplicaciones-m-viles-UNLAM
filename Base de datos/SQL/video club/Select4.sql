--1. Informar los géneros que no tuvieron películas alquiladas
SELECT G.Descripcion
FROM Genero_Pelicula G
WHERE NOT EXISTS (SELECT 1
                FROM  Pelicula P INNER JOIN Alquiler A
                ON P.cod_pel = A.cod_pel_A AND P.id_Genero_P = G.id_Genero);

--2. Informar los géneros que tienen películas pero que no registran alquileres
SELECT DISTINCT G.Descripcion
FROM Genero_Pelicula G INNER JOIN Pelicula P
ON G.id_Genero = P.id_Genero_P
WHERE NOT EXISTS (SELECT 1
                    FROM Alquiler A
                    where A.cod_pel_A = P.cod_pel)

--3. Se desea conocer los clientes que devolvieron la película con una demora mayor al promedio de los alquileres.
SELECT C.nombre
FROM Alquiler A INNER JOIN Cliente C
ON A.id_Cliente_A = C.id_Cliente
HAVING AVG(A.fecha_Dev)

--4. Informar las películas que no fueron alquiladas por el cliente con DNI 2222
SELECT P.titulo
FROM Pelicula P
WHERE NOT EXISTS (SELECT 1
                    FROM Cliente C INNER JOIN Alquiler A
                    ON C.id_Cliente = A.id_Cliente_A
                    WHERE P.cod_pel = A.cod_pel_A AND C.nro_doc = 2222);

--5. Informar el género con mayor recaudación
SELECT G.Descripcion,SUM(A.importe_Alquiler) AS GANANCIAS
FROM Alquiler A, Genero_Pelicula G, Pelicula P
WHERE A.cod_pel_A = P.cod_pel AND G.id_Genero = P.id_Genero_P
GROUP BY G.Descripcion
HAVING MAX(A.importe_Alquiler) > 1
ORDER BY G.Descripcion DESC

--6. Se desea conocer el detalle de las películas que nunca se alquilaron
SELECT *
FROM Pelicula P
WHERE NOT EXISTS (SELECT 1
                    FROM Alquiler A
                    WHERE P.cod_pel = A.cod_pel_A);

--7. Se desea conocer el detalle de los clientes que nunca han realizado alquileres.
SELECT *
FROM Cliente C
WHERE NOT EXISTS (SELECT 1
                    FROM Alquiler A
                    WHERE C.id_Cliente = A.id_Cliente_A);

--8. Informar los códigos de películas coincidentes entre el cliente con DNI 2222 y DNI 3333
SELECT cod_pel_A
FROM Alquiler A INNER JOIN Cliente C
ON A.id_Cliente_A = C.id_Cliente
WHERE C.nro_doc = 3333
INTERSECT
SELECT cod_pel_A
FROM Alquiler A INNER JOIN Cliente C
ON A.id_Cliente_A = C.id_Cliente
WHERE C.nro_doc = 2222

--9. Informar los clientes que realizaron mas del promedio de alquileres
SELECT C.nombre,AVG(A.importe_Alquiler) AS GANANCIAS
FROM Alquiler A, Cliente C
WHERE A.id_Cliente_A = C.id_Cliente
GROUP BY C.nombre
HAVING MAX(A.importe_Alquiler) > 1
ORDER BY C.nombre DESC