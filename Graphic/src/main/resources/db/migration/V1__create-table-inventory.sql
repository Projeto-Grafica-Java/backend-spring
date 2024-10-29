CREATE TABLE estoque (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    codigo VARCHAR(50) NOT NULL,
    medidas VARCHAR(50),
    vendas INT NOT NULL,
    quantidade INT NOT NULL,
    data VARCHAR(50)
);