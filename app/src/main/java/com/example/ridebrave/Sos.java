package com.example.ridebrave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Sos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sos);
        ImageButton one = (ImageButton) findViewById(R.id.imageButton);
        ImageButton whelp=(ImageButton) findViewById(R.id.imageButton4);
        ImageButton acont=(ImageButton) findViewById(R.id.imageButton3);
        ImageButton sos=(ImageButton) findViewById(R.id.imageButton2);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.alarm);
        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();
            }
        });
        whelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:6306893726"));
                startActivity(callIntent);
            }
        });

        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this,Liveloc.class);
        startActivity(intent);
    }

}
