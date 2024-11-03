CREATE TABLE dimension(
    id INT AUTO_INCREMENT PRIMARY KEY,
    campo1 DOUBLE,
    campo2 DOUBLE
);

ALTER TABLE ordem_servico
DROP COLUMN dimension,
ADD COLUMN dimension INT,
ADD CONSTRAINT fk_dimension
FOREIGN KEY (dimension) REFERENCES dimension(id);