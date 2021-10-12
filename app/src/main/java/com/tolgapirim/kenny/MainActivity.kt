package com.tolgapirim.kenny

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.tolgapirim.kenny.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var runnable: Runnable
    private lateinit var handle:Handler
    private var score:Int=0
    private var rastgeleSayi:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        handle = Handler(Looper.myLooper()!!)

        object :CountDownTimer(15000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.time.text= getString(R.string.time,("${millisUntilFinished/1000}"))
                image()
            }

            override fun onFinish() {
                // alert mesajı

                handle.removeCallbacks(runnable)

                val alert = AlertDialog.Builder(this@MainActivity)
                    .setTitle("Time's Up! ")
                    .setMessage("Restart The Game?")
                    .setPositiveButton("Yes") { _, _ ->
                        val intent = intent
                        finish()
                        startActivity(intent)
                    }
                    .setNegativeButton("No") { _, _ ->
                        finish()
                    }

                alert.show()
            }
        }.start()




    }

    private fun image(){


        runnable = Runnable {
            rastgeleSayi = (1..9).random()

            when(rastgeleSayi){
                1 -> imageGosterOthersGizle(rastgeleSayi,binding.imageView1)
                2 -> imageGosterOthersGizle(rastgeleSayi,binding.imageView2)
                3 -> imageGosterOthersGizle(rastgeleSayi,binding.imageView3)
                4 -> imageGosterOthersGizle(rastgeleSayi,binding.imageView4)
                5 -> imageGosterOthersGizle(rastgeleSayi,binding.imageView5)
                6 -> imageGosterOthersGizle(rastgeleSayi,binding.imageView6)
                7 -> imageGosterOthersGizle(rastgeleSayi,binding.imageView7)
                8 -> imageGosterOthersGizle(rastgeleSayi,binding.imageView8)
                9 -> imageGosterOthersGizle(rastgeleSayi,binding.imageView9)
            }
        }

        handle.post(runnable)
    }



    private fun imageGosterOthersGizle(sayi:Int, imageView: ImageView){
        imageView.visibility = View.VISIBLE
        if (sayi==1){
            binding.imageView2.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView6.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.imageView8.visibility = View.INVISIBLE
            binding.imageView9.visibility = View.INVISIBLE

        }else if(sayi==2){
            binding.imageView1.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView6.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.imageView8.visibility = View.INVISIBLE
            binding.imageView9.visibility = View.INVISIBLE
        }else if(sayi==3){
            binding.imageView1.visibility = View.INVISIBLE
            binding.imageView2.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView6.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.imageView8.visibility = View.INVISIBLE
            binding.imageView9.visibility = View.INVISIBLE
        }else if(sayi==4){
            binding.imageView1.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView2.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView6.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.imageView8.visibility = View.INVISIBLE
            binding.imageView9.visibility = View.INVISIBLE
        }
        else if(sayi==5){
            binding.imageView1.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.imageView2.visibility = View.INVISIBLE
            binding.imageView6.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.imageView8.visibility = View.INVISIBLE
            binding.imageView9.visibility = View.INVISIBLE
        }else if(sayi==6){
            binding.imageView1.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView2.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.imageView8.visibility = View.INVISIBLE
            binding.imageView9.visibility = View.INVISIBLE
        }else if(sayi==7){
            binding.imageView1.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView6.visibility = View.INVISIBLE
            binding.imageView2.visibility = View.INVISIBLE
            binding.imageView8.visibility = View.INVISIBLE
            binding.imageView9.visibility = View.INVISIBLE
        }else if(sayi==8){
            binding.imageView1.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView6.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.imageView2.visibility = View.INVISIBLE
            binding.imageView9.visibility = View.INVISIBLE
        }else if(sayi==9){
            binding.imageView1.visibility = View.INVISIBLE
            binding.imageView3.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView6.visibility = View.INVISIBLE
            binding.imageView7.visibility = View.INVISIBLE
            binding.imageView8.visibility = View.INVISIBLE
            binding.imageView2.visibility = View.INVISIBLE
        }

    }


    fun increaseScore(view:View){
        score++
        binding.scoreText.text = getString(R.string.score,("$score"))

    }
}
