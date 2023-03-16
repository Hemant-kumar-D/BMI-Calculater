package com.example.assigement_01


//import android.view.View.OnClickListener

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.web_view.*
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var data:String?=null

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
                    edit_2.isEnabled = false
                    edit_1.isEnabled = false

                    btn_1.text = "CLEAR"
                    val wi = edit_1.text.toString().toDouble()
                    val le = edit_2.text.toString().toDouble()
                    val hi = le / 100
                    val answer = wi / (hi * hi)
                    val total=(answer*100).roundToInt()/100.0
                    if(le<=0.0){
                        Toast.makeText(this,"Please fill valid value",Toast.LENGTH_LONG).show()
                       
                    }
                     else {
                        //textview_05.setText( "Your BMI Value =" + total.toString())
                        if (total > 25) {
                            Toast.makeText(this, "You are overweight", Toast.LENGTH_LONG).show()
                           textview_05.setText("You are Overweight \n Your BMI Value= ${total.toString()}")
                        } else if (total < 18) {
                            Toast.makeText(this, "You are underweight", Toast.LENGTH_LONG).show()
                            textview_05.setText("You are Underweight \n Your BMI Value= ${total.toString()}")
                        }
                        else if(total>30){
                            Toast.makeText(this, "You are OBESITY", Toast.LENGTH_LONG).show()
                            textview_05.setText("You are OBERSITY \n Your BMI Value= ${total.toString()}")

                        }
                        else {
                            Toast.makeText(this, "You are fit", Toast.LENGTH_LONG).show()
                            textview_05.setText("You are Fit \n Your BMI Value=${ total.toString()}")
                        }

                    }
                } else if (isclear) {
                    btn_1.text = "Calculate BMi"
                    edit_1.text?.clear()
                    edit_2.text?.clear()
                   textview_05.setText("")
                    edit_2.isEnabled=true
                    edit_1.isEnabled=true

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
                val inten=Intent(this,BMIChart::class.java)
                startActivity(inten)
                return true


            }
            R.id.bmi_chart -> {

                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                return true

            }
//            R.id.bmi_exit -> {
//                finish()
//                System.exit(0)
//
//                Toast.makeText(this,"Exit BMI Appliction",Toast.LENGTH_LONG).show()
//                return true
//
//            }
            R.id.call_menu  ->{
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PERMISSION_GRANTED) {
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse("tel:6396299156")
                    startActivity(intent)
                } else {
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1001
                    )
                }
            }
            R.id.dial ->{
                val intent=Intent(Intent.ACTION_DIAL,Uri.parse("tel:6396299156"))
                startActivity(intent)
            }
            R.id.what_bmi ->{
                val intent=Intent(this,web_view::class.java)

            }
            R.id.email_menu ->{
                val intent=Intent(Intent.ACTION_SENDTO).apply {
                    data=Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("hemantkumar42852@gmail.com"))
                    putExtra(Intent.EXTRA_SUBJECT,"Hello  Friends   I hope you are well-in good ")
                }
                startActivity(intent)

            }


        }
        return super.onOptionsItemSelected(item)
    }


    //    override fun onBackPressed() {
//        val builder:AlertDialog.Builder = AlertDialog.Builder(this)
//        builder.setCancelable(false)
//        builder.setMessage("Do you want to Exit?")
//        builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which -> //if user pressed "yes", then he is allowed to exit from application
//                finish()
//            })
//        builder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which -> //if user select "No", just cancel this dialog and continue with app
//                dialog.cancel()
//            })
//        val alert: AlertDialog = builder.create()
//        alert.show()
//    }
    override fun onBackPressed() {
       val builder:AlertDialog.Builder=AlertDialog.Builder(this).apply {
           setCancelable(false)
           setMessage("Do you want to exit?")
           setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, i ->
               finish()
           })
           setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->dialogInterface.cancel()  })
           val alert:AlertDialog=create()
           alert.show()

       }
    }

}




