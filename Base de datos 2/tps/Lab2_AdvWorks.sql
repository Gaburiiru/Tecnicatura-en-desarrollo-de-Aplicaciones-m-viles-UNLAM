/*1. Listar los nombres de los productos y el nombre del modelo
que posee asignado. Solo listar aquellos que tengan asignado
algún modelo. */
SELECT PP.Name, PM.Name
FROM Production.Product PP JOIN Production.ProductModel PM
ON PP.ProductModelID = PM.ProductModelID;

/*2. Mostrar “todos” los productos junto con el modelo que tenga
asignado. En el caso que no tenga asignado ningún modelo,
mostrar su nulidad.*/
SELECT PP.Name, PM.Name
FROM Production.Product PP LEFT JOIN Production.ProductModel PM
on PP.ProductModelID = PM.ProductModelID;

/*3. Ídem Ejercicio2, pero en lugar de mostrar nulidad, mostrar la
palabra “Sin Modelo” para indicar que el producto no posee un
modelo asignado. */
SELECT PP.Name, ISNULL(PM.Name,'sin modelo')
FROM Production.Product PP LEFT JOIN Production.ProductModel PM
on PP.ProductModelID = PM.ProductModelID;

/*4. Contar la cantidad de Productos que poseen asignado cada
uno de los modelos. */
SELECT PM.Name as model, COUNT(PP.Name) as total_productos
FROM Production.Product PP JOIN Production.ProductModel PM
ON PP.ProductModelID = PM.ProductModelID
group BY PM.Name;

/*5. Contar la cantidad de Productos que poseen asignado cada
uno de los modelos, pero mostrar solo aquellos modelos que
posean asignados 2 o más productos. */
SELECT PM.Name as model, COUNT(PP.Name) as total_productos
FROM Production.Product PP JOIN Production.ProductModel PM
ON PP.ProductModelID = PM.ProductModelID
group BY PM.Name
HAVING count(PP.Name) >= 2;

/*6. Contar la cantidad de Productos que poseen asignado un
modelo valido, es decir, que se encuentre cargado en la tabla
de modelos. Realizar este ejercicio de 3 formas posibles:*/ 
--“inner join”
SELECT COUNT(PP.Name) as total_productos
FROM Production.Product PP INNER JOIN Production.ProductModel PM
ON PP.ProductModelID = PM.ProductModelID;

--“in” 
SELECT COUNT(PP.Name) as total_productos
FROM Production.Product PP
WHERE PP.ProductModelID in (SELECT 1
                            FROM Production.ProductModel PM
                            WHERE PP.ProductModelID = PM.ProductModelID);

--“exists” 
SELECT COUNT(PP.Name) as total_productos
FROM Production.Product PP
WHERE EXISTS (SELECT 1
                FROM Production.ProductModel PM
                WHERE PP.ProductModelID = PM.ProductModelID);

/*7. Contar cuantos productos poseen asignado cada uno de los
modelos, es decir, se quiere visualizar el nombre del modelo y
la cantidad de productos asignados. Si algún modelo no posee
asignado ningún producto, se quiere visualizar 0 (cero). */
SELECT PM.Name as model, ISNULL(COUNT(PP.Name),0) as total_productos
FROM Production.Product PP RIGHT JOIN Production.ProductModel PM
ON PP.ProductModelID = PM.ProductModelID
group BY PM.Name;

/*8. Se quiere visualizar, el nombre del producto, el nombre
modelo que posee asignado, la ilustración que posee asignada
y la fecha de última modificación de dicha ilustración y el
diagrama que tiene asignado la ilustración. Solo nos interesan
los productos que cuesten más de $150 y que posean algún
color asignado.*/
SELECT PP.Name, PM.Name, PMI.IllustrationID, PMI.ModifiedDate, PIL.Diagram
FROM Production.Product PP, Production.ProductModel PM,
 Production.ProductModelIllustration PMI, Production.Illustration PIL
WHERE PP.ProductModelID = PM.ProductModelID and PM.ProductModelID = PMI.ProductModelID
 and PIL.IllustrationID = PMI.IllustrationID and PP.ListPrice > 150 and PP.Color is not null;

/*9. Mostrar aquellas culturas que no están asignadas a ningún
producto/modelo.
(Production.ProductModelProductDescriptionCulture) */
SELECT PMDC.CultureID
FROM Production.ProductModelProductDescriptionCulture PMDC
where PMDC.ProductModelID not in (SELECT 1
                                    FROM Production.ProductModel PM, Production.Product PP
                                    WHERE PM.ProductModelID = PP.ProductModelID);

/*10. Agregar a la base de datos el tipo de contacto “Ejecutivo de
Cuentas” (Person.ContactType) */
INSERT INTO Person.ContactType (Name) VALUES ('Ejecutivo de Cuentas');
SELECT PC.Name
FROM Person.ContactType PC

/*11. Agregar la cultura llamada “nn” – “Cultura Moderna”.*/
INSERT INTO Production.Culture (CultureID,Name) VALUES ('nn','Cultura Moderna');
SELECT PC.CultureID,PC.Name
FROM Production.Culture PC

/*12. Cambiar la fecha de modificación de las culturas Spanish,
French y Thai para indicar que fueron modificadas hoy.*/
UPDATE Production.Culture
SET ModifiedDate = '2022-09-22 00:00:00.000'
WHERE Name = 'Spanish';
UPDATE Production.Culture
SET ModifiedDate = '2022-09-22 00:00:00.000'
WHERE Name = 'French';
UPDATE Production.Culture
SET ModifiedDate = '2022-09-22 00:00:00.000'
WHERE Name = 'Thai';
SELECT *
FROM Production.Culture PC

/*13. En la tabla Production.CultureHis agregar todas las culturas
que fueron modificadas hoy. (Insert/Select). */
--no hay una tabla "Production.CultureHis" en la bdd adventureWorks

/*14. Al contacto con ID 10 colocarle como nombre “Juan Perez”. */
UPDATE Person.Person
SET FirstName = 'juan',LastName = 'Perez'
WHERE BusinessEntityID = 10;

SELECT PP.FirstName, PP.LastName
FROM Person.Person PP
ORDER BY PP.BusinessEntityID;

/*15. Agregar la moneda “Peso Argentino” con el código “PAR”
(Sales.Currency) */
INSERT INTO Sales.Currency (Name,CurrencyCode) VALUES ('Peso Argentino','PAR');

SELECT SC.Name, SC.CurrencyCode
FROM Sales.Currency SC
WHERE SC.Name LIKE '%argentino%';

/*16. ¿Qué sucede si tratamos de eliminar el código ARS
correspondiente al Peso Argentino? ¿Por qué?*/
DELETE FROM Sales.Currency WHERE CurrencyCode='ARS';
--no te deja borrarla porque es una llave foranea FK de otra tabla.

SELECT SC.Name, SC.CurrencyCode
FROM Sales.Currency SC

/*17. Realice los borrados necesarios para que nos permita eliminar
el registro de la moneda con código ARS. */
DELETE FROM Sales.CurrencyRate WHERE ToCurrencyCode = 'ARS';
DELETE FROM Sales.CountryRegionCurrency WHERE CurrencyCode = 'ARS';
DELETE FROM Sales.Currency WHERE CurrencyCode = 'ARS';

/*18. Eliminar aquellas culturas que no estén asignadas a ningún
producto (Production.ProductModelProductDescriptionCulture) */
DELETE FROM Production.ProductModelProductDescriptionCulture WHERE CultureID in
    (SELECT PMDC.CultureID
    FROM Production.ProductModelProductDescriptionCulture PMDC
    where PMDC.ProductModelID not in (SELECT 1
                                        FROM Production.ProductModel PM, Production.Product PP
                                        WHERE PM.ProductModelID = PP.ProductModelID));

