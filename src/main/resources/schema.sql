/*
CREATE TABLE brand(
    brand_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30));

CREATE TABLE product(
    product_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    brand_id BIGINT,
    FOREIGN KEY(brand_id) REFERENCES brand);

CREATE TABLE t_rates(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    brand_id BIGINT,
    product_id BIGINT,
    start_date DATE,
    emd_date DATE,
    price NUMERIC,
    currency_code VARCHAR(3),
    FOREIGN KEY(brand_id) REFERENCES brand,
    FOREIGN KEY(product_id) REFERENCES product);

 */