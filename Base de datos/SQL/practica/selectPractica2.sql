--1) LISTAR NOMBRES Y PRECIOS DE TODOS LOS PRODUCTOS
SELECT P.NOMBRE, P.PRECIO
FROM PRODUCTO P
--2) LISTA TODAS LAS COLUMNAS DE LA TABLA PRODUCTO
SELECT *
FROM PRODUCTO

--3) Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD).
--USD OFICIAL: 117 --> 100.8/117
--EURO OFICIAL: 122 --> 100.8/122

SELECT P.NOMBRE,P.PRECIO/122 AS euro ,P.PRECIO /117 AS dolar
FROM PRODUCTO P

--4) Lista los nombres y los precios de todos los productos de la tabla producto, que terminen con las letras ESA.
SELECT P.NOMBRE, P.PRECIO
FROM PRODUCTO P
WHERE P.NOMBRE LIKE '%ESA'

--5) Lista los nombres y los precios de todos los productos de la tabla producto, que comiencen con A
SELECT P.NOMBRE, P.PRECIO
FROM PRODUCTO P
WHERE P.NOMBRE LIKE 'A%'

--6) Lista el nombre de todos los fabricantes en una columna, y en otra columna obtenga en mayúsculas los dos primeros caracteres del nombre del fabricante.
SELECT F.NOMBRE,UPPER(SUBSTRING(F.NOMBRE,1,2))
FROM FABRICANTE F

--7) Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.
SELECT P.NOMBRE,P.PRECIO, ROUND(P.PRECIO) AS REDONDEO
FROM PRODUCTO P

--8) Lista los nombres y los precios de todos los productos de la tabla producto, truncando el valor del precio para mostrarlo sin ninguna cifra decimal.
SELECT P.NOMBRE,P.PRECIO ,TRUNCATE(P.PRECIO,0) AS PrecioTruncado
FROM PRODUCTO P

--9) Lista el código de los fabricantes que tienen productos en la tabla producto.
SELECT F.CODIGO
FROM FABRICANTE F, PRODUCTO P
WHERE F.CODIGO = P.CODIGO_FAB

--10) Lista los nombres de los fabricantes ordenados de forma ascendente
SELECT F.NOMBRE
FROM FABRICANTE F
ORDER BY F.NOMBRE ASC

--11) Lista los nombres de los fabricantes ordenados de forma descendente

--12) Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.

--13) Devuelve una lista con las 5 primeras filas de la tabla fabricante. SELECT *

--14) Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y LIMIT 1)

--15) Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y LIMIT 1)

--16) Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.

--17) Lista el nombre de los productos que tienen un precio menor o igual a 1€.

--18) Lista todos los productos que tengan un precio entre 1€ y 3€. Sin utilizar el operador BETWEEN.

--19) Lista todos los productos que tengan un precio entre 1€ y 3€. Utilizando el operador BETWEEN.

--20) Lista todos los productos que tengan un precio mayor que 2€ y que el código de fabricante sea igual a 004.
