package com.atschoolPioneerSchool;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class show_video_new extends AppCompatActivity {
    VideoView videoView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_show_video_new);
        progressBar=(ProgressBar)findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(View.VISIBLE);
        VideoView videoView=(VideoView)findViewById(R.id.videoview);
        videoView.setVideoURI(Uri.parse("http://ia600607.us.archive.org/14/items/MickeyMouse-RunawayTrain/Film-42.mp4"));
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.reset();
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                progressBar.setVisibility(View.GONE);

            }
        });
        MediaController videoMediaController = new MediaController(this);

        videoMediaController.setMediaPlayer(videoView);
        videoView.setMediaController(videoMediaController);
        videoView.requestFocus();
        videoView.pause();
        videoView.start();
    }
}
