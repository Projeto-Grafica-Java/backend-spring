CREATE TABLE admin (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    senha VARCHAR(15) NOT NULL,
    entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);