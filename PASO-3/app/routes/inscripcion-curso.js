'use strict'

const express = require('express');
const router = express.Router();


router.post('/curso/inscripto', async (req, res) => {
   
   const client = require('../config/dbConnection')

   const {
      list,
      id,
   } = req.body


   console.log(list)

   const query = `INSERT INTO inscripciones_curso(idalumno, idcurso) VALUES ($1, $2)`

   if (list) {
      for (const curso of list)
         await client.query(query, [id, curso])
      res.redirect('/')
   }
   else
      res.redirect(`/persona/inscripcion-a-curso/${ id }`)
})

module.exports = router