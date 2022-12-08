--1- Listar los c�digos y descripciones de todos los productos
SELECT ProductNumber, Name
FROM  Production.Product;
--2- Listar los datos de la subcategor�a n�mero 17
SELECT *
FROM Production.ProductSubCategory
WHERE ProductSubcategoryID = 17;
--3- Listar los productos cuya descripci�n comience con D
SELECT P.Name
FROM  Production.Product P
WHERE P.Name LIKE 'D%';
--4- Listar las descripciones de los productos cuyo n�mero finalice con 8
SELECT P.ProductNumber
FROM  Production.Product P
WHERE P.ProductNumber LIKE '%8';
/*5- Listar aquellos productos que posean un color asignado. Se
deber�n excluir todos aquellos que no posean ning�n valor*/
SELECT *
FROM  Production.Product P
WHERE P.Color IS NOT NULL;
/*6- Listar el c�digo y descripci�n de los productos de color Black
(Negro) y que posean el nivel de stock en 500.*/
SELECT P.Name, P.ProductNumber 
FROM  Production.Product P
WHERE P.Color = 'Black' AND P.SafetyStockLevel >= 500;
--7- Listar los productos que sean de color Black (Negro) � Silver (Plateado).
SELECT *
FROM  Production.Product P
WHERE P.Color = 'Black' OR P.Color = 'Silver';
/*8- Listar los diferentes colores que posean asignados los
productos. S�lo se deben listar los colores.*/
SELECT DISTINCT P.Color
FROM  Production.Product P
WHERE P.Color IS NOT NULL;
/*9- Contar la cantidad de categor�as que se encuentren cargadas
en la base. (Ayuda: count) */
SELECT COUNT(PC.Name) AS cant_de_categorias
FROM  Production.ProductCategory PC;
/*10- Contar la cantidad de subcategor�as que posee asignada la
categor�a 2. */
SELECT COUNT(PSC.Name) AS cant_de_sub_categorias
FROM  Production.ProductSubcategory PSC;
/*11- Listar la cantidad de productos que existan por cada uno de los
colores.*/
SELECT P.Color ,COUNT(P.Name) as cant_colores
FROM  Production.Product P
WHERE P.Color is not NULL
GROUP BY P.Color;
/*12- Sumar todos los niveles de stocks aceptables que deben existir
para los productos con color Black. (Ayuda: sum) */
SELECT SUM(P.SafetyStockLevel) as Stock_black
FROM Production.Product P
WHERE P.Color = 'black';
/*13- Calcular el promedio de stock que se debe tener de todos los
productos cuyo c�digo se encuentre entre el 316 y 320.
(Ayuda: avg) */
SELECT AVG(P.SafetyStockLevel) as Promedio_Stock_Product
FROM Production.Product P
WHERE P.ProductID >= 316 AND P.ProductID <= 320;
/*14- Listar el nombre del producto y descripci�n de la subcategor�a
que posea asignada. (Ayuda: inner join) */
SELECT P.Name, PS.Name as descripcion
FROM Production.Product P INNER JOIN Production.ProductSubcategory PS
ON P.ProductSubcategoryID = PS.ProductSubcategoryID;
/*15- Listar todas las categor�as que poseen asignado al menos una
subcategor�a. Se deber�n excluir aquellas que no posean
ninguna.*/
SELECT DISTINCT PC.Name as categoria
FROM Production.ProductCategory PC INNER JOIN Production.ProductSubcategory PS
ON PC.ProductCategoryID = PS.ProductCategoryID;
/*16- Listar el c�digo y descripci�n de los productos que posean fotos
asignadas. (Ayuda: Production.ProductPhoto)*/
SELECT P.ProductID as codigo ,P.Name as descripcion
FROM Production.Product P INNER JOIN Production.ProductPhoto PP
ON P.ProductModelID = PP.ProductPhotoID;
/*17- Listar la cantidad de productos que existan por cada una de las
Clases (Ayuda: campo Class) */
SELECT P.Class ,COUNT(P.Name) as cant_Product
FROM  Production.Product P
--WHERE P.Class is not NULL
GROUP BY P.Class;
/*18- Listar la descripci�n de los productos y su respectivo color. S�lo
nos interesa caracterizar al color con los valores: Black, Silver
u Otro. Por lo cual si no es ni silver ni black se debe indicar
Otro. (Ayuda: utilizar case). */
SELECT P.Name as descripcion_product,
CASE
	WHEN P.Color = 'black' THEN 'negro'
	WHEN P.Color = 'silver' THEN 'gris'
	ELSE 'otro'
END as color
FROM  Production.Product P;
/*19- Listar el nombre de la categor�a, el nombre de la subcategor�a
y la descripci�n del producto. (Ayuda: join) */
SELECT PS.Name, P.Name, PC.Name
FROM Production.Product P, Production.ProductSubcategory PS, Production.ProductCategory PC
WHERE P.ProductSubcategoryID = PS.ProductSubcategoryID AND PC.ProductCategoryID = PS.ProductCategoryID;
/*20- Listar la cantidad de subcategor�as que posean asignado los
productos. (Ayuda: distinct). */
SELECT DISTINCT P.Name ,COUNT(PS.Name) as cantidad_sub_categorias
FROM  Production.ProductSubcategory PS, Production.Product P
WHERE P.ProductSubcategoryID = PS.ProductSubcategoryID
GROUP BY P.Name