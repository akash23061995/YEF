package yef.gwalior.aks.com.yef;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;
import android.widget.VideoView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);



        final VideoView videoview = (VideoView) findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.yefvideo);
        videoview.setVideoURI(uri);

        videoview.start();

        videoview.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
              Toast.makeText(VideoActivity.this,"Unknown Error Occured.Please start the app again.",Toast.LENGTH_LONG).show();

// do something when an error is occur during the video playback
                return false;
            }
        });
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
// do something when the end of the video is reached

                Intent i=new Intent(VideoActivity.this,LanguageSelect.class);
                Toast.makeText(VideoActivity.this,"Please Sign In",Toast.LENGTH_LONG).show();
                startActivity(i);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"You can sign in after watching video. To avoid Sign In problems, watch it completely.",Toast.LENGTH_LONG).show();
    }

}
