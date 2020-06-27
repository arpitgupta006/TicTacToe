package com.arpit.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_doubleplayer.*

class doubleplayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doubleplayer)
    }
    fun buClickdp(view: View){
        val buSelecteddp:Button =view as Button
        var cellIddp = 0
        when(buSelecteddp.id){
            R.id.bu1dp-> cellIddp=1
            R.id.bu2dp-> cellIddp=2
            R.id.bu3dp-> cellIddp=3
            R.id.bu4dp-> cellIddp=4
            R.id.bu5dp-> cellIddp=5
            R.id.bu6dp-> cellIddp=6
            R.id.bu7dp-> cellIddp=7
            R.id.bu8dp-> cellIddp=8
            R.id.bu9dp-> cellIddp=9
        }
        playGamedp(cellIddp,buSelecteddp)
    }
    var activePlayerdp=1
    var player1dp = ArrayList<Int>()
    var player2dp = ArrayList<Int>()
    fun playGamedp(cellId:Int,buSelecteddp:Button){
        if (activePlayerdp==1){
            buSelecteddp.text="X"
            buSelecteddp.setBackgroundResource(R.color.purple)
            player1dp.add(cellId)
            activePlayerdp=2
        } else{
            buSelecteddp.text="O"
            buSelecteddp.setBackgroundResource(R.color.gray)
            player2dp.add(cellId)
            activePlayerdp=1
        }
        buSelecteddp.isEnabled=false
        checkWinnerdp()
    }
    fun checkWinnerdp(){
        var winnerdp =-1
        //row1
        if( player1dp.contains(1) && player1dp.contains(2) && player1dp.contains(3))
        {
            winnerdp=1
        }
        if( player2dp.contains(1) && player2dp.contains(2) && player2dp.contains(3)){
            winnerdp=2
        }
        //row2
        if( player1dp.contains(4) && player1dp.contains(5) && player1dp.contains(6))
        {
            winnerdp=1
        }
        if( player2dp.contains(4) && player2dp.contains(5) && player2dp.contains(6)){
            winnerdp=2
        }
        //row3
        if( player1dp.contains(7) && player1dp.contains(8) && player1dp.contains(9))
        {
            winnerdp=1
        }
        if( player2dp.contains(7) && player2dp.contains(8) && player2dp.contains(9)){
            winnerdp=2
        }
        //column1
        if( player1dp.contains(1) && player1dp.contains(4) && player1dp.contains(7))
        {
            winnerdp=1
        }
        if( player2dp.contains(1) && player2dp.contains(4) && player2dp.contains(7)){
            winnerdp=2
        }
        //column2
        if( player1dp.contains(2) && player1dp.contains(5) && player1dp.contains(8))
        {
            winnerdp=1
        }
        if( player2dp.contains(2) && player2dp.contains(5) && player2dp.contains(8)){
            winnerdp=2
        }
        //column3
        if( player1dp.contains(3) && player1dp.contains(6) && player1dp.contains(9))
        {
            winnerdp=1
        }
        if( player2dp.contains(3) && player2dp.contains(6) && player2dp.contains(9)){
            winnerdp=2
        }
        //diagonal1
        if( player1dp.contains(1) && player1dp.contains(5) && player1dp.contains(9))
        {
            winnerdp=1
        }
        if( player2dp.contains(1) && player2dp.contains(5) && player2dp.contains(9)){
            winnerdp=2
        }
        //diagonal2
        if( player1dp.contains(3) && player1dp.contains(5) && player1dp.contains(7))
        {
            winnerdp=1
        }
        if( player2dp.contains(3) && player2dp.contains(5) && player2dp.contains(7)){
            winnerdp=2
        }



        if(winnerdp == 1){
            player1windp +=1
            Toast.makeText(this,"Player 1 Won", Toast.LENGTH_LONG).show()
            tvplayeronewindp.text=player1windp.toString()
            restartdp()

        }else if(winnerdp == 2){
            player2windp +=1
            Toast.makeText(this,"Player 2 Won", Toast.LENGTH_LONG).show()
            tvplayertwowindp.text=player2windp.toString()
            restartdp()

        }
    }
    var player1windp=0
    var player2windp=0
    fun restartdp(){
        activePlayerdp=1
        player1dp.clear()
        player2dp.clear()
        for (cellIddp in 1..9){
            var buSelecteddp:Button?
            buSelecteddp = when(cellIddp){
                1->bu1dp
                2->bu2dp
                3->bu3dp
                4->bu4dp
                5->bu5dp
                6->bu6dp
                7->bu7dp
                8->bu8dp
                9->bu9dp
                else -> {bu1dp}
            }
            buSelecteddp!!.text=""
            buSelecteddp.setBackgroundResource(R.color.lightgray)
            buSelecteddp!!.isEnabled= true
        }
    }
}


