CREATE DATABASE recetasCulinarias;

USE recetasCulinarias;

CREATE TABLE platos (
    id_receta VARCHAR(5) NOT NULL UNIQUE,
    nombrePlato VARCHAR(40) NOT NULL,
    categoria VARCHAR(20),
    ingredientes VARCHAR(200),
    precio FLOAT,
    lugar_origen VARCHAR(100),
    PRIMARY KEY (id_receta)
);

CREATE TABLE autor (
    idAutor VARCHAR(5) NOT NULL,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    descripcion VARCHAR(300),
    PRIMARY KEY (idAutor)
);

CREATE TABLE receta (
    id_receta VARCHAR(5) NOT NULL,
    idAutor VARCHAR(5) NOT NULL,
    PRIMARY KEY (id_receta, idAutor),
    FOREIGN KEY (id_receta) REFERENCES platos(id_receta),
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor)
);

/*
Insercion
*/

INSERT INTO platos (id_receta, nombrePlato, categoria, ingredientes, precio, lugar_origen)
VALUES
("19836", "Sopa de Champiñones", "Salsas blancas", "150g champiñones|100g arroz", 70.6, "España");

INSERT INTO platos (id_receta, nombrePlato, categoria, ingredientes, precio, lugar_origen)
VALUES
("29330", "Pan Muerto", "Receta mexicana", "250g harina|100g azucar", 30.5, "México");

/*
Actualizacion
*/

UPDATE platos 
SET nombrePlato = "Torta"
WHERE id_receta = "29330";

/*
Busqueda
*/

SELECT 
    id_receta, 
    nombrePlato,
    categoria
FROM
    platos
WHERE
    precio > 100.0
ORDER BY 
    id_receta DESC;

/*
Vista
*/

CREATE VIEW platos_oeste AS
SELECT id_receta, nombrePlato, precio
FROM  platos
WHERE lugar_origen = "México";

/*
Borrar
*/

DROP TABLE platos;
DROP TABLE receta; 
DROP TABLE autor;



