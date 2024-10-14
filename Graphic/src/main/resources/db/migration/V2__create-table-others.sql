CREATE TABLE service_orders (
    id SERIAL PRIMARY KEY,
    client_name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100),
    service_type VARCHAR(100) NOT NULL,
    printing BOOLEAN NOT NULL DEFAULT FALSE,
    paper_type VARCHAR(50),
    finishing VARCHAR(100),
    quantity INT NOT NULL,
    dimension VARCHAR(50),
    entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_value DECIMAL(10, 2) NOT NULL,
    delivery_date DATE,
    delivery_time TIME,
    entry_payment DECIMAL(10, 2) DEFAULT 0.00,
    remaining_value DECIMAL(10, 2) DEFAULT 0.00,
    notes VARCHAR(250)
);

CREATE TABLE orcamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100),
    material VARCHAR(100) NOT NULL,
    paper_type VARCHAR(50),
    format VARCHAR(50),
    dimension VARCHAR(50),
    finishing VARCHAR(100),
    quantity INT NOT NULL,
    notes VARCHAR(250),
    artwork VARCHAR(250)
);