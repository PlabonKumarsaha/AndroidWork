package com.example.zoomcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
ImageView imageId;
ZoomControls zoomcontrolid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageId = findViewById(R.id.imageId);
        zoomcontrolid = findViewById(R.id.zoomcontrolid);

        zoomcontrolid.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Zoom in",Toast.LENGTH_SHORT).show();
                float X =imageId.getScaleX();
                float Y = imageId.getScaleY();
               imageId.setScaleX((float) X+1);
               imageId.setScaleY((float) Y+1);

            }
        });

        zoomcontrolid.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Zoom out",Toast.LENGTH_SHORT).show();
                float X =imageId.getScaleX();
                float Y = imageId.getScaleY();
                if(X>1 && Y>1){
                imageId.setScaleX((float) X-1);
                imageId.setScaleY((float) Y-1);}
            }
        });

    }
}
