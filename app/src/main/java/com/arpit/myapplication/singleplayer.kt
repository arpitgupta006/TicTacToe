package com.arpit.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_doubleplayer.*
import kotlinx.android.synthetic.main.activity_singleplayer.*
import kotlin.random.Random

class singleplayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleplayer)
    }
    fun buClicksp(view: View){
        val buSelectedsp:Button =view as Button
        var cellIdsp = 0
        when(buSelectedsp.id){
            R.id.bu1sp-> cellIdsp=1
            R.id.bu2sp-> cellIdsp=2
            R.id.bu3sp-> cellIdsp=3
            R.id.bu4sp-> cellIdsp=4
            R.id.bu5sp-> cellIdsp=5
            R.id.bu6sp-> cellIdsp=6
            R.id.bu7sp-> cellIdsp=7
            R.id.bu8sp-> cellIdsp=8
            R.id.bu9sp-> cellIdsp=9
        }
        playGamesp(cellIdsp,buSelectedsp)
    }
    var activePlayersp=1
    var player1sp = ArrayList<Int>()
    var player2sp = ArrayList<Int>()
    fun playGamesp(cellIdsp:Int,buSelectedsp:Button){
        if (activePlayersp==1){
            buSelectedsp.text="X"
            buSelectedsp.setBackgroundResource(R.color.purple)
            player1sp.add(cellIdsp)
            activePlayersp=2
            autoPlaysp()
        } else{
            buSelectedsp.text="O"
            buSelectedsp.setBackgroundResource(R.color.gray)
            player2sp.add(cellIdsp)
            activePlayersp=1
        }
        buSelectedsp.isEnabled=false
        checkWinnersp()

    }
    fun checkWinnersp(){
        var winnersp =-1
        //row1
        if( player1sp.contains(1) && player1sp.contains(2) && player1sp.contains(3))
        {
            winnersp=1
        }
        if( player2sp.contains(1) && player2sp.contains(2) && player2sp.contains(3)){
            winnersp=2
        }
        //row2
        if( player1sp.contains(4) && player1sp.contains(5) && player1sp.contains(6))
        {
            winnersp=1
        }
        if( player2sp.contains(4) && player2sp.contains(5) && player2sp.contains(6)){
            winnersp=2
        }
        //row3
        if( player1sp.contains(7) && player1sp.contains(8) && player1sp.contains(9))
        {
            winnersp=1
        }
        if( player2sp.contains(7) && player2sp.contains(8) && player2sp.contains(9)){
            winnersp=2
        }
        //column1
        if( player1sp.contains(1) && player1sp.contains(4) && player1sp.contains(7))
        {
            winnersp=1
        }
        if( player2sp.contains(1) && player2sp.contains(4) && player2sp.contains(7)){
            winnersp=2
        }
        //column2
        if( player1sp.contains(2) && player1sp.contains(5) && player1sp.contains(8))
        {
            winnersp=1
        }
        if( player2sp.contains(2) && player2sp.contains(5) && player2sp.contains(8)){
            winnersp=2
        }
        //column3
        if( player1sp.contains(3) && player1sp.contains(6) && player1sp.contains(9))
        {
            winnersp=1
        }
        if( player2sp.contains(3) && player2sp.contains(6) && player2sp.contains(9)){
            winnersp=2
        }
        //diagonal1
        if( player1sp.contains(1) && player1sp.contains(5) && player1sp.contains(9))
        {
            winnersp=1
        }
        if( player2sp.contains(1) && player2sp.contains(5) && player2sp.contains(9)){
            winnersp=2
        }
        //diagonal2
        if( player1sp.contains(3) && player1sp.contains(5) && player1sp.contains(7))
        {
            winnersp=1
        }
        if( player2sp.contains(3) && player2sp.contains(5) && player2sp.contains(7)){
            winnersp=2
        }


        if(winnersp == 1){
            player1winsp +=1
            Toast.makeText(this,"Player 1 Won", Toast.LENGTH_LONG).show()
            tvplayeronewinsp.text=player1winsp.toString()
            restartsp()

        }else if(winnersp == 2){
            player2winsp +=1
            Toast.makeText(this,"Player 2 Won", Toast.LENGTH_LONG).show()
            tvplayertwowinsp.text=player2winsp.toString()
            restartsp()

        }
    }
    fun autoPlaysp(){
        var emptyCells =ArrayList<Int>()
        for(cellIdsp in 1..9){
            if (!(player1sp.contains(cellIdsp) || player2sp.contains(cellIdsp))){
                emptyCells.add(cellIdsp)
            }
        }
        val r = java.util.Random()
        val randomIndex = r.nextInt(emptyCells.size)
        val cellIdsp = emptyCells[randomIndex]
        var buSelectedsp:Button?
        buSelectedsp = when(cellIdsp){
            1->bu1sp
            2->bu2sp
            3->bu3sp
            4->bu4sp
            5->bu5sp
            6->bu6sp
            7->bu7sp
            8->bu8sp
            9->bu9sp
            else -> {bu1sp}
        }
        playGamesp(cellIdsp,buSelectedsp)

    }
    var player1winsp=0
    var player2winsp=0
    fun restartsp(){
        activePlayersp=1
        player1sp.clear()
        player2sp.clear()
        for (cellIdsp in 1..9){
            var buSelectedsp:Button?
            buSelectedsp = when(cellIdsp){
                1->bu1sp
                2->bu2sp
                3->bu3sp
                4->bu4sp
                5->bu5sp
                6->bu6sp
                7->bu7sp
                8->bu8sp
                9->bu9sp
                else -> {bu1sp}
            }
            buSelectedsp!!.text=""
            buSelectedsp.setBackgroundResource(R.color.lightgray)
            buSelectedsp!!.isEnabled= true
        }
    }


}
