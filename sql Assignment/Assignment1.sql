-- ----------------------------------------TechShop, an electronic gadgets shop--------------------------------------------

-- ----------Task 1 - Database Design------------------------

-- 1 Create the database named "TechShop"
create database TechShop;
use TechShop;

-- 2 Define the schema for the Customers, Products, Orders, OrderDetails and Inventory tables based on the provided schema.
-- 4 Create appropriate Primary Key and Foreign Key constraints for referential integrity.
create table Customers(
CustomerID int Primary Key,
FirstName Varchar(20),
LastName Varchar(10),
Email Varchar(20) check(Email like '%@%'),
Phone Varchar(10),
Address Varchar(50)
)

create table Products(
ProductID Varchar(5) Primary Key,
ProductName Varchar(20),
Description varchar(50),
Price decimal(7,2)
)

create table Orders(
OrderID int Primary Key,
CustomerID int, constraint fk_orders 
foreign key(CustomerID) references Customers(CustomerID),
OrderDate Date,
TotalAmount decimal(9,2)
)

create table OrderDetails(
OrderDetailID Varchar(5) Primary Key,
OrderID int, constraint fk_orderdetails1 
foreign key(OrderID) references Orders(OrderID),
ProductID Varchar(5), constraint fk_orderdetails2 
foreign key(ProductID) references Products(ProductID),
Quantity int
)

create table Inventory(
InventoryID int Primary Key,
ProductID Varchar(5), constraint fk_inventory 
foreign key(ProductID) references Products(ProductID),
QuantityInStock int,
LastStockUpdate date
)

-- 5 Insert at least 10 sample records into each of the following tables.

Insert into Customers(CustomerID, FirstName, LastName, Email, Phone, Address)
Values(111, 'Dharshini', 'G P', 'abc1@gmail.com', 1234567890, 'Thirumulaivoyil'),
(112, 'Sowmiya', 'N', 'abc2@gmail.com', 6655443302, 'Porur'),
(113, 'Sridevi', 'P', 'abc3@gmail.com', 3456780901, 'Thirumulaivoyil'),
(114, 'Lakshana', 'S', 'abc4@gmail.com', 4567089012, 'Perambur'),
(115, 'Mukunth', 'K', 'abc5@gmail.com', 5670890123, 'Surapet'),
(116, 'Sanjay', 'D', 'abc6@gmail.com', 6708901234, 'Ambattur'),
(117, 'Dharshan', 'S', 'abc7@gmail.com', 7809012345, 'Villivakkam'),
(118, 'Gracelin', 'J', 'abc8@gmail.com', 8901203456, 'Ambattur'),
(119, 'Aarthi', 'A', 'abc9@gmail.com', 9123004567, 'Poonamallee'),
(120, 'Christa', 'V', 'abc10@gmail.com', 9012345607, 'Redhills');


Insert into Products(ProductID, ProductName, Description, Price)
Values('P1_PH', 'iPhone 13', 'High-end mobile communication device', 27999.00),
('P2_WE', 'Sony Earbuds', 'True wireless audio experience', 2999.00),
('P3_LP', 'Laptops', 'Mobile computing and productivity device', 49999.00),
('P4_SW', 'Apple Watch Series 7', 'Wearable for health and notifications', 5999.00),
('P5_BT', 'JBL Speaker', 'Portable audio without physical connections', 1499.00),
('P6_GC', 'Samsung Odyssey G9', 'Curved high-performance gaming display', 7999.00),
('P7_FT', 'Fitbit Charge 5', 'Health and fitness monitoring device', 1499.00),
('P8_DC', 'GoPro Camera', 'Compact, rugged video recording', 14999.00),
('P9_DT', 'Digital Tablet', 'Portable electronic device for applications', 6999.00),
('P10_B', 'Biometric Door Locker', 'Secure access control with biometrics', 30999.00);

Insert into Orders(OrderID, CustomerID, OrderDate, TotalAmount)
Values(101, 111, '2023-12-18', 27999.00),
(102, 112, '2023-12-20', 5998.00),
(103, 113, '2023-12-25', 49999.00),
(104, 114, '2023-12-26', 17997.00),
(105, 115, '2023-12-28', 5996.00),
(106, 116, '2023-12-30', 15998.00),
(107, 117, '2024-01-02', 1499.00),
(108, 118, '2024-01-03', 29998.00),
(109, 119, '2024-01-07', 20997.00),
(110, 120, '2024-01-14', 30999.00);

Insert into OrderDetails(OrderDetailID, OrderID, ProductID, Quantity)
Values('PH101', 101, 'P1_PH', 1),
('WE102', 102, 'P2_WE', 2),
('LP103', 103, 'P3_LP', 1),
('SW104', 104, 'P4_SW', 3),
('BT105', 105, 'P5_BT', 4),
('GC106', 106, 'P6_GC', 2),
('FT107', 107, 'P7_FT', 1),
('DC108', 108, 'P8_DC', 2),
('DT109', 109, 'P9_DT', 3),
('BB110', 110, 'P10_B', 1);

Insert into Inventory(InventoryID, ProductID, QuantityInStock, LastStockUpdate)
Values(1, 'P1_PH', 10, '2023-12-18'),
(2, 'P2_WE', 15, '2023-12-20'),
(3, 'P3_LP', 5, '2023-12-25'),
(4, 'P4_SW', 20, '2023-12-26'),
(5, 'P5_BT', 25, '2023-12-28'),
(6, 'P6_GC', 4, '2023-12-30'),
(7, 'P7_FT', 6, '2024-01-02'),
(8, 'P8_DC', 3, '2024-01-03'),
(9, 'P9_DT', 8, '2024-01-07'),
(10, 'P10_B', 3, '2024-01-14');

-- ---------Task 2 - Select, Where, Between, AND, LIKE---------------------------

-- 1. Write an SQL query to retrieve the names and emails of all customers.
Select firstname, lastname, email from customers; 

-- 2 Write an SQL query to list all orders with their order dates and corresponding customer names.
Select o.orderid, o.orderdate, c.firstname, c.lastname
from orders o, customers c
where o.customerid=c.customerid;

-- 3 Write an SQL query to insert a new customer record into the "Customers" table. Include customer information such as name, email, and address.
Insert into customers(customerid, firstname, lastname, email, address)
values(121, 'Ramya', 'R', 'abc11@gmail.com', 'Anna Nagar');

-- 4 Write an SQL query to update the prices of all electronic gadgets in the "Products" table by increasing them by 10%.
Update products
Set price = price + (price*0.1);

-- 5 Write an SQL query to delete a specific order and its associated order details from the "Orders" and "OrderDetails" tables. Allow users to input the order ID as a parameter.
set @ordersid = 109;
Delete from orderdetails 
Where orderid = @ordersid;
Delete from orders 
Where orderid = @ordersid; 

-- 6 Write an SQL query to insert a new order into the "Orders" table. Include the customer ID, order date, and any other necessary information.
Insert into customers(customerid, firstname, lastname, email, phone, address)
values(122, 'Shobhana', 'M', 'abc13@gmail.com', 9736362837, 'Pattabiram');
Insert into Orders(OrderID, CustomerID, OrderDate, TotalAmount)
Values(201, 122, '2024-01-02', 1499.00);

-- 7 Write an SQL query to update the contact information (e.g., email and address) of a specific customer in the "Customers" table. Allow users to input the customer ID and new contact information.
set @customersid = 111;
set @newemail = 'abc01@gmail.com';
set @newaddress = 'Chennai';
Update customers
SET email = @newemail , address = @newaddress
where customerid = @customersid;

-- 8 Write an SQL query to recalculate and update the total cost of each order in the "Orders" table based on the prices and quantities in the "OrderDetails" table.
Update orders o
Set totalamount = (
select (od.quantity*p.price)
From orderdetails od, products p 
Where p.productid = od.productid and o.orderid = od.orderid
);

-- 9 Write an SQL query to delete all orders and their associated order details for a specific customer from the "Orders" and "OrderDetails" tables. Allow users to input the customer ID as a parameter.
set @customersid = 112;
delete from orderdetails
where orderid = (select orderid from orders where customerid = @customersid);
delete from orders 
where customerid = @customersid;

-- 10 Write an SQL query to insert a new electronic gadget product into the "Products" table, including product name, category, price, and any other relevant details.
alter table products
add column Category varchar(20);

Update Products
Set Category = case
    When ProductID like 'P1%' THEN 'Smartphone'
    When ProductID like 'P2%' THEN 'Wireless Earbuds'
    When ProductID like 'P3%' THEN 'Portable Computer'
    When ProductID like 'P4%' THEN 'Smartwatch'
    When ProductID like 'P5%' THEN 'Bluetooth Speaker'
    When ProductID like 'P6%' THEN 'Gaming Console '
    When ProductID like 'P7%' THEN 'Fitness Tracker'
    When ProductID like 'P8%' THEN 'Digital Camera'
    When ProductID like 'P9%' THEN 'Handheld Device'
    When ProductID like 'P10%' THEN 'Security System'
end;

Insert into Products(ProductID, ProductName, Description, Price, Category)
Values('P11_P', 'Redmi Note 14 Pro', 'Fast charging and efficient device', 13999.00, 'Smartphone');

-- 11 Write an SQL query to update the status of a specific order in the "Orders" table (e.g., from "Pending" to "Shipped"). Allow users to input the order ID and the new status.
Alter table Orders
add column Status varchar(15);
Update orders
Set Status = 'Pending';
set @ordersid = 103;
set @newstatus = 'Shipped';
Update orders
Set Status = @newstatus
where orderid = @ordersid;

-- 12 Write an SQL query to calculate and update the number of orders placed by each customer in the "Customers" table based on the data in the "Orders" table.
Alter table Customers
add column Count int;

UPDATE Customers
SET Count = (
    SELECT COUNT(OrderID)
    FROM Orders
    WHERE Orders.CustomerID = Customers.CustomerID
);

