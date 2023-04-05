package com.example.pam_672020273;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MediaActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private boolean isPlaying = false;
    private Handler handler = new Handler();
    private ProgressBar pos;
    private TextView tv1;
    private EditText txtURL;
    Uri theVidUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        mPlayer = MediaPlayer.create(this, R.raw.lagu);
        pos = (ProgressBar)findViewById(R.id.progressBar);
        tv1 = (TextView) findViewById(R.id.textView);
        txtURL = (EditText) findViewById(R.id.txtURL);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCari:
                Intent i1 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                i1.addCategory(Intent.CATEGORY_OPENABLE);
                i1.setType("video/mp4");
                i1.putExtra(DocumentsContract.EXTRA_INITIAL_URI,"");
                startActivityForResult(i1,1);
                break;
            case R.id.btnVid:
                if (theVidUri!=null) {
                    Toast.makeText(this, theVidUri.getPath(), Toast.LENGTH_SHORT).show();
                    VideoView vv = (VideoView) findViewById(R.id.videoView);
                    MediaController mediaController= new MediaController(this);
                    mediaController.setAnchorView(vv);
                    mediaController.setMediaPlayer(vv);
                    vv.setMediaController(mediaController);
                    vv.setVideoURI(theVidUri);
                    vv.requestFocus();
                    vv.start();
                } else if (txtURL.getText().toString().length()>0) {
                    String strUrl = txtURL.getText().toString();
                    if (URLUtil.isValidUrl(strUrl)) {
                        Toast.makeText(this, "stream: " + strUrl, Toast.LENGTH_SHORT).show();
                        VideoView vv = (VideoView) findViewById(R.id.videoView);
                        MediaController mediaController = new MediaController(this);
                        mediaController.setAnchorView(vv);
                        mediaController.setMediaPlayer(vv);
                        vv.setMediaController(mediaController);
                        theVidUri= Uri.parse(strUrl);
                        vv.setVideoURI(theVidUri);
                        vv.requestFocus();
                        vv.start();
                    }
                    else Toast.makeText(this,"URL salah", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(this,"pilih berkas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAud:
                if (isPlaying) {
                    Toast.makeText(this,"jeda", Toast.LENGTH_SHORT).show();
                    mPlayer.pause();
                    isPlaying=false;
                }
                else {
                    Toast.makeText(this,"mainkan berkas audio", Toast.LENGTH_SHORT).show();
                    pos.setMax(mPlayer.getDuration());
                    mPlayer.start();
                    handler.postDelayed(UpdateSongTime, 100);
                    isPlaying=true;
                }
                break;
        }
    }

    protected void onActivityResult(int reqCode, int resCode, Intent resData) {
        Toast.makeText(this,"berkas ada", Toast.LENGTH_SHORT).show();
        super.onActivityResult(reqCode, resCode, resData);
        switch (reqCode) {
            case 1:
                if (resCode == Activity.RESULT_OK) {
                    Uri uri = null;
                    if (resData!=null) {
                        uri = resData.getData();
                        theVidUri=uri;
                        txtURL.setText("");
                    }

                }
                break;
        }
    }

    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            int sTime = mPlayer.getCurrentPosition();
            tv1.setText(String.valueOf(sTime));
            pos.setProgress(sTime);
            handler.postDelayed(this, 100);
        }
    };
}