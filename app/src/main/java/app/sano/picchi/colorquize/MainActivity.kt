package app.sano.picchi.colorquize

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.nextInt

var score = 0

class MainActivity : AppCompatActivity() {

    var colorTextList = listOf("赤","青","黄","緑")
    var rgbList = listOf("#F44336","#03A9F4","#FFEB3B","#4CAF50")
    //var score = 0
    var second= 10
    //var randomNumText = Random.nextInt(3)
    var randomColorText = Random.nextInt(4)
    var colorTextNum = Random.nextInt(4)
    var colorTextNum1 = Random.nextInt(4)
    var colorTextNum2 = Random.nextInt(4)
    var colorTextNum3 = Random.nextInt(4)
    var colorTextNum4 = Random.nextInt(4)

    //連打と一緒のタイマー
    val timer : CountDownTimer = object : CountDownTimer(10000,1000){

        //終わったら呼ばれる
        override fun onFinish() {
            result()
        }

        //1秒ごとに呼ばれる
        override fun onTick(millisUntilFinished: Long) {
            second -= 1
            secondText.text = second.toString()
        }
    }

    fun result(){
        if (second == 0){
            val intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        second = 10
        score = 0

        timer.start()
        game()

    }



    fun game(){
        textView.text = colorTextList[colorTextNum]
        textView.setTextColor(Color.parseColor(rgbList[0]))
        var number = Random.nextInt(4)

        when(number){
            0 ->{
                //テキストカラーを0(赤)にする
                textView.setTextColor(Color.parseColor(rgbList[0]))
            }
            1 ->{
                //テキストカラーを1(青)にする
                textView.setTextColor(Color.parseColor(rgbList[2]))
            }
            2 ->{
                //テキストカラーを2(黄)にする
                textView.setTextColor(Color.parseColor(rgbList[2]))
            }
            3 ->{
                //テキストカラーを3(緑)にする
                textView.setTextColor(Color.parseColor(rgbList[3]))
            }
        }


        button1.setOnClickListener {
            if (number == 0){
                score++
                number = Random.nextInt(4)
                textView.setTextColor(Color.parseColor(rgbList[number]))
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                randomText()

            }else{
                Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show()
            }
        }

        button2.setOnClickListener {
            if (number == 1){
                score++
                number = Random.nextInt(4)
                textView.setTextColor(Color.parseColor(rgbList[number]))
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                randomText()
            }else{
                Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show()
            }
        }

        button3.setOnClickListener {
            if (number == 2){
                score++
                number = Random.nextInt(4)
                textView.setTextColor(Color.parseColor(rgbList[number]))
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                randomText()
            }else{
                Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show()
            }
        }

        button4.setOnClickListener {
            if (number == 3){
                score++
                number = Random.nextInt(4)
                textView.setTextColor(Color.parseColor(rgbList[number]))
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                randomText()
            }else{
                Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun randomText(){
        colorTextNum = Random.nextInt(4)
        colorTextNum1 = Random.nextInt(4)
        colorTextNum2 = Random.nextInt(4)
        colorTextNum3 = Random.nextInt(4)
        colorTextNum4 = Random.nextInt(4)
        textView.text = colorTextList[colorTextNum]
        button1.text = colorTextList[colorTextNum1]
        button2.text = colorTextList[colorTextNum2]
        button3.text = colorTextList[colorTextNum3]
        button4.text = colorTextList[colorTextNum4]

    }







}