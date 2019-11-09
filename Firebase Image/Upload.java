package com.example.firebaseimagestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button chooseImagebtn,saveImagebtn,displayImagebtn;
    private EditText ImageNameEditText;
    private ImageView imageViewId;
    private Uri imageUri;
    private static final int IMAGE_REQUEST = 1;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    StorageTask uploadTask;
    Uri downloadUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("Upload");
        storageReference = FirebaseStorage.getInstance().getReference("upload");


        imageViewId = findViewById(R.id.imageViewId);
        ImageNameEditText = findViewById(R.id.ImageNameEditText);
        displayImagebtn = findViewById(R.id.displayImagebtn);
        displayImagebtn.setOnClickListener(this);
        saveImagebtn = findViewById(R.id.saveImagebtn);
        saveImagebtn.setOnClickListener(this);
        chooseImagebtn = findViewById(R.id.chooseImagebtn);
        chooseImagebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

       switch (view.getId())
       {
           case R.id.chooseImagebtn :
               openFileChooser();
               break;

           case R.id.saveImagebtn:
               //checking if after clicking save image btn wether we are pressing save image btn over and over!after sucessful upload then we get to upload a nother image
               if(uploadTask!= null && uploadTask.isInProgress())
               {

                   Toast.makeText(getApplicationContext(),"Uploading in progress!",Toast.LENGTH_LONG).show();
               }
               else {
                   saveData();
               }


               break;
           case R.id.displayImagebtn:

               Intent intent = new Intent(MainActivity.this,Image_Activity.class);
               startActivity(intent);

               break;
       }

    }

    public String getFileExtention(Uri imageUri)
    {
        //get the extinsion of a imagefile..ex :jpg,png etc
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));
    }

    private void saveData() {
        final String imageName = ImageNameEditText.getText().toString().trim();
        if(imageName.isEmpty())
        {
            ImageNameEditText.setError("enter image Name");
            ImageNameEditText.requestFocus();
            return;
        }

        Random rand = new Random();
        int n = rand.nextInt();

        StorageReference ref = storageReference.child(System.currentTimeMillis()+n+"."+getFileExtention(imageUri));

        //taken from tools>>firebase>>assistant
        ref.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content

                        Toast.makeText(getApplicationContext(),"sucessfully uploaded",Toast.LENGTH_SHORT).show();

                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isSuccessful())
                          downloadUrl = uriTask.getResult();

                        //datasnapshot has the image location.so we used that to get the imagelocation link!
                        Upload upload = new Upload(imageName,downloadUrl.toString());
                        String uploadId = databaseReference.push().getKey();
                        databaseReference.child(uploadId).setValue(upload);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(getApplicationContext(),"Not stored sucessfully bcz of error :"+exception,Toast.LENGTH_SHORT).show();
                        // ...
                    }
                });

    }

    private void openFileChooser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data!= null && data.getData()!=null)
        {

            imageUri = data.getData();
            Picasso.get().load(imageUri).into(imageViewId);
        }

    }
}
