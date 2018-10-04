CREATE TABLE cliente (
  cliente_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  rol VARCHAR(20) NOT NULL,  
  active BIT NOT NULL,
  PRIMARY KEY(cliente_id),
  INDEX IX_cliente_last_first_name(last_name, first_name)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO cliente(cliente_id, first_name, last_name,rol, active) VALUES('1', 'Royal','Verdales', 'Owner', 1);