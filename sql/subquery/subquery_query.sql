SELECT id, first_name, last_name, age, country
    FROM customers
    WHERE age = (SELECT MIN(age) FROM customers);

SELECT id, first_name, last_name, age, country
    FROM customers
    WHERE id NOT IN (SELECT DISTINCT customer_id FROM orders);