package com.example.esemismo.chronometro_ejemplo

//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_inicio.view.*
import java.util.*


class MainActivity : AppCompatActivity() {

    var pausarCronometroSinQueSigaContandor = 0
    var precio = 0.45
    lateinit var costo:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        //Aquí Llamamos al cronómetro, es como crear una instancia para que podamos usar sus metodos
        val chronometer = findViewById<Chronometer>(R.id.chronometer)

        //Invocar a los botones
        val buttonStart = findViewById<Button>(R.id.btn_start)
        val buttonStop = findViewById<Button>(R.id.btn_stop)

        costo = findViewById(R.id.tv_dinero)
        var costoTiempo = Timer()

        //Evento para cada boton que servira para empezar o para en cronometro
        buttonStart?.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime() - pausarCronometroSinQueSigaContandor
            chronometer.start()
            precio = 0.45
            costo.text="0.45"
            costoTiempo = Timer()
            costoTiempo.scheduleAtFixedRate(object: TimerTask(){
                override fun run() {
                    precio += 0.15
                    costo.text = precio.toString()
                }
            },15000,15000)

        }

        buttonStop?.setOnClickListener {
            chronometer.stop()

            pausarCronometroSinQueSigaContandor = (SystemClock.elapsedRealtime() - chronometer.base).toInt()
            pausarCronometroSinQueSigaContandor = 0
            costoTiempo.cancel()
        }
    }
}