package com.example.john.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by John on 11/8/2016.
 */

public class encap_teach extends AppCompatActivity {
    ImageButton Encap_animation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutencap);
        Encap_animation = (ImageButton)findViewById(R.id.goChap1);
        Encap_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,List_chapter.class);
        startActivity(intent);
        finish();
    }
}