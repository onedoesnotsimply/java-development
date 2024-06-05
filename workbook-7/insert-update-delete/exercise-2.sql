-- 1. Add a new supplier
INSERT INTO suppliers (supplierid, companyname) VALUES (30, 'Definitely A Real Company');

-- 2. Add a new product from the new supplier
INSERT INTO products (productid, productname, supplierid, unitprice) VALUES (78, 'Definitely A Real Item', 30, 149.99);

-- 3. List all products and their suppliers
SELECT productname, unitprice, companyname FROM products INNER JOIN suppliers ON products.SupplierID = suppliers.SupplierID ORDER BY CompanyName;

-- 4. Raise the price of your new product by 15%
UPDATE products SET unitprice = (unitprice + (unitprice * 0.15)) WHERE supplierid = 30;

-- 5. List the products and prices of all products from the new supplier
SELECT productname, unitprice FROM products WHERE supplierid = 30;

-- 6. Delete the new product
DELETE FROM products WHERE productid = 78;

-- 7. Delete the new supplier
DELETE FROM suppliers WHERE supplierid = 30;

-- 8. List all products
SELECT * FROM products;

-- 9. List all suppliers
SELECT * FROM suppliers