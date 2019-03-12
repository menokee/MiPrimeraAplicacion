package com.edu.uabc.appm.mpa

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_dos.*

class DosActivity : AppCompatActivity() {
    val PREFS_FILENAME = "com.edu.uabc.appm.mpa.prefs"
    val NAME_VALOR = "llave"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos)

        var sP:SharedPreferences? = this.getSharedPreferences(PREFS_FILENAME,0)
        var respuesta = sP?.getString(NAME_VALOR,"Nada")
        var editor = sP?.edit()

        editor?.putString(NAME_VALOR,"valor")
        editor?.commit()
        editor?.apply()
        println(respuesta)

        var saludo:String? = intent.extras.getString("DatoEnviado","Sin Mensaje")
        mrrmsj.text = saludo

        if(setupPermissions())
            llamar.setOnClickListener(View.OnClickListener {
                var llamarIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:+526862114571")
                )
                startActivity(llamarIntent)
            })
        camara.setOnClickListener(View.OnClickListener {
            var camaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivity(camaraIntent)
        })

    }

    private fun setupPermissions():Boolean{
        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
        val permissionA = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        val permissionB = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(permission!=PackageManager.PERMISSION_GRANTED || permissionA!=PackageManager.PERMISSION_GRANTED || permissionB!=PackageManager.PERMISSION_GRANTED){
            Log.i("LaApp","")
            makeRequest()
        }
        return true
    }
    private val CALL_PHONE_CODE = 101
    private fun makeRequest(){
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE),CALL_PHONE_CODE)
    }
}
