package com.example.htmlview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView webViewID;
    String Text = "<h1> This is heading one </h1>\n" +
            "<h2> This is heading two </h2>\n"+
            "<h3> This is heading three </h3>\n"+
            "<p> <u>This is a underline paragraph</u> </p>\n" +
            "<p><i> This is italic paragraph </i></p>\n" +
            "Programming order list \n" +
            "<ol>\n" +
            "<li>  C</li>" +
            "<li>  C++</li>" +
            "<li>  JAVA </li>" +
            "</ol>\n";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webViewID = findViewById(R.id.webViewID);
        webViewID.loadDataWithBaseURL(null,Text,"text/html","utf-8",null);


    }
}
