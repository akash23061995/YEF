package yef.gwalior.aks.com.yef;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewUserWelcomeSplash extends AppCompatActivity {
boolean language;
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    public String uid,name,email,photoUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_welcome_splash);


        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            language= extras.getBoolean("langkey");
            uid=extras.getString("userid");
            name=extras.getString("name");
            email=extras.getString("email");
            photoUrl=extras.getString("photourl");
        }
        if(language==false){

        }

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent i = new Intent(NewUserWelcomeSplash.this,UserProfile.class);
                i.putExtra("langkey",language);
                i.putExtra("userid",uid);
                i.putExtra("name",name);
                i.putExtra("email",email);
                i.putExtra("photourl",photoUrl);

                startActivity(i);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


    }
}
