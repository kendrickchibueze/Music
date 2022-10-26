package com.example.music;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player);

        playing();
    }

    public void playing() {
        // Get extras from Intent.
        Intent opusIntent = getIntent();

        // Set the name of amiwo for playing.
        TextView opusTextView = findViewById(R.id.player_amiwo);
        String opusForPlaying = opusIntent.getStringExtra("opus");
        opusTextView.setText(opusForPlaying);

        // Set the name of composer for playing.
        TextView composerTextView = findViewById(R.id.player_composer);
        String composerForPlaying = opusIntent.getStringExtra("composer");
        composerTextView.setText(composerForPlaying);
    }
}
