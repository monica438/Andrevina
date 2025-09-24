package com.monicadominguez.andrevina

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val number = Random.nextInt(1,101)
        val textViewcomptador = findViewById<TextView>(R.id.textView3)
        var comptador = 0



        findViewById<Button>(R.id.button).setOnClickListener{

            try {
                val guess = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
                comptador++

                textViewcomptador.text = comptador.toString()

                if (number > guess) {
                    Toast.makeText(this,"El número que busques és major",Toast.LENGTH_SHORT).show()
                } else if (number < guess) {
                    Toast.makeText(this,"El número que busques és menor",Toast.LENGTH_SHORT).show()
                } else if (number == guess){
                    Toast.makeText(this,"FELICITATS! Has endevinat el número!",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"Error desconegut",Toast.LENGTH_SHORT).show()
                }
            } catch(e: Exception) {
                Toast.makeText(this,"Error: has d'escriure un número",Toast.LENGTH_SHORT).show()
            }

        }
    }
}