package com.ensitech.capturacamara;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnCamera;
    ImageView imagenCamera;
    String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamera = findViewById(R.id.button);
        imagenCamera = findViewById(R.id.imageView);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestCamera();
            }
        });
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //Revisar si camara está activa API 23 (6.0 Marshmallow) o superior
            if (checkSelfPermission(CAMERA_SERVICE) == PackageManager.PERMISSION_DENIED) {
                requestCameraPermission();
            }
        }else{
            //Revisar si camara está activa
            if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
                requestCameraPermission();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1000){
            switch (resultCode){
                case RESULT_OK:
                    Bitmap imageBitmap = BitmapFactory.decodeFile(currentPhotoPath);
                    imagenCamera.setImageBitmap(imageBitmap);

                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "Fotografía cancelada", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void requestCameraPermission(){
        //Solicitar permiso sobre cámara   *Actividad       *Lista de permisos                  *Codigo de petición
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CAMERA, }, 1);
    }

    public void requestCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Verifica que el activity que recibe la respuesta exista
        if(cameraIntent.resolveActivity(getPackageManager()) != null){
            // Iniciando la cámara
            //startActivityForResult(cameraIntent, 1000);/*
            // Guardar la imagen en un archivo temporal
            File photoFile = null;
            try {
                photoFile = createImageFile(); //Crea archivo
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            if (photoFile != null) {
                Uri photoUri = FileProvider.getUriForFile(
                        this, //Actividad (contexto)
                        "com.ensitech.capturacamara.fileprovider", //autoridad
                        photoFile); // Archivo
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                // Iniciando la cámara
                startActivityForResult(cameraIntent, 1000);
            }
            //*/
        }
    }

    public File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat(
                "yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",   /* suffix */
                storageDir      /* directory */
        );
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}
