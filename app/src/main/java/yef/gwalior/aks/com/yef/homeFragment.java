package yef.gwalior.aks.com.yef;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class homeFragment extends android.support.v4.app.Fragment  implements View.OnClickListener{
public  boolean language;
public int i=0;
public View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
             i = bundle.getInt("val");
            language=bundle.getBoolean("langkey");
        }

        if(i==1) {
            v = inflater.inflate(R.layout.home_fragment, container, false);
            ViewFlipper flipper=v.findViewById(R.id.flipperid3);
            flipper.startFlipping();
            flipper.setInAnimation(getContext(), R.anim.fade_in);
            flipper.setOutAnimation(getContext(), R.anim.fade_out);
            TextView t1 = v.findViewById(R.id.nameapphome1);
            TextView t2 = v.findViewById(R.id.applogotext1);
            TextView t3 = v.findViewById(R.id.applogodetail1);
            if (language == false) {
                TextView t11=v.findViewById(R.id.nameapphome1);
                TextView t12=v.findViewById(R.id.applogotext1);
                TextView t13=v.findViewById(R.id.applogodetail1);
                TextView t21=v.findViewById(R.id.nameapphome2);
                TextView t22=v.findViewById(R.id.applogotext2);
                TextView t23=v.findViewById(R.id.applogodetail2);
                TextView t31=v.findViewById(R.id.nameapphome3);
                TextView t32=v.findViewById(R.id.applogotext3);
                TextView t33=v.findViewById(R.id.applogodetail3);
                TextView t41=v.findViewById(R.id.nameapphome4);
                TextView t42=v.findViewById(R.id.applogotext4);
                TextView t43=v.findViewById(R.id.applogodetail4);
                TextView t51=v.findViewById(R.id.nameapphome5);
                TextView t52=v.findViewById(R.id.applogotext5);
                TextView t53=v.findViewById(R.id.applogodetail5);
                TextView t61=v.findViewById(R.id.nameapphome6);
                TextView t62=v.findViewById(R.id.applogotext6);
                TextView t63=v.findViewById(R.id.applogodetail6);
                TextView t71=v.findViewById(R.id.nameapphome7);
                TextView t72=v.findViewById(R.id.applogotext7);
                TextView t73=v.findViewById(R.id.applogodetail7);

                t11.setText("यूथ इम्पावर्मेन्ट फाउन्डेशन");
                t12.setText("युवा सोच का परिवर्तन");
                t13.setText("हर बच्चे और युवा को बेहतर, आत्मनिर्भर व्यक्ति बनाने के लिये सशक्त बनाना जो अपने कौशल की सहायता से अपनी शिक्षा को वित्त पोषित कर सकते हैं और एक अधिक शिक्षित समाज की ओर काम कर सकते हैं");
                t13.setTextSize(22);
                t11.setTextSize(38);
                t21.setText("यूथ इम्पावर्मेन्ट फाउन्डेशन");
                t22.setText("युवा सोच का परिवर्तन");
                t23.setText("हर बच्चे और युवा को बेहतर, आत्मनिर्भर व्यक्ति बनाने के लिये सशक्त बनाना जो अपने कौशल की सहायता से अपनी शिक्षा को वित्त पोषित कर सकते हैं और एक अधिक शिक्षित समाज की ओर काम कर सकते हैं");
                t23.setTextSize(22);
                t21.setTextSize(38);
                t31.setText("यूथ इम्पावर्मेन्ट फाउन्डेशन");
                t32.setText("युवा सोच का परिवर्तन");
                t33.setText("हर बच्चे और युवा को बेहतर, आत्मनिर्भर व्यक्ति बनाने के लिये सशक्त बनाना जो अपने कौशल की सहायता से अपनी शिक्षा को वित्त पोषित कर सकते हैं और एक अधिक शिक्षित समाज की ओर काम कर सकते हैं");
                t33.setTextSize(22);
                t31.setTextSize(38);
                t41.setText("यूथ इम्पावर्मेन्ट फाउन्डेशन");
                t42.setText("युवा सोच का परिवर्तन");
                t43.setText("हर बच्चे और युवा को बेहतर, आत्मनिर्भर व्यक्ति बनाने के लिये सशक्त बनाना जो अपने कौशल की सहायता से अपनी शिक्षा को वित्त पोषित कर सकते हैं और एक अधिक शिक्षित समाज की ओर काम कर सकते हैं");
                t43.setTextSize(22);
                t41.setTextSize(38);
                t51.setText("यूथ इम्पावर्मेन्ट फाउन्डेशन");
                t52.setText("युवा सोच का परिवर्तन");
                t53.setText("हर बच्चे और युवा को बेहतर, आत्मनिर्भर व्यक्ति बनाने के लिये सशक्त बनाना जो अपने कौशल की सहायता से अपनी शिक्षा को वित्त पोषित कर सकते हैं और एक अधिक शिक्षित समाज की ओर काम कर सकते हैं");
                t53.setTextSize(22);
                t51.setTextSize(38);
                t61.setText("यूथ इम्पावर्मेन्ट फाउन्डेशन");
                t62.setText("युवा सोच का परिवर्तन");
                t63.setText("हर बच्चे और युवा को बेहतर, आत्मनिर्भर व्यक्ति बनाने के लिये सशक्त बनाना जो अपने कौशल की सहायता से अपनी शिक्षा को वित्त पोषित कर सकते हैं और एक अधिक शिक्षित समाज की ओर काम कर सकते हैं");
                t63.setTextSize(22);
                t61.setTextSize(38);
                t71.setText("यूथ इम्पावर्मेन्ट फाउन्डेशन");
                t72.setText("युवा सोच का परिवर्तन");
                t73.setText("हर बच्चे और युवा को बेहतर, आत्मनिर्भर व्यक्ति बनाने के लिये सशक्त बनाना जो अपने कौशल की सहायता से अपनी शिक्षा को वित्त पोषित कर सकते हैं और एक अधिक शिक्षित समाज की ओर काम कर सकते हैं");
                t73.setTextSize(22);
                t71.setTextSize(38);


            }
        }
        if(i==2) {
            v = inflater.inflate(R.layout.aboutus_fragment, container, false);
            TextView t1=v.findViewById(R.id.aboutusfrag1);
            TextView t2=v.findViewById(R.id.aboutusfrag2);
            TextView t3=v.findViewById(R.id.aboutusfrag3);
            TextView t4=v.findViewById(R.id.aboutusfrag4);
            if (language == false) {

                t1.setText("हमारे बारे मे");
                t2.setText("युवा सोच का परिवर्तन");
                t3.setText("द्र्ष्टिकोण");
                t4.setText("हम यूथ इम्पावर्मेन्ट फाउन्डेशन में बच्चों और युवाओं को शिक्षित,विकसित और सशक्त बनाना चाहते है ताकि वे अपने कौशल के आधार पर अपने शिक्षा का मार्ग प्रशस्त कर सकें । यह प्रयास ना केवल वन्चित लोगो की मदद करने के लिये बल्कि एक अधिक शिक्षित और साक्षर समाज की ओर काम करने के लिये है ");
                t2.setTextSize(35);

            }
        }
        if(i==3) {
            v = inflater.inflate(R.layout.events_fragments, container, false);
            TextView t1 = v.findViewById(R.id.eventfragt1);
            TextView t2 = v.findViewById(R.id.eventfragt2);
            TextView t3 = v.findViewById(R.id.eventfragt3);
            TextView t4 = v.findViewById(R.id.eventfragt4);
            TextView t5 = v.findViewById(R.id.eventfragt5);
            TextView t6 = v.findViewById(R.id.eventfragt6);
            TextView t7 = v.findViewById(R.id.eventfragt7);

            if (language == false) {
                t1.setText("आयोजन");
                t2.setText("शिक्षा केंद्र");
                t3.setText("हमारे यहां दो केन्द्र हैं जो समग्र शिक्षा प्रदान करते हैं,कौशल विकास ,सामाजिक जागरुकता और वंचित समुदायों के लिये बहुत कुछ प्रदान करते हैं । २०० से अधिक वंचित बच्चों ने हमारे केन्द्रों में अद्धययन किया है और इससे कहीं ज्यादा बच्चों को फायदा हुआ है । हम न केवल शिक्षा और उपयोगी कौशल प्रदान करते है बल्कि कार्यशाला और व्यक्तिगत परामर्श सत्र भी आयोजित करते है ताकि यह सुनिश्चित किया जा सके कि प्रत्येक बच्चा नैतिक मुल्यों के उच्च मानकों के साथ आगे बढता है । उन्हे विभिन्न सार्वजनिक मन्चो पर अपनी प्रतिभाओं को प्रदर्शित करने का अवसर प्रदान किया जाता है , इस प्रकार आसपास के इलाको से आनेवाले लोगो की भी भावना प्रेरित होती है । इसके अलावा हम उन्हे अन्य संगठनों के सहयोग से स्वास्थ्य सेवायें भी प्रदान करते है ");
                t4.setText("अंग्रेजी सीखने के कार्यक्रम ");
                t5.setText("अंग्रेजी आज सबसे अधिक बोले जाने वाली भाषा है । हम चाहते है कि हमारे छात्र नौकरियों और अवसरों के लिये अन्य स्कूलों के छात्रों के साथ प्रतिस्पर्धा करने मे सक्षम हों । यहां बच्चे अनुकुलनीय और महत्वकांक्षी व्यक्तित्व विकसित करते हैं और अंग्रेजी मे धाराप्रवाह होना सीखते हैं । निचले वर्ग के बच्चों के अंग्रेजी के साथ सन्घर्ष के चलते हमने एक विशेष भाषा कक्षा शुरु की");
                t6.setText("कंप्यूटर प्रशिक्षण कार्यक्रम");
                t7.setText("वर्तमान पीढी जिसमे हम रहते है वह बेहद तकनीकी है और इलेक्ट्रोनिक गैजेट हमारे जीवन पर हावी है । उच्च तकनीकी दुनिया के साथ कंप्यूटर ज्ञान महत्वपूर्ण है। बच्चों को कंप्यूटर शिक्षा प्रदान करने की आवश्यकता महसूस हुई क्योंकि बच्चों ने कंप्यूटर ज्ञान के लिए गहरी दिलचस्पी दिखाई है। कंप्यूटर शिक्षा को उनके लिए सुलभ बनाना हमारी प्राथमिकता बन गया है। ध्यान में रखते हुए, एक कंप्यूटर कक्षा कार्यक्रम शुरू किया गया है।");
            }
        }
        if(i==4) {
            v = inflater.inflate(R.layout.product_fragment, container, false);
            TextView t1=v.findViewById(R.id.productfragt1);
            TextView t2=v.findViewById(R.id.productfragt2);
            TextView t3=v.findViewById(R.id.productfragt3);
            TextView t4=v.findViewById(R.id.productfragt4);
            TextView t5=v.findViewById(R.id.productfragt5);
            TextView t6=v.findViewById(R.id.productfragt6);
            TextView t7=v.findViewById(R.id.productfragt7);
            TextView t8=v.findViewById(R.id.productfragt8);
            TextView t9=v.findViewById(R.id.productfragt9);
            TextView t10=v.findViewById(R.id.productfragt10);
            TextView t11=v.findViewById(R.id.productfragt11);
            TextView t12=v.findViewById(R.id.productfragt12);
            TextView t13=v.findViewById(R.id.productfragt13);
            TextView t14=v.findViewById(R.id.productfragt14);
            if(language==false){
                t1.setText("उत्पाद");
                t2.setText("कौशल प्रशिक्षण आजीविका ड्राइव");
                t3.setText("एलईडी बल्ब बनाने का प्रशिक्षण");
                t4.setText("एलईडी बल्ब उन छात्रों द्वारा किए जा रहे हैं जो अपनी पढ़ाई छोड़ने के किनारे थे, लेकिन अब हमारे छोटे प्रयास ने उन्हें आत्मनिर्भर बना दिया। वे न केवल अपनी शिक्षा जारी रखते हैं बल्कि अपने परिवार की जरूरतों को पूरा करने के लिए भी कमाई कर रहे हैं ।");
                t5.setText("मोमबत्ती बनाने का प्रशिक्षण");
                t6.setText("यह दिवाली महोत्सव के दौरान किया गया था। हमने आवश्यक सभी कच्चे माल खरीदे, कुछ ज़रूरतमंद महिलाओं और युवाओं को रोजगार दिया और मोमबत्ती बनाने की प्रक्रिया के साथ उन्हें प्रशिक्षित किया। उन्होंने मोमबत्तियों के 4000 से अधिक पैकेट बनाए और हमने उन्हें पैसे कमाने का अवसर दिया और स्वतंत्र रूप से काम करने के लिए उनका आत्मविश्वास बनाया।");
                t7.setText("हर्बल गुलाल बनाने का प्रशिक्षण");
                t8.setText("इसी प्रकार, उन्होंने इस साल होली त्यौहार के दौरान गुलाल बनाया। हमने उन्हें पेपर बैग मेकिंग, कान की बाली बनाने, क्विलिंग आर्ट, गायन, नृत्य, स्कीट इत्यादि जैसे स्टेज प्रदर्शनों में भी प्रशिक्षित किया।");
                t9.setText("मोमबत्ती बनाने का प्रशिक्षण");
                t10.setText("मोमबत्ती बनाने का प्रशिक्षण");
                t11.setText("मोमबत्ती बनाने का प्रशिक्षण");
                t12.setText("दीया बनाने का प्रशिक्षण");
                t13.setText("दीया बनाने का प्रशिक्षण");
                t14.setText("दीया बनाने का प्रशिक्षण");

            }

        }
        if(i==5) {
            v = inflater.inflate(R.layout.update_fragment, container, false);
            TextView t1 = v.findViewById(R.id.updatefrag1);
            TextView t2=v.findViewById(R.id.updatefrag2);
            TextView t3 = v.findViewById(R.id.updatefrag3);
            t2.setOnClickListener(this);
            if (language == false) {
                t1.setText("सूचनायें");
                t2.setText("इस दीवाली हमें मोमबत्ती बनाने के काम में कुछ महिलाओं को रोजगार देने में मदद करें । हमें कार्यशालाओं के लिए प्रशिक्षण और कच्चे माल को वित्त पोषित करने के लिए धन जुटाने में मदद करें। \n \n यहां क्लिक करें।");
                t3.setText("वित्तीय रूप से हमें समर्थन देने के लिए हमारे उत्पादों को खरीदने के लिए कृपया हमसे संपर्क करें।\n\nहम सक्रिय रूप से महान कार्यों के लिये स्वयंसेवकों की तलाश कर रहे हैं। विवरण के लिए हमारा साथ दें पर क्लिक करें।\n\nअपने शहर, कस्बे,गांव या इलाके में हमारे उत्पाद केंद्र को स्थापित करने के लिए कृपया हमसे संपर्क करें। हमारे उत्पादों में नोटबुक, मोमबत्तियां, एलईडी बल्ब, दीया आदि शामिल हैं।\n\n यदि आप दिल्ली के पास रहते हैं तो कृपया हमारे उत्पादों को खरीदें और हमारे संगठन के लिए धन जुटाने में हमारी सहायता करें।");
              }
        }
        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        return v;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.updatefrag2:
                diwaliFragment diwalii = new diwaliFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putBoolean("langkey",language);
                diwalii.setArguments(bundle);

                transaction.replace(R.id.content_frame, diwalii);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }

    }

}