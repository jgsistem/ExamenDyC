CREATE TABLE proyecto (
  proyecto_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL, 
  pais  VARCHAR(50) NOT NULL, 
  number VARCHAR(50) NOT NULL
  balance DECIMAL(10,2) NOT NULL,  
  active BIT NOT NULL,
  cliente_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY(proyecto_id),
  INDEX IX_bank_proyecto_id(proyecto_id),  
  CONSTRAINT FK_proyector_id FOREIGN KEY(cliente_id) REFERENCES cliente(cliente_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


