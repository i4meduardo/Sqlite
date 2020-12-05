package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddNotaActivity : AppCompatActivity() {
    var myNotasDbHelper:NotasDbHelper?=null
    val DB_NAME = "notas.db"
    val DB_VERSION = 1

    var etTitulo:EditText?=null
    var etContenido:EditText?=null
    var btnAddNota:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nota)

        myNotasDbHelper = NotasDbHelper(this,DB_NAME,null,DB_VERSION)
        myNotasDbHelper!!.open()

        etTitulo = findViewById(R.id.eTitulo)
        etContenido = findViewById(R.id.etContenido)
        btnAddNota = findViewById(R.id.btnGuardar)

        btnAddNota!!.setOnClickListener {
            val titulo = etTitulo!!.text.toString()
            val contenido = etContenido!!.text.toString()

            myNotasDbHelper!!.addNota(titulo,contenido)

            etTitulo!!.setText("")
            etContenido!!.setText("")
        }

    }
}