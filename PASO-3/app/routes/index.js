var express = require('express');
var router = express.Router();
var hbs = require('hbs');
hbs.registerHelper('dateFormat', require('handlebars-dateformat'));
/* GET home page. */

router.get('/', async (req, res) => {
   const client = require('../config/dbConnection')
   const query = 
      `SELECT 
         p.identificador,
         p.nombre,
         p.apellido,
         p.tipodoc,
         p.documento,
         p.fechanac,
         p.direccion,
         a.legajo,
         c.nombre as carrera
      FROM persona as p INNER JOIN alumno as a ON p.identificador = idpersona
      INNER JOIN inscripciones_carrera as ic ON ic.idalumno = a.identificador
      INNER JOIN carrera as c ON c.identificador = ic.idcarrera;`
   
   const { rows } = await client.query(query)
   res.render(
      'index',
      { titulo: 'IT Challenge JAVA', personas: rows }
   )
})

router.get('/persona/nuevo', async (req, res) => {
   const client = require('../config/dbConnection')
   const query = `SELECT identificador, nombre FROM carrera;`
   const { rows } = await client.query(query)
   res.render('personaForm', { persona: { fechanac: "" }, carreras: rows })
})

router.get('/persona/editar/:id', async (req, res) => {
   const { id } = req.params
   const client = require('../config/dbConnection')
   const query = 
         `SELECT 
         p.identificador,
         p.nombre,
         p.apellido,
         p.tipodoc,
         p.documento,
         p.fechanac,
         p.direccion,
         a.legajo,
         c.identificador as carrera
      FROM persona as p INNER JOIN alumno as a ON p.identificador = idpersona
      INNER JOIN inscripciones_carrera as ic ON ic.idalumno = a.identificador
      INNER JOIN carrera as c ON c.identificador = ic.idcarrera
      WHERE $1 = p.identificador;`
   const { rows } = await client.query(query, [id])

   const query2 = `SELECT identificador, nombre FROM carrera;`
   const rowsC = (await client.query(query2)).rows
   res.render('personaForm', { persona: rows[0], carreras: rowsC })
})

router.get('/persona/inscripcion-a-curso/:id', async (req, res) => {
   const { id } = req.params
   const client = require('../config/dbConnection')

   const query = `
      SELECT 
         p.identificador,
         p.nombre,
         p.apellido,
         a.legajo,
         a.identificador,
         c.identificador as carrera,
         c.nombre as nombre_carrera
      FROM persona as p INNER JOIN alumno as a ON p.identificador = idpersona
      INNER JOIN inscripciones_carrera as ic ON ic.idalumno = a.identificador
      INNER JOIN carrera as c ON c.identificador = ic.idcarrera
      WHERE $1 = p.identificador;`
   
   const alumno = (await client.query(query, [id])).rows[0]

   const query2 = `
      SELECT
         identificador,
         nombre 
      FROM curso
      WHERE ${alumno.carrera} = idcarrera`
   
   const { rows } = await client.query(query2)
   
   res.render('inscripcion-curso', { titulo1: 'Inscripción a Curso', alumno: alumno, cursos: rows } );
})

router.get('/persona/profesor/nuevo', async (req, res) => {
   const client = require('../config/dbConnection')
   const query = `SELECT identificador, nombre FROM curso`

   const { rows } = await client.query(query)

   res.render('personaProfForm', { cursos: rows })
})

router.get('/curso/info', async (req, res) => {
   const client = require('../config/dbConnection')
   const query = `SELECT identificador, nombre FROM curso`

   const { rows } = await client.query(query)

   res.render('cursoInfo', { cursos: rows, profesor: {}, alumnos: {}})
})

module.exports = router;
