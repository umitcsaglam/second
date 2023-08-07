package com.can.kenny_game

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.renderscript.ScriptGroup
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.can.kenny_game.databinding.ActivityMainBinding
import java.util.Random
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    private lateinit var Binding: ActivityMainBinding
    var dizi = ArrayList<ImageView>()
    var x=0
    var runnable = Runnable {  }
    var Handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        dizi.add(Binding.imageView1)
        dizi.add(Binding.imageView2)
        dizi.add(Binding.imageView3)
        dizi.add(Binding.imageView4)
        dizi.add(Binding.imageView5)
        dizi.add(Binding.imageView6)
        dizi.add(Binding.imageView7)
        dizi.add(Binding.imageView8)
        dizi.add(Binding.imageView9)
        gizle()

        object:CountDownTimer(60000,1000) {
            override fun onTick(millisUntilFinished: Long) {
               Binding.textView.text="Süre:${millisUntilFinished/1000}"
                gizle()
            }
            override fun onFinish() {
                Binding.textView.text="Süre:0"
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("CANI KAÇIRDIN :(")
                alert.setMessage("Canı kurtarmak ister misin?")
                alert.setPositiveButton("EVETTT",DialogInterface.OnClickListener { dialog, which ->
val can = intent
                    startActivity(can)
                })
                alert.setNegativeButton("Nayırrr.",DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this@MainActivity,"Peki..",Toast.LENGTH_LONG).show()
                })
                alert.show()
            }
        }.start()
    }
    fun gizle(){
        runnable = object : Runnable{
            override fun run() {
                for (i in dizi){
                    i.visibility=View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(9)
                dizi[randomIndex].visibility=View.VISIBLE
                Handler.postDelayed(runnable,1000)
            }

        }
        Handler.post(runnable)



    }
    fun tikla(view: View)
    {
        x+=1
        Binding.textView2.text="Skor:${x}"
    }

    }
