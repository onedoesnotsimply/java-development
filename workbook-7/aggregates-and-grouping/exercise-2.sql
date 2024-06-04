-- 1. How many suppliers are there?
SELECT COUNT(*) FROM suppliers;

-- 2. What is the sum of the employee's salaries?
SELECT SUM(salary) FROM employees;

-- 3. What is the price of the cheapest item Northwind sells?
SELECT MIN(unitprice) FROM products;

-- 4. What is the average price of items that Northwind sells?
SELECT AVG(unitprice) FROM products;

-- 5. What is the price of the most expensive item that Northwind sells?
SELECT MAX(unitprice) FROM products;

-- 6. What is the supplier ID of each supplier and the number of items they supply?
SELECT supplierid, COUNT(*) AS items FROM products GROUP BY supplierid;

-- 7. What is the category ID of each category and the average price of each item in the category?
SELECT categoryid, AVG(unitprice) AS avg_price FROM products GROUP BY categoryid;

-- 8. ID's of Suppliers that provide 5 or more items and the number of items supplied
SELECT supplierid, COUNT(productid) FROM products GROUP BY supplierid HAVING COUNT(*) >= 5;

-- 9. List the productid, product name and inventory value, 
SELECT productid, productname, unitprice*unitsinstock AS inventory_value FROM products ORDER BY inventory_value DESC, productname;