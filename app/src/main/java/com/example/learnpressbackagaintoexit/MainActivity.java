package com.example.learnpressbackagaintoexit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public long backPressedTime;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.constraintLayout);


    }

    @Override
    public void onBackPressed() {


        if(backPressedTime+2000>System.currentTimeMillis()){
            super.onBackPressed();
            return;

        }else {
            Snackbar snackbar=Snackbar.make(constraintLayout,"Touch to exit again!!",Snackbar.LENGTH_LONG)
                    .setAction("exit", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finishAffinity();
                        }
                    });

            snackbar.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}