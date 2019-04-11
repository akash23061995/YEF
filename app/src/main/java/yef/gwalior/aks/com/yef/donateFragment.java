package yef.gwalior.aks.com.yef;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class donateFragment extends android.support.v4.app.Fragment implements View.OnClickListener{

    public int i=0;
    public View v;
    public View view1,view2,view3,view4,view5,view6;
   public boolean language;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            language=bundle.getBoolean("langkey");
        }

                    v = inflater.inflate(R.layout.donate_fragment, container, false);
        Button button1 = (Button) v.findViewById(R.id.buttond1);
        Button button2 = (Button) v.findViewById(R.id.buttond2);
        Button button3 = (Button) v.findViewById(R.id.buttond3);
        Button button4 = (Button) v.findViewById(R.id.buttond4);
        Button button5 = (Button) v.findViewById(R.id.buttond5);
        Button button6 = (Button) v.findViewById(R.id.buttond6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        TextView t1=v.findViewById(R.id.donatefragt1);
        TextView t2=v.findViewById(R.id.donatefragt2);
        TextView t3=v.findViewById(R.id.donatefragt3);
        TextView t4=v.findViewById(R.id.donatefragt4);
        TextView t5=v.findViewById(R.id.donatefragt5);
        TextView t6=v.findViewById(R.id.donatefragt6);
        TextView t7=v.findViewById(R.id.donatefragt7);
        TextView t8=v.findViewById(R.id.donatefragt8);
        TextView t9=v.findViewById(R.id.donatefragt9);

        if(language==false){
            t1.setText("दान");
            t1.setTextSize(55);
            t2.setText("YEF को आपकी मदद की लगातार आवश्यकता है और यह सुनिश्चित करने में हमारी सहायता करने के लिए कि हमारे पास हमारे प्रतिभाशाली छात्रों का समर्थन करने के लिए हमें क्या चाहिए - हमने अपनी वर्तमान आवश्यकताओं को सूचीबद्ध किया है।");
            t3.setText("दान विकल्प");
            t3.setTextSize(40);
            t4.setText("सामान्य दान ₹ 501");
            t5.setText("अपनी पसंद के दिन 20 बच्चों के लिए नाश्ता, दोपहर का खाना या रात्रिभोज ₹ 2000");
            t6.setText("एक बच्चे के लिए एक वर्ष की किताबें और वर्दी ₹ 6000");
            t7.setText("एक बच्चे के एक वर्ष के लिए छात्रावास और भोजन प्रायोजन ₹ 10000");
            t8.setText("स्कूल बच्चों के लिए कंप्यूटर ₹ 20000");
            t9.setText("एक वर्ष के लिए बच्चे के शिक्षा प्रायोजन ₹ 24000");
            button1.setText("दान");
            button2.setText("दान");
            button3.setText("दान");
            button4.setText("दान");
            button5.setText("दान");
            button6.setText("दान");
            button1.setTextSize(25);
            button2.setTextSize(25);
            button3.setTextSize(25);
            button4.setTextSize(25);
            button5.setTextSize(25);
            button6.setTextSize(25);


        }

        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttond1:
                String open500="open500";
                Intent i=new Intent(getActivity(),WebViewSampleActivity.class);
                i.putExtra("open500",open500);
                i.putExtra("langkey",language);
                startActivity(i);
                break;
            case R.id.buttond2:
                String open2000="open2000";
                Intent i2=new Intent(getActivity(),WebViewSampleActivity.class);
                i2.putExtra("open2000",open2000);
                i2.putExtra("langkey",language);
                startActivity(i2);
                break;
            case R.id.buttond3:
                String open6000="open6000";
                Intent i3=new Intent(getActivity(),WebViewSampleActivity.class);
                i3.putExtra("open6000",open6000);
                i3.putExtra("langkey",language);
                startActivity(i3);
                break;
            case R.id.buttond4:
                String open10000="open10000";
                Intent i4=new Intent(getActivity(),WebViewSampleActivity.class);
                i4.putExtra("open10000",open10000);
                i4.putExtra("langkey",language);
                startActivity(i4);
                break;
            case R.id.buttond5:
                String open20000="open20000";
                Intent i5=new Intent(getActivity(),WebViewSampleActivity.class);
                i5.putExtra("open20000",open20000);
                i5.putExtra("langkey",language);
                startActivity(i5);
                break;
            case R.id.buttond6:
                String open24000="open24000";
                Intent i6=new Intent(getActivity(),WebViewSampleActivity.class);
                i6.putExtra("open24000",open24000);
                i6.putExtra("langkey",language);
                startActivity(i6);
                break;

        }

    }

}