package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private String links[] ={"http://hyperlinkcode.com/images/samample-image.jpg"};
    EditText editTextid;
    ProgressBar progessbarid;
    Button downloadbtn;
    LinearLayout linearLayout;
    ListView listViewID;
    boolean sucessful;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isStoragePermissionGranted()){
        editTextid = findViewById(R.id.editTextid);
        progessbarid = findViewById(R.id.progessbarid);
        downloadbtn = findViewById(R.id.downloadbtn);
        listViewID = findViewById(R.id.listViewID);
        linearLayout = findViewById(R.id.ll);
        downloadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
                MyThread thread = new MyThread();
                thread.start();

                if(sucessful == true)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            linearLayout.setVisibility(View.GONE);
                        }
                    });
                }


            }
        });

        ArrayAdapter<String>adapter =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,links);
        listViewID.setAdapter(adapter);

        listViewID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value = links[position];

                editTextid.setText(value);
            }
        });}
        else {
            isStoragePermissionGranted();
        }



    }

    class MyThread extends  Thread{
        @Override
        public void run() {
            downloadImage(editTextid.getText().toString());

        }
    }


    boolean downloadImage(String url)
    {
      //file read write korle fileoutputstream!
         sucessful = false;
        URL downloadURL = null;
        HttpURLConnection connection = null;
        InputStream inputstream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;
        try
        {
          downloadURL = new URL(url);
          connection = (HttpURLConnection) downloadURL.openConnection();
          inputstream = connection.getInputStream();

          file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+"/"+ Uri.parse(url).getLastPathSegment());
          fileOutputStream = new FileOutputStream(file);
            Toast.makeText(getApplicationContext(),file.getAbsolutePath(),Toast.LENGTH_SHORT).show();
            int read = -1;
            byte[]buffer = new byte[1024];
            while ((read = inputstream.read(buffer))!=-1)
            {
                fileOutputStream.write(buffer,0,read);
            }
            sucessful = true;


        }
        catch (Exception e)
        {
        sucessful = false;
             downloadURL = null;
             connection = null;
             inputstream = null;
             fileOutputStream = null;
             file = null;
        }
        finally {
            if(connection!=null)
            {
                connection.disconnect();
            }
        }
        return  sucessful;
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("per","Permission is granted");
                return true;
            } else {

                Log.v("per","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("per","Permission is granted");
            return true;
        }
    }


}
