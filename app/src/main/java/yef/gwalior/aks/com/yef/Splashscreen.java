package yef.gwalior.aks.com.yef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {
boolean language;
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                language= extras.getBoolean("langkey");
            }
        if(language==false){
            TextView country=findViewById(R.id.splashcountry);
            TextView welcome=findViewById(R.id.splashwelcome);
            TextView nameapp=findViewById(R.id.textView4);
            country.setText("भारत");
            welcome.setText("आपका स्वागत है");
            nameapp.setText("यूथ इम्पावर्मेन्ट फाउन्डेशन");
            nameapp.setGravity(Gravity.CENTER_HORIZONTAL);
            nameapp.setTextSize(35);
        }

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splashscreen.this,LoginByFirebaseActivity.class);
                mainIntent.putExtra("langkey",language);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }


    }



