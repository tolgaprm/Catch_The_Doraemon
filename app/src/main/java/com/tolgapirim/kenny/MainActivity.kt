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
    private lateinit var handler:Handler
    private var score:Int=0
    private var rastgeleSayi:Int=0
    private val imageList = arrayListOf<ImageView>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageList.add(binding.imageView1)
        imageList.add(binding.imageView2)
        imageList.add(binding.imageView3)
        imageList.add(binding.imageView4)
        imageList.add(binding.imageView5)
        imageList.add(binding.imageView6)
        imageList.add(binding.imageView7)
        imageList.add(binding.imageView8)
        imageList.add(binding.imageView9)



        handler = Handler(Looper.myLooper()!!)

        object :CountDownTimer(15000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.time.text= getString(R.string.time,("${millisUntilFinished/1000}"))
                hideImage()
            }

            override fun onFinish() {
                // alert mesajı

                handler.removeCallbacks(runnable)

                for (image in imageList){
                    image.visibility = View.INVISIBLE
                }

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


    // BU ise resmi gizlemek ve göstermek için yazdığım yeni fonksion
    private fun hideImage(){

        runnable = Runnable {
            for (image in imageList){
                image.visibility = View.INVISIBLE
            }


            rastgeleSayi = (0..8).random()

            imageList[rastgeleSayi].visibility = View.VISIBLE




        }

        handler.post(runnable)

    }


    // ilk başta resim gizlemek ve bir resmi gösterek için kullndığım fonksiyonlar
  /*  private fun image(){


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

        handler.post(runnable)
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

    }*/


    fun increaseScore(view:View){
        score++
        binding.scoreText.text = getString(R.string.score,("$score"))

    }
}
