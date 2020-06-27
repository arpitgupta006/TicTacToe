package com.arpit.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
        var singleplayerinstance= singleplayer()
        var doubleplayerinstance = doubleplayer()
    fun mainPage(view:View){
        var buSelected:Button= view as Button
        when(buSelected.id){
            R.id.buSinglePlayer->{
                val intent =Intent(this,singleplayer::class.java)

                startActivity(intent)
            }
            R.id.buDoublePlayer->{
                val intent = Intent(this,doubleplayer::class.java)

                startActivity(intent)

                }

            }


    }
    fun quit(view: View) {
        this@MainActivity.finish()
        exitProcess(0)
    }

    fun buClickdp(view: View) {}
    fun buClicksp(view: View) {}

    }
