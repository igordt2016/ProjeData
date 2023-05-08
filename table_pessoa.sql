CREATE TABLE `pessoa`
  (
     `idpessoa`       INT NOT NULL auto_increment,
     `nome`           VARCHAR(45) NOT NULL,
     `datanascimento` DATE NOT NULL,
     PRIMARY KEY (`idpessoa`),
     UNIQUE KEY `idpessoa_unique` (`idpessoa`)
  )
engine=innodb
auto_increment=52
DEFAULT charset=utf8mb4
COLLATE=utf8mb4_0900_ai_ci