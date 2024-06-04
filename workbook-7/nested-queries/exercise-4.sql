-- 1
SELECT productname FROM products WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM products);

-- 2
SELECT orderid, shipname, shipaddress FROM orders WHERE shipvia = (SELECT shipperid FROM shippers WHERE companyname LIKE "Federal Shipping");

-- 3
SELECT DISTINCT orderid FROM `order details` WHERE productid = (SELECT productid FROM products WHERE productname LIKE "Sasquatch Ale");

-- 4
SELECT firstname, lastname FROM employees WHERE employeeid = (SELECT employeeid FROM orders WHERE orderid = 10266);

-- 5
SELECT contactname FROM customers WHERE customerid LIKE (SELECT customerid FROM orders WHERE orderid = 10266);