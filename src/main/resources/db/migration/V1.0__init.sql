create table recipe (id integer, diet varchar(255), ingredient varchar(2000), name varchar(255), note varchar(2000), servings integer, primary key (id));

CREATE SEQUENCE  "RECIPE_SEQ"  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 50 START WITH 1 NOCACHE  ORDER  NOCYCLE  ;