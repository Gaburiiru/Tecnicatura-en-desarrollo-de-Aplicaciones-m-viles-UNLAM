--1. Listar la cantidad total de películas
SELECT COUNT(titulo) AS CantPel
FROM Pelicula;

--2. Se desea conocer cuantas películas alquiló cada cliente. Ordenar la información por nombre del cliente
SELECT C.nombre, COUNT(*) AS CantPel
FROM cliente C JOIN alquiler A 
ON C.id_Cliente = A.id_Cliente_A
GROUP BY C.nombre;

--3. Se desea conocer cuantas películas distintas alquiló cada cliente. 
SELECT C.nombre, COUNT(DISTINCT id_Cliente_A) AS Pel
FROM cliente C JOIN alquiler A 
ON C.id_Cliente = A.id_Cliente_A
GROUP BY C.nombre;

--4. Cual fue el valor máximo cobrado en los alquileres
SELECT MAX(importe_Alquiler)
FROM Alquiler;

--5. Cuantos clientes han devuelto la película con una demora de mas de dos días
SELECT DATEDIFF(dd, fecha, fecha_Dev) AS ClientesConDemora
FROM Alquiler A
WHERE dd > 2;

--6. Informar el importe total de alquileres recaudado por película, ordenado por título de película
SELECT P.titulo, SUM(importe_Alquiler) AS importeTotal
FROM Pelicula P INNER JOIN Alquiler A
ON P.cod_pel = A.cod_pel_A
GROUP BY P.titulo;

--7. Informar el importe total de alquileres recaudado por género
SELECT G.Descripcion, SUM(importe_Alquiler) AS importeTotal
FROM Genero_Pelicula G INNER JOIN Alquiler A LEFT JOIN pelicula P 
ON G.id_Genero = P.id_Genero_P
GROUP BY G.Descripcion;

--8. Informar la cantidad de películas que nunca se alquiló
SELECT COUNT(DISTINCT cod_pel) AS peliculaNuncaSeAlquilaron
FROM Pelicula P LEFT JOIN Alquiler A 
ON P.cod_pel = A.cod_pel_A
WHERE A.cod_pel_A IS NULL

--9. Informar la cantidad de películas que nunca se alquiló, por género
SELECT G.Abreviatura,COUNT(P.cod_pel) AS Pel
FROM Pelicula P JOIN Genero_Pelicula G
ON P.id_Genero_P = G.id_Genero
where NOT EXISTS (SELECT 1
                    FROM alquiler A
                    WHERE P.cod_pel = A.cod_pel_A)
GROUP BY G.Descripcion;

--10.Informar la cantidad y el importe de alquileres recaudado para el género “Comedia”
SELECT COUNT(p.cod_pel)AS CantAlquiladas , sum(A.importe_Alquiler) AS Ganacias
FROM Genero_Pelicula G, Alquiler A, Pelicula P
WHERE  G.Descripcion = 'COMEDIA' AND G.id_Genero = P.id_Genero_P AND A.cod_pel_A = P.cod_pel;

--11.Informar el máximo importe abonado por cada cliente
SELECT C.nombre,MAX(A.importe_Alquiler) AS importeMaximo
FROM Alquiler A INNER JOIN Cliente C
ON A.id_Cliente_A = C.id_Cliente
GROUP BY C.nombre;

--12.Informar cuantos géneros no tienen ninguna película en el Video Club
SELECT G.Descripcion
FROM Genero_Pelicula G
where NOT EXISTS (SELECT 1
                    FROM Pelicula P
                    WHERE P.id_Genero_P = G.id_Genero)
GROUP BY G.Descripcion;

--13.Se desea conocer cuantas películas y de cuantos géneros distintos provee cada proveedor
SELECT PR.nombre,COUNT(P.titulo) AS PELIS, COUNT(DISTINCT G.Descripcion) AS GENE
FROM Proveedor PR, Pelicula P,Genero_Pelicula G
WHERE PR.CUIT = P.CUIT_prov AND P.id_Genero_P = G.id_Genero
GROUP BY PR.nombre;

--14.Se desea conocer la cantidad de alquileres y el importe recaudado por mes en alquileres durante todo el año 2021 (FUNCION MONTH)
SELECT COUNT(*) AS cantAl, SUM(A.importe_Alquiler) AS importe
FROM Alquiler A
WHERE A.fecha BETWEEN ('2021/01/01') AND ('2021/12/31');

--15.Se desea conocer la cantidad de veces que se alquiló cada película 
--(informar cero para las que nunca se alquilaron)
SELECT P.titulo,COUNT(A.cod_pel_A) AS SeAlquilo
FROM Alquiler A, Pelicula P
WHERE A.cod_pel_A = P.cod_pel
GROUP BY titulo;