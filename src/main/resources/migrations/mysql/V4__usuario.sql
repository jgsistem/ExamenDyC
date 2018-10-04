CREATE TABLE usuario (
  usuario_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  rol VARCHAR(20) NOT NULL,  
  usuario VARCHAR(20) NOT NULL,
  clave VARCHAR(20) NOT NULL,
  active BIT NOT NULL,
  PRIMARY KEY(usuario_id),
  INDEX IX_usuario_last_first_name(last_name, first_name)  
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO usuario(usuario_id, first_name, last_name,rol,usuario, clave,active) VALUES('1', 'Gustavo','Osorio', 'Owner','jg','123', 1);