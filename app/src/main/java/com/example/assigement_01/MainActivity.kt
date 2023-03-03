package com.example.assigement_01


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
//import android.view.View.OnClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.round
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isclear = false

        btn_1.setOnClickListener {
            if (!edit_1.text.toString().equals("") && edit_2.text.toString().equals("")) {
                Toast.makeText(this, "Please enter the height", Toast.LENGTH_LONG).show()
                edit_2.requestFocus()
                return@setOnClickListener
            } else if (edit_1.text.toString().equals("") && !edit_2.text.toString().equals("")) {
                Toast.makeText(this, "Please enter the weight", Toast.LENGTH_LONG).show()
                edit_1.requestFocus()
                return@setOnClickListener
            } else if (!edit_1.text.toString().equals("") && !edit_2.text.toString().equals("")) {

                if (!isclear) {
                    Toast.makeText(this, "clear karo", Toast.LENGTH_LONG).show()
                    isclear = true
                    btn_1.text = "CLEAR"
                    val wi = edit_1.text.toString().toDouble()
                    val le = edit_2.text.toString().toDouble()
                    val hi = le / 100
                    val answer = wi / (hi * hi)
                    val total=(answer*100).roundToInt()/100.0

                    textview_1.text = "Your BMI Value ="+total.toString()
                    if (total > 25) {
                        Toast.makeText(this, "You are overweight", Toast.LENGTH_LONG).show()
                        text_2.text = "You are Overweight"
                    } else if (total < 18) {
                        Toast.makeText(this, "You are underweight", Toast.LENGTH_LONG).show()
                        text_2.text = "You are underweight"
                    } else {
                        Toast.makeText(this, "You are fit", Toast.LENGTH_LONG).show()
                        text_2.text = "You are fit"
                    }
                } else if (isclear) {
                    btn_1.text = "Calculate BMi"
                    edit_1.text.clear()
                    edit_2.text.clear()
                    text_2.setText("Stetus")
                    textview_1.setText("BMI VALUE")
                    isclear = false


                }


            } else {
                Toast.makeText(this, "Please enter the value", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_click, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Ab_bmi -> {
                Toast.makeText(this,"About Bmi",Toast.LENGTH_LONG).show()
                return true


            }
            R.id.bmi_chart -> {

                Toast.makeText(this,"BMI Chart",Toast.LENGTH_LONG).show()
                return true

            }
            R.id.bmi_exit -> {
                finish()
                System.exit(0)

                Toast.makeText(this,"Exit BMI Appliction",Toast.LENGTH_LONG).show()
                return true

            }


        }
        return super.onOptionsItemSelected(item)
    }


    override fun onBackPressed() {
       Toast.makeText(this,"not work back button",Toast.LENGTH_LONG).show():
    }
}




