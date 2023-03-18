package com.example.assigement_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rate_us.*

class rate_us : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_us)
        selectrating.setOnClickListener(this)

       //RatingBar simpleRatingBar = (RatingBar)
        //Button submitButton = (Button) findViewById(R.id.submitButton);
        // perform click event on button
//        rate_us.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // get values and then displayed in a toast
//                String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
//                String rating = "Rating :: " + simpleRatingBar.getRating();
//                Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
//            }
//        });
//
//
//    }


    }

    override fun onClick(p0: View?) {
         val total:String = "Total Stars:: " + rateing.getNumStars()
              val  rating = "Rating :: " + rateing.getRating();
                Toast.makeText(getApplicationContext(), total + "\n" + rating, Toast.LENGTH_LONG).show();
            }

    }
