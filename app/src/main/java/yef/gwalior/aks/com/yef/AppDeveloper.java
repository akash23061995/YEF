package yef.gwalior.aks.com.yef;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppDeveloper extends AppCompatActivity {
public boolean language;
public String uid="dN6UruCtBuTO0IFJWPO1zuy36903";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_developer);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            language= extras.getBoolean("langkey");

        }
        if(language==false){
            TextView t1=findViewById(R.id.appdevelopert1);
            TextView t2=findViewById(R.id.appdevelopert2);
            TextView t3=findViewById(R.id.appdevelopert3);
            TextView t4=findViewById(R.id.appdevelopert4);
            TextView t5=findViewById(R.id.appdevelopert5);
            TextView t6=findViewById(R.id.appdevelopert6);
            TextView t7=findViewById(R.id.appdevelopert7);
            Button b1=findViewById(R.id.viewdeveloperprofile);
            t1.setText("आकाश सोनी");
            t2.setText("एकीकृत स्नातकोत्तर छात्र");
            t3.setText("सूचना प्रौद्योगिकी");
            t4.setText("अटल बिहारी वाजपेयी भारतीय सूचना प्रौद्योगिकी और प्रबंधन संस्थान");
            t7.setText("मैं सूचना प्रौद्योगिकी में अटल बिहारी वाजपेयी भारतीय सूचना प्रौद्योगिकी और प्रबंधन संस्थान ग्वालियर से एकीकृत एम.टेक कर रहा हूं। अगर इस एप्लिकेशन के बारे में आपके कोई प्रश्न हैं, तो मुझसे संपर्क करने में संकोच न करें। आपके सुझाव और प्रतिक्रियाएं हमारे लिए मुल्यवान और महत्वपूर्ण हैं। अगर आपके पास मोबाइल एप्लिकेशन डेवलपमेंट का कोई काम है , मुझसे संपर्क करने में संकोच न करें, मैं आपको संबंधित काम से मदद करूंगा।");
            b1.setText("YEF प्रोफाइल देखें");


        }


    }

    public void gmailDeveloper(View view){
        Intent emailSelectorIntent = new Intent(Intent.ACTION_SENDTO);
        emailSelectorIntent.setData(Uri.parse("mailto:"));

        final Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"akashsoni987654321@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query @ App Developer");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Write your query here....");
        emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        emailIntent.setSelector( emailSelectorIntent );

        startActivity(emailIntent);
    }
    public void viewDeveloperProfile(View view){
        boolean appdeveloper=true;
        Intent i=new Intent(this,ShowProfile.class);
        i.putExtra("uid",uid);
        i.putExtra("langkey",language);
        i.putExtra("appdeveloper",appdeveloper);
        startActivity(i);
    }

}
