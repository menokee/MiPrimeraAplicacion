package com.edu.uabc.appm.mpa

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Esto afecta el textview
        this.saludo.text = "Hola clase!!!"
        //var bandera: Boolean = false


        btnA.setOnClickListener(View.OnClickListener { view: View? ->
            //CAmbia
            //if (bandera) {
             //   saludo.text = "Presione el boton [${bandera}]!!!"
              //  bandera = !bandera
                //Toast.makeText( this, "Soy un toast!!! ${bandera}", Toast.LENGTH_SHORT).show()
            //    Snackbar.make(view!!, "Soy un baby", Snackbar.LENGTH_SHORT).show()
            //} else {
            //    saludo.text = "Presione el boton [${bandera}]!!!"
            //    bandera = !bandera
            //    Toast.makeText( this, "Soy un toast !!! ${bandera}", Toast.LENGTH_SHORT).show()
           // }
            //println("Presione el boton")

            //Se crea el intent para pasar el activityDos
            var cambiarActivity:Intent = Intent( this, DosActivity::class.java)

            //Enviar datos a otro activy
            cambiarActivity.putExtra("DatoEnviado","MA1-MENSAJE!!!")

            //Se ejectuta el Intent
            startActivity(cambiarActivity)
        })
        //Esto se envia a la consola
        //println("Helo Logcat!!!!!!+++++++++++++++++++++++")
    }

    override fun onStart() {
        super.onStart()
        println("Detectando el estado de Start")
    }

    override fun onPause() {
        super.onPause()
        println("Detectando el estado de Pause")
    }

    override fun onResume() {
        super.onResume()
        println("Detectando el estado de Resume")
    }

    override fun onStop() {
        super.onStop()
        println("Detectando el estado de Stop")
    }

    override fun onRestart() {
        super.onRestart()
        println("Detectando el estado de Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Detectando el estado de Destroy")
    }
}
