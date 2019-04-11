package yef.gwalior.aks.com.yef;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Application;
import android.widget.Toast;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class LanguageSelect extends AppCompatActivity {
  boolean language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_select);
        MediaPlayer mPlayer = MediaPlayer.create(LanguageSelect.this, R.raw.classical_melody);
        mPlayer.start();

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("This application needs Internet connection to function.Please turn your mobile data ON.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();


    }
    public void english(View view)
    {
    language=true;
        Intent i=new Intent(this,Splashscreen.class);
        i.putExtra("langkey",language);
        startActivity(i);

    }
    public void hindi(View view)
    {
    language=false;
        Intent i=new Intent(this,Splashscreen.class);
        i.putExtra("langkey",language);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Do you want to Exit?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);

                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}
