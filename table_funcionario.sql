CREATE TABLE `funcionario`
  (
     `idfuncionario`   INT NOT NULL auto_increment,
     `nomefuncionario` VARCHAR(45) NOT NULL,
     `salario`         DOUBLE NOT NULL,
     `funcao`          VARCHAR(45) NOT NULL,
     PRIMARY KEY (`idfuncionario`),
     UNIQUE KEY `idfuncionario_unique` (`idfuncionario`),
     CONSTRAINT `idfuncionario` FOREIGN KEY (`idfuncionario`) REFERENCES
     `pessoa` (`idpessoa`)
  )
engine=innodb
auto_increment=52
DEFAULT charset=utf8mb4
COLLATE=utf8mb4_0900_ai_ci