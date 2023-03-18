package com.example.assigement_01

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        web_veiw.webViewClient=MyWebViewClient()
        supportActionBar?.hide()

        web_veiw.loadUrl("https://www.cdc.gov/healthyweight/assessing/bmi/index.html")
    }
    inner class MyWebViewClient : WebViewClient(){
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
          card_view1.visibility = View.GONE


        }
    }
}



