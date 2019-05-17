---EJERCICIO 1

SELECT 
   tipodoc, 
   documento,
   nombre,
   apellido,
   legajo
FROM
   persona 
INNER JOIN alumno ON persona.identificador=alumno.idpersona;

---EJERCICIO 2

SELECT 
   a.legajo, 
   p.nombre, 
   p.apellido, 
   c.nombre AS nombre_de_carrera, 
   ic.fechainscripcion 
FROM 
   persona AS p 
INNER JOIN alumno AS a ON p.identificador=a.idpersona
INNER JOIN inscripciones_carrera AS ic ON ic.idalumno=a.identificador
INNER JOIN carrera AS c ON c.identificador=ic.idcarrera
ORDER BY a.legajo DESC;

---EJERCICIO 3

SELECT 
   c.nombre AS nombre_de_carrera,
   cu.nombre AS nombre_curso,
   COUNT(icu.idalumno) AS cantidad_inscriptos_curso,
   cu.cupomaximo AS curso_cupomaximo
FROM
   curso AS cu
INNER JOIN carrera AS c ON cu.idcarrera=c.identificador
INNER JOIN inscripciones_curso AS icu ON icu.idcurso=cu.identificador 
GROUP BY icu.idcurso, c.nombre, cu.nombre, cu.cupomaximo;

---EJERCICIO 4
---Agregué al curso Análisis matemático los alumnos Iván y a Patricia para superar el cupo.
---El alumno Iván (identificador = 6) fue agregado en el ejercicio 7.
INSERT INTO inscripciones_curso VALUES
(6,1,'2019-07-02');
INSERT INTO inscripciones_carrera VALUES
(5,1,'2000-01-01');
INSERT INTO inscripciones_curso VALUES
(5,1,'2010-01-01');

---Query
SELECT nombre_curso
FROM (
   SELECT 
      c.nombre AS nombre_de_carrera,
      cu.nombre AS nombre_curso,
      COUNT(icu.idalumno) AS cantidad_inscriptos_curso,
      cu.cupomaximo AS curso_cupomaximo
   FROM
      curso AS cu
   INNER JOIN carrera AS c ON cu.idcarrera=c.identificador
   INNER JOIN inscripciones_curso AS icu ON icu.idcurso=cu.identificador
   GROUP BY icu.idcurso, c.nombre, cu.nombre, cu.cupomaximo
) AS eje3
WHERE cantidad_inscriptos_curso > curso_cupomaximo;

---EJERCICIO 5

UPDATE curso
SET cupomaximo = 10
WHERE anio = 2018 AND cupomaximo < 5;

---EJERCICIO 6
SELECT 
   icu.fechainscripcion AS ins_curso_fecha,
   icu.idalumno,
   icu.idcurso
FROM inscripciones_curso AS icu
INNER JOIN alumno AS a ON a.identificador = icu.idalumno
INNER JOIN inscripciones_carrera AS ic ON ic.idalumno = a.identificador
WHERE icu.fechainscripcion < ic.fechainscripcion;
---EL alumno Franzo Perez (id = 2) en el curso de Java (id = 3), posee el error de las fechas.
UPDATE inscripciones_curso
SET  fechainscripcion = CURRENT_DATE
WHERE inscripciones_curso.idalumno = 2 
AND inscripciones_curso.idcurso = 3;

---EJERCICIO 7
---Considero que una persona es alumno si esta inscripto en al menos una carrera.

INSERT INTO persona VALUES
   (6,'DNI', 34420302, 'Iván', 'Ordóñez Giovanazzi', '1989-03-09');
INSERT INTO alumno VALUES
   (6,6, 99999);
INSERT INTO inscripciones_carrera VALUES
   (6,1,'2019-07-01');

---EJERCICIO 8
---La tabla persona es la correcta para agregar la dirección.

ALTER TABLE persona ADD direccion varchar(200) NOT NULL;
