/*CREATE TABLE person(
  id INTEGER NOT NULL,
  name VARCHAR(255) NOT NULL,
  location VARCHAR(255),
  birth_day TIMESTAMP,
  PRIMARY KEY(id)
);*/
INSERT INTO person (id, name, location, birth_day) VALUES (1001,'Viet','Da Nang',sysdate());
INSERT INTO person (id, name, location, birth_day) VALUES (1002,'Linh','Quang Nam',sysdate());
INSERT INTO person (id, name, location, birth_day) VALUES (1003,'Hieu','Da Nang',sysdate());
INSERT INTO person (id, name, location, birth_day) VALUES (1004,'Vuong','Ha Noi',sysdate());
CREATE TABLE animal(
  id INTEGER NOT NULL,
  name VARCHAR(255) NOT NULL,
  location VARCHAR(255),
  birth_day TIMESTAMP,
  PRIMARY KEY(id)
);