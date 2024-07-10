CREATE DATABASE codegym;
use codegym;

CREATE TABLE discount(
	discount_id INT PRIMARY KEY,
    discount_name VARCHAR(50) NOT NULL

);

CREATE TABLE product_manager(
	product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    discount_id INT NOT NULL,
    inventory INT NOT NULL,
    FOREIGN KEY (discount_id) REFERENCES discount (discount_id)
);

CREATE TABLE employee_manager(
	employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    dob DATE NOT NULL,
    address VARCHAR(150) NOT NULL
);

CREATE TABLE customer_manager(
	customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    dob DATE NOT NULL,
    phone VARCHAR(10) NOT NULL,
    address VARCHAR(150) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE order_manager(
	order_id INT AUTO_INCREMENT PRIMARY KEY,
    payment_methods VARCHAR(150) NOT NULL,
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
	order_date DATE,
    delivery_date DATE,
    delivery_address VARCHAR(150),
	FOREIGN KEY (customer_id) REFERENCES customer_manager (customer_id),
    FOREIGN KEY (employee_id) REFERENCES employee_manager (employee_id)
);


ALTER TABLE product_manager
MODIFY COLUMN product_id INT AUTO_INCREMENT;


DELIMITER //
CREATE PROCEDURE getListItem()
BEGIN
	SELECT c.product_name AS "name",
		   c.price AS "price",
           discount.discount_name AS "discount",
           c.inventory AS "stock"
	FROM product_manager c
    JOIN discount ON c.discount_id = discount.discount_id;
END //
DELIMITER ;
call codegym.getListItem();

DELIMITER //
CREATE PROCEDURE getListIProduct(
    IN num_rows INT
)
BEGIN
    SELECT c.product_name AS "name",
           c.price AS "price",
           discount.discount_name AS "discount",
           c.inventory AS "stock"
    FROM product_manager c
    JOIN discount ON c.discount_id = discount.discount_id
    LIMIT num_rows;
END //
DELIMITER ;

call codegym.getListIProduct();