DECLARE @wea int, @wea2 varchar(2)
SET @wea = '10'

SELECT @wea +'2' as wea

SET @wea2 = CAST(@wea as varchar)
SELECT @wea2 +'2'