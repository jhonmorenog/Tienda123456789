CREATE DATABASE tienda;
use tienda;
CREATE TABLE personas (
  documento int(11) NOT NULL AUTO_INCREMENT, 
  pnombre   varchar(45) NOT NULL, 
  snombre   varchar(45) DEFAULT 'NULL', 
  papellido varchar(45) NOT NULL, 
  sapellido varchar(45) DEFAULT 'NULL', 
  email     varchar(105) DEFAULT 'NULL', 
  PRIMARY KEY (documento)) ENGINE=InnoDB;
CREATE TABLE productos (
  cb          varchar(25) NOT NULL, 
  nombre      varchar(45) NOT NULL, 
  descripcion varchar(255), 
  PRIMARY KEY (cb)) ENGINE=InnoDB;
CREATE TABLE facturas (
  numero            int(11) NOT NULL AUTO_INCREMENT, 
  fecha             datetime NOT NULL, 
  personasdocumento int(11) NOT NULL, 
  empleadodocumento int(11), 
  PRIMARY KEY (numero)) ENGINE=InnoDB;
CREATE TABLE ventas (
  numerof  int(11) NOT NULL, 
  cb       varchar(25) NOT NULL, 
  cantidad int(11) NOT NULL, 
  PRIMARY KEY (numerof, 
  cb)) ENGINE=InnoDB;
CREATE TABLE empleados (
  documento int(11) NOT NULL, 
  clave     varchar(150) NOT NULL, 
  PRIMARY KEY (documento)) ENGINE=InnoDB;
CREATE TABLE precios (
  cb       varchar(25) NOT NULL, 
  fechaini datetime NOT NULL, 
  fechafin datetime NULL, 
  precio   decimal(14, 2) NOT NULL, 
  PRIMARY KEY (cb, 
  fechaini)) ENGINE=InnoDB;
CREATE UNIQUE INDEX email_uk 
  ON personas (email);
ALTER TABLE facturas ADD CONSTRAINT FKfacturas231893 FOREIGN KEY (personasdocumento) REFERENCES personas (documento);
ALTER TABLE ventas ADD CONSTRAINT FKventas684927 FOREIGN KEY (numerof) REFERENCES facturas (numero);
ALTER TABLE ventas ADD CONSTRAINT FKventas885271 FOREIGN KEY (cb) REFERENCES productos (cb);
ALTER TABLE empleados ADD CONSTRAINT FKempleados152462 FOREIGN KEY (documento) REFERENCES personas (documento);
ALTER TABLE facturas ADD CONSTRAINT FKfacturas915308 FOREIGN KEY (empleadodocumento) REFERENCES empleados (documento);
ALTER TABLE precios ADD CONSTRAINT FKprecios574748 FOREIGN KEY (cb) REFERENCES productos (cb);


CREATE TABLE fotos (
  id          int(11) NOT NULL AUTO_INCREMENT, 
  descripcion varchar(255) NOT NULL, 
  foto        varchar(255) NOT NULL, 
  productoscb varchar(25) NOT NULL, 
  PRIMARY KEY (id)) ENGINE=InnoDB;
ALTER TABLE fotos ADD CONSTRAINT FKfotos946444 FOREIGN KEY (productoscb) REFERENCES productos (cb);
