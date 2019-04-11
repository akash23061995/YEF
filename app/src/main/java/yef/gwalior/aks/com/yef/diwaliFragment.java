package yef.gwalior.aks.com.yef;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class diwaliFragment  extends android.support.v4.app.Fragment implements View.OnClickListener{

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

        v = inflater.inflate(R.layout.diwali_fragment, container, false);
        ViewFlipper viewFlipper = (ViewFlipper)v.findViewById(R.id.flipperid);
        viewFlipper.startFlipping();

       Button b11=v.findViewById(R.id.diwalireadmore1);
        Button b12=v.findViewById(R.id.diwalireadmore2);
        Button b13=v.findViewById(R.id.diwalireadmore3);
        Button b14=v.findViewById(R.id.diwalireadmore4);
        Button b15=v.findViewById(R.id.diwalireadmore5);
        Button b16=v.findViewById(R.id.diwalireadmore6);
        Button b21=v.findViewById(R.id.diwalidonate1);
        Button b22=v.findViewById(R.id.diwalidonate2);
        Button b23=v.findViewById(R.id.diwalidonate3);
        Button b24=v.findViewById(R.id.diwalidonate4);
        Button b25=v.findViewById(R.id.diwalidonate5);
        Button b26=v.findViewById(R.id.diwalidonate6);
        Button b31=v.findViewById(R.id.diwalipaytm1);
        Button b32=v.findViewById(R.id.diwalipaytm2);
        Button b33=v.findViewById(R.id.diwalipaytm3);
        Button b34=v.findViewById(R.id.diwalipaytm4);
        Button b35=v.findViewById(R.id.diwalipaytm5);
        Button b36=v.findViewById(R.id.diwalipaytm6);
        TextView t1=v.findViewById(R.id.diwalit1);
        TextView t2=v.findViewById(R.id.diwalit2);
        TextView t3=v.findViewById(R.id.diwalit3);
        TextView t4=v.findViewById(R.id.diwalit4);
        TextView t5=v.findViewById(R.id.diwalit5);
        TextView t6=v.findViewById(R.id.diwalit6);
        TextView t7=v.findViewById(R.id.diwalit7);

        TextView bank1=v.findViewById(R.id.diwalibank1);
        TextView bank2=v.findViewById(R.id.diwalibank2);
        TextView bank3=v.findViewById(R.id.diwalibank3);
        TextView bank4=v.findViewById(R.id.diwalibank4);
        TextView bank5=v.findViewById(R.id.diwalibank5);
        TextView bank6=v.findViewById(R.id.diwalibank6);

        bank1.setText("NEFT/IMPS/RTGS (From Banks in India only)\n Account number: 700701707077034\n Account name: Community Women\n IFSC code: YESB0CMSNOC \n-------------------------------------\nUPI Handle: supportcommunity11@yesbankltd\nDirect UPI Pay (Android Only): http://impactgu.ru/upi-community-women");
        bank2.setText("NEFT/IMPS/RTGS (From Banks in India only)\n Account number: 700701707077034\n Account name: Community Women\n IFSC code: YESB0CMSNOC \n-------------------------------------\nUPI Handle: supportcommunity11@yesbankltd\nDirect UPI Pay (Android Only): http://impactgu.ru/upi-community-women");
        bank3.setText("NEFT/IMPS/RTGS (From Banks in India only)\n Account number: 700701707077034\n Account name: Community Women\n IFSC code: YESB0CMSNOC \n-------------------------------------\nUPI Handle: supportcommunity11@yesbankltd\nDirect UPI Pay (Android Only): http://impactgu.ru/upi-community-women");
        bank4.setText("NEFT/IMPS/RTGS (From Banks in India only)\n Account number: 700701707077034\n Account name: Community Women\n IFSC code: YESB0CMSNOC \n-------------------------------------\nUPI Handle: supportcommunity11@yesbankltd\nDirect UPI Pay (Android Only): http://impactgu.ru/upi-community-women");
        bank5.setText("NEFT/IMPS/RTGS (From Banks in India only)\n Account number: 700701707077034\n Account name: Community Women\n IFSC code: YESB0CMSNOC \n-------------------------------------\nUPI Handle: supportcommunity11@yesbankltd\nDirect UPI Pay (Android Only): http://impactgu.ru/upi-community-women");
        bank6.setText("NEFT/IMPS/RTGS (From Banks in India only)\n Account number: 700701707077034\n Account name: Community Women\n IFSC code: YESB0CMSNOC \n-------------------------------------\nUPI Handle: supportcommunity11@yesbankltd\nDirect UPI Pay (Android Only): http://impactgu.ru/upi-community-women");


        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);
        b15.setOnClickListener(this);
        b16.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);
        b23.setOnClickListener(this);
        b24.setOnClickListener(this);
        b25.setOnClickListener(this);
        b26.setOnClickListener(this);
        b31.setOnClickListener(this);
        b32.setOnClickListener(this);
        b33.setOnClickListener(this);
        b34.setOnClickListener(this);
        b35.setOnClickListener(this);
        b36.setOnClickListener(this);

        if(language==false){
           t1.setText("यह दिवाली, हमें मोमबत्ती बनाने के काम में कुछ महिलाओं को रोजगार दिलाने में मदद करें।");
           t2.setText("YEF एक गैर सरकारी संगठन है जो वंचित समुदाय के लिए शिक्षा, कौशल प्रशिक्षण और रोजगार के लिए काम कर रहा है। हमने पिछले साल दिवाली के दौरान हमारे केंद्र में मोमबत्ती बनाने की कार्यशाला आयोजित की थी।");
           t3.setText("कई वंचित लड़कियां और महिलाएं कला सीखती हैं और उन मोमबत्तियों को बेचकर थोड़ी सी कमाई करती हैं। हमारे प्रयोग ने एक प्रभाव लाया जो इस साल से कई लोगों को लाभ पहुंचा सकता है।");
           t4.setText("पिछले साल परियोजना को केवल संस्थापक द्वारा वित्त पोषित किया गया था और कुल व्यय लगभग 1.5 लाख था.अब हम आपकी मदद चाहते हैं, आपका छोटा योगदान कुछ और ज़िंदगी में प्रकाश ला सकता है।");
            t5.setText("हमें प्रशिक्षण और काम के लिए आवश्यक कच्चे माल और उपकरणों को खरीदने की जरूरत है। उत्पादन के बाद हम बाजार स्थानों और कंपनियों को बेचने के लिए स्टालों की स्थापना करेंगे ।");
            t6.setText("जो लोग प्रशिक्षण लेते हैं वे अपना खुद का छोटा व्यवसाय शुरू कर सकते हैं और अपनी आजीविका कमा सकते हैं।");
            t7.setText("आइये मुस्कान बिखेरें ...! :)");
            b11.setText("यहां और पढ़ें");
            b12.setText("यहां और पढ़ें");
            b13.setText("यहां और पढ़ें");
            b14.setText("यहां और पढ़ें");
            b15.setText("यहां और पढ़ें");
            b16.setText("यहां और पढ़ें");
            b21.setText("यहां दान करें");
            b22.setText("यहां दान करें");
            b23.setText("यहां दान करें");
            b24.setText("यहां दान करें");
            b25.setText("यहां दान करें");
            b26.setText("यहां दान करें");
            b31.setText("Paytm द्वारा दान करें");
            b32.setText("Paytm द्वारा दान करें");
            b33.setText("Paytm द्वारा दान करें");
            b34.setText("Paytm द्वारा दान करें");
            b35.setText("Paytm द्वारा दान करें");
            b36.setText("Paytm द्वारा दान करें");

        }

        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        return v;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.diwalireadmore1:
                String readmore1="readmore";
                Intent i11=new Intent(getActivity(),WebViewSampleActivity.class);
                i11.putExtra("readmore",readmore1);
                i11.putExtra("langkey",language);
                startActivity(i11);
                break;
            case R.id.diwalireadmore2:
                String readmore2="readmore";
                Intent i12=new Intent(getActivity(),WebViewSampleActivity.class);
                i12.putExtra("readmore",readmore2);
                i12.putExtra("langkey",language);
                startActivity(i12);
                break;
            case R.id.diwalireadmore3:
                String readmore3="readmore";
                Intent i13=new Intent(getActivity(),WebViewSampleActivity.class);
                i13.putExtra("readmore",readmore3);
                i13.putExtra("langkey",language);
                startActivity(i13);
                break;
            case R.id.diwalireadmore4:
                String readmore4="readmore";
                Intent i14=new Intent(getActivity(),WebViewSampleActivity.class);
                i14.putExtra("readmore",readmore4);
                i14.putExtra("langkey",language);
                startActivity(i14);
                break;
            case R.id.diwalireadmore5:
                String readmore5="readmore";
                Intent i15=new Intent(getActivity(),WebViewSampleActivity.class);
                i15.putExtra("readmore",readmore5);
                i15.putExtra("langkey",language);
                startActivity(i15);
                break;
            case R.id.diwalireadmore6:
                String readmore6="readmore";
                Intent i16=new Intent(getActivity(),WebViewSampleActivity.class);
                i16.putExtra("readmore",readmore6);
                i16.putExtra("langkey",language);
                startActivity(i16);
                break;

            case R.id.diwalidonate1:
                String donate1="donatediwali";
                Intent i21=new Intent(getActivity(),WebViewSampleActivity.class);
                i21.putExtra("donatediwali",donate1);
                i21.putExtra("langkey",language);
                startActivity(i21);
                break;

            case R.id.diwalidonate2:
                String donate2="donatediwali";
                Intent i22=new Intent(getActivity(),WebViewSampleActivity.class);
                i22.putExtra("donatediwali",donate2);
                i22.putExtra("langkey",language);
                startActivity(i22);
                break;
            case R.id.diwalidonate3:
                String donate3="donatediwali";
                Intent i23=new Intent(getActivity(),WebViewSampleActivity.class);
                i23.putExtra("donatediwali",donate3);
                i23.putExtra("langkey",language);
                startActivity(i23);
                break;
            case R.id.diwalidonate4:
                String donate4="donatediwali";
                Intent i24=new Intent(getActivity(),WebViewSampleActivity.class);
                i24.putExtra("donatediwali",donate4);
                i24.putExtra("langkey",language);
                startActivity(i24);
                break;
            case R.id.diwalidonate5:
                String donate5="donatediwali";
                Intent i25=new Intent(getActivity(),WebViewSampleActivity.class);
                i25.putExtra("donatediwali",donate5);
                i25.putExtra("langkey",language);
                startActivity(i25);
                break;
            case R.id.diwalidonate6:
                String donate6="donatediwali";
                Intent i26=new Intent(getActivity(),WebViewSampleActivity.class);
                i26.putExtra("donatediwali",donate6);
                i26.putExtra("langkey",language);
                startActivity(i26);
                break;


            case R.id.diwalipaytm1:
                try {String url = "http://impactgu.ru/paytm-community-women-1";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                } catch (android.content.ActivityNotFoundException anfe) {
                    final String appPackageName = "net.one97.paytm";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));

                }
                break;

            case R.id.diwalipaytm2:
                try {String url = "http://impactgu.ru/paytm-community-women-1";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                } catch (android.content.ActivityNotFoundException anfe) {
                    final String appPackageName = "net.one97.paytm";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));

                }
                break;
            case R.id.diwalipaytm3:
                try {String url = "http://impactgu.ru/paytm-community-women-1";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                } catch (android.content.ActivityNotFoundException anfe) {
                    final String appPackageName = "net.one97.paytm";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));

                }
                break;
            case R.id.diwalipaytm4:
                try {String url = "http://impactgu.ru/paytm-community-women-1";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                } catch (android.content.ActivityNotFoundException anfe) {
                    final String appPackageName = "net.one97.paytm";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));

                }
                break;
                case R.id.diwalipaytm5:
                    try {String url = "http://impactgu.ru/paytm-community-women-1";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    } catch (android.content.ActivityNotFoundException anfe) {
                        final String appPackageName = "net.one97.paytm";
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));

                    }
                    break;
            case R.id.diwalipaytm6:
                try {String url = "http://impactgu.ru/paytm-community-women-1";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                } catch (android.content.ActivityNotFoundException anfe) {
                    final String appPackageName = "net.one97.paytm";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));

                }
                break;
        }

    }

}
