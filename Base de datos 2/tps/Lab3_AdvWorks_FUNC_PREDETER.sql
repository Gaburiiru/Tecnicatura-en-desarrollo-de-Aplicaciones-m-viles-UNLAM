/*Dada la base de datos AdventureWorks, realizar los siguientes enunciados:
1. Realizar una consulta que permita devolver la fecha y hora actual */
SELECT getdate() as fecha_actual

/*2. Realizar una consulta que permita devolver únicamente el año y mes actual:*/
SELECT SUBSTRING(CONVERT(VARCHAR,getdate()),7,5) as AÑO,SUBSTRING(CONVERT(VARCHAR,getdate()),1,3) as MES

/*3. Realizar una consulta que permita saber cuántos días faltan para el día de la
primavera (21-Sep) */
SELECT DATEDIFF(DAY, SUBSTRING(CONVERT(VARCHAR,getdate()),1,11), '20220921')

/*4. Realizar una consulta que permita redondear el número 385,86 con
únicamente 1 decimal. */
SELECT CONVERT(INT,385,86)

/*5. Realizar una consulta permita saber cuánto es el mes actual al cuadrado. Por
ejemplo, si estamos en Junio, sería 62*/
/*SELECT SUBSTRING(CONVERT(VARCHAR,getdate()),1,3) as MES
SELECT LEFT(getdate(),4) as MES
SELECT POWER ( CONVERT(float,left(getdate(),4)) , 2 )*/

/*6. Devolver cuál es el usuario que se encuentra conectado a la base de datos */
EXEC sp_who2;

SELECT SESSION_USER usuario_BD_sesion, 
       CURRENT_USER usuario_BD_actual, 
       SYSTEM_USER  usuario_sistema, 
       ORIGINAL_LOGIN() login_usado_inicialmente, 
       SUSER_SNAME() nombe_login_asociado_a_la_sesion;

/*7. Realizar una consulta que permita conocer la edad de cada empleado
(Ayuda: HumanResources.Employee)*/
SELECT H.LoginID, DATEDIFF(YY,LEFT(H.BirthDate,4 ),SUBSTRING(CONVERT(VARCHAR,getdate()),1,11))
FROM HumanResources.Employee H

/*8. Realizar una consulta que retorne la longitud de cada apellido de los
Contactos, ordenados por apellido. En el caso que se repita el apellido
devolver únicamente uno de ellos. Por ejemplo,*/
SELECT SUBSTRING(H.LoginID,17,10) as Apellido, LEN(SUBSTRING(H.LoginID,17,10)) as Longitud
FROM HumanResources.Employee H

/*9. Realizar una consulta que permita encontrar el apellido con mayor longitud.*/
SELECT *
FROM Person.Person PP

/*10.Realizar una consulta que devuelva los nombres y apellidos de los contactos
que hayan sido modificados en los últimos 3 años.*/
DECLARE @time VARCHAR(4)

SET @time = RIGHT(CONVERT(VARCHAR(10),GETDATE(),103),4)
SET @time = @time-3
SET @time = CAST(@time AS INT)

SELECT P.FirstName,P.LastName,RIGHT(LEFT(P.ModifiedDate,11),4)
FROM Person.Person P
WHERE RIGHT(LEFT(P.ModifiedDate,11),4) > @time
--pd no me trae nada porque la tabla no tiebe datos modificados actuales

/*11.Se quiere obtener los emails de todos los contactos, pero en mayúscula.*/
SELECT UPPER(PE.EmailAddress)
FROM Person.EmailAddress PE

/*12.Realizar una consulta que permita particionar el mail de cada contacto,
obteniendo lo siguiente: */
SELECT PE.EmailAddress as email,LEFT(PE.EmailAddress,patindex('%[@]%',PE.EmailAddress)-1) as nombre,RIGHT(PE.EmailAddress,patindex('%[@]%',PE.EmailAddress)) as dominio
FROM Person.EmailAddress PE

/*13. Devolver los últimos 3 dígitos del NationalIDNumber de cada empleado*/
SELECT RIGHT(HE.NationalIDNumber,3)
FROM HumanResources.Employee HE

/*14.Se desea enmascarar el NationalIDNumbre de cada empleado, de la
siguiente forma ###-####-##:*/
SELECT SUBSTRING(HE.NationalIDNumber, 1, 3) + '-' + 
                  SUBSTRING(HE.NationalIDNumber, 4, 4) + '-' + 
                  SUBSTRING(HE.NationalIDNumber, 8, 4)
FROM HumanResources.Employee HE

/*15. Listar la dirección de cada empleado “supervisor” que haya nacido hace más
de 30 años. Listar todos los datos en mayúscula. Los datos a visualizar son:
nombre y apellido del empleado, dirección y ciudad. */
DECLARE @var VARCHAR(4)
SET @var = RIGHT(CONVERT(VARCHAR(10),GETDATE(),103),4)
SET @var = @var-30
SET @var = CAST(@var AS INT)

SELECT UPPER(PP.FirstName) as nombre,UPPER(PP.LastName) as apellido, UPPER(PA.AddressLine1) as direccion,UPPER(PA.City) as cuidad
FROM Person.Person PP,HumanResources.Employee HE,Person.Address PA
WHERE PA.AddressID = PP.BusinessEntityID AND
PP.BusinessEntityID = HE.BusinessEntityID AND PP.PersonType = 'EM' 
AND HE.JobTitle = 'Maintenance Supervisor' AND LEFT(HE.BirthDate,4) < @var

/*16. Listar la cantidad de empleados hombres y mujeres, de la siguiente forma:
Nota: Debe decir, Femenino y Masculino de la misma forma que se muestra. */
SELECT CASE WHEN HE.Gender = 'M' THEN 'Masculino' ELSE 'Femenino' END as genero,COUNT(HE.Gender) as cantidad
FROM HumanResources.Employee HE
GROUP BY HE.Gender

/*17.Categorizar a los empleados según la cantidad de horas de vacaciones,
según el siguiente formato:
Alto = más de 50 / medio= entre 20 y 50 / bajo = menos de 20*/
SELECT PP.FirstName as empleado,CASE WHEN HE.VacationHours > 50 THEN 'Alto' 
            WHEN HE.VacationHours <= 50 and HE.VacationHours >= 20 THEN 'Medio' ELSE 'Bajo' END as horas
FROM HumanResources.Employee HE,Person.Person PP
WHERE PP.BusinessEntityID = HE.BusinessEntityID