package com.example.assigement_01


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import android.view.View.OnClickListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var isclear = false

        btn_1.setOnClickListener {

            if (!edit_1.text.toString().equals("") && edit_2.text.toString().equals("")) {
                Toast.makeText(this, "Please enter the height", Toast.LENGTH_LONG).show()
            } else if (edit_1.text.toString().equals("") && !edit_2.text.toString().equals("")) {
                Toast.makeText(this, "Please enter the weight", Toast.LENGTH_LONG).show()
            } else if (!edit_1.text.toString().equals("") && !edit_2.text.toString().equals("")) {

                if (!isclear) {
                    Toast.makeText(this, "clear karo", Toast.LENGTH_LONG).show()
                    isclear = true
                    btn_1.text = "CLEAR"
                    val wi = edit_1.text.toString().toDouble()
                    val le = edit_2.text.toString().toDouble()
                    val hi = le / 100
                    val total = wi / (hi * hi)
                    textview_1.text = total.toString()
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
}


