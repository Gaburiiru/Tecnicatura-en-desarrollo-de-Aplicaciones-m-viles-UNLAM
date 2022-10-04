--1. Listar todos los clientes que tienen un titular en su cuenta
SELECT *
FROM Cliente C
WHERE C.id_cliente_tit IS NOT NULL
--2. Listar todos los clientes que no tienen titular en su cuenta
SELECT *
FROM Cliente C
WHERE C.id_cliente_tit IS NULL
--3. Listar el código y título de las películas del proveedor con CUIT 33665465410 ordenado por código
SELECT cod_pel, titulo
FROM Pelicula 
WHERE CUIT_prov = 33665465410
ORDER BY cod_pel ASC
--4. Listar el código y titulo de las películas que empiezan con la letra M
SELECT cod_pel, titulo
FROM Pelicula
WHERE titulo LIKE 'M%'
--5. Listar la fecha de cada alquiler y el importe cobrado
SELECT fecha, importe_Alquiler
FROM Alquiler
--6. Listar todos los alquileres del mes de enero y febrero, ordenados por fecha de alquiler
SELECT *
FROM Alquiler
WHERE fecha BETWEEN '20210101' AND '20210231'
ORDER BY fecha
--7. Listar todos los alquileres que duraron mas de un día (NOTA: Puede utilizarse la función DATEDIFF para obtener la diferencia entre dos fechas)
SELECT *
FROM Alquiler
WHERE fecha < fecha_Dev
--8. Listar el id de los clientes que alquilaron la película A6
SELECT id_Cliente_A
FROM Alquiler
WHERE cod_pel_A = 'A6'
