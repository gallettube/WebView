package com.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest

class MainActivity : AppCompatActivity() {
    var mywebview: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mywebview = findViewById<WebView>(R.id.webview)
        getSupportActionBar()!!.hide();
        val webSettings = mywebview!!.settings
        webSettings.javaScriptEnabled = true
        mywebview!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                Toast.makeText(view.context, "Problema al cargar... puede que tu internet falle", Toast.LENGTH_LONG).show()
                // Si quieres cargar una página de layout cuando hay error  hay que controlar que error
                // setContentView(R.layout.error_layout)
            }
        }
        mywebview!!.loadUrl("https://ccsearch.creativecommons.org/")
    }

}