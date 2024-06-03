-- 1
-- products

-- 2
SELECT productid, productname, unitprice FROM products;

-- 3
SELECT productid, productname, unitprice FROM products ORDER BY unitprice;

-- 4
SELECT * FROM products WHERE unitprice <= 7.5;

-- 5
SELECT * FROM products WHERE UnitsInStock >= 100 ORDER BY unitprice DESC;

-- 6
SELECT * FROM products WHERE UnitsInStock >= 100 ORDER BY unitprice DESC, ProductName;

-- 7
SELECT * FROM products WHERE UnitsInStock = 0 AND UnitsOnOrder > 1 ORDER BY productname;

-- 8 
-- categories

-- 9
SELECT * FROM categories; -- 8

-- 10
SELECT * FROM products WHERE CategoryID = 8;

-- 11
SELECT firstname, lastname FROM employees;

-- 12
SELECT firstname, lastname FROM employees WHERE title LIKE "%manager";

-- 13
SELECT DISTINCT title FROM employees;

-- 14
SELECT * FROM employees WHERE salary BETWEEN 2000 AND 2500;

-- 15
SELECT * FROM suppliers;

-- 16
SELECT * FROM products WHERE supplierid = (SELECT supplierid FROM suppliers WHERE companyname LIKE "tokyo traders");