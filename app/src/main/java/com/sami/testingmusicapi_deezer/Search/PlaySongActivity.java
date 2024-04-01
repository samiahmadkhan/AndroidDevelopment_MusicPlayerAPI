package com.sami.testingmusicapi_deezer.Search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sami.testingmusicapi_deezer.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class PlaySongActivity extends AppCompatActivity {

    int position = 0;
    Thread updateSeek;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onDestroy() {
        super.onDestroy();
       mediaPlayer.release();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        ImageView play=findViewById(R.id.play);
        play.setImageResource(R.drawable.pause);
        ImageView songImage=findViewById(R.id.SongImage);
        TextView songTitle=findViewById(R.id.songTitle);
        SeekBar seekBar=findViewById(R.id.seekBar);
        ImageView imageView6=findViewById(R.id.imageView6);



        Intent intent=getIntent();
        Picasso.get().load(intent.getStringExtra("image")).into(imageView6);

        songTitle.setText(intent.getStringExtra("name").toString());
        Picasso.get().load(intent.getStringExtra("image")).into(songImage);
       // Picasso.get().load("https://e-cdns-images.dzcdn.net/images/cover/be682506145061814eddee648edb7c59/500x500-000000-80-0-0.jpg").into(songImage);

        String track=intent.getStringExtra("track").toString();

        try {
            mediaPlayer.setDataSource(track);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                seekBar.setMax(mediaPlayer.getDuration());//to set seekbar duration ( max )
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(fromUser)//from user is when user changes progress bar
                            mediaPlayer.seekTo(progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mediaPlayer.seekTo(seekBar.getProgress());

                    }
                });
              updateSeek=new Thread(){
                  @Override
                  public void run() {
                      int currentPos=0;
                      try{
                          while(currentPos<mediaPlayer.getDuration()){
                              currentPos=mediaPlayer.getCurrentPosition();
                              seekBar.setProgress(currentPos);
                          }

                      }catch (Exception e){
                          e.printStackTrace();
                      }

                  }
              };
              updateSeek.start();
            }
        });

        //5 add this async
        mediaPlayer.prepareAsync();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mediaPlayer.start();
                if(mediaPlayer.isPlaying()) {
                    play.setImageResource(R.drawable.play);
                    mediaPlayer.pause();
                }else {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.pause);
                }


            }
        });




    }
}