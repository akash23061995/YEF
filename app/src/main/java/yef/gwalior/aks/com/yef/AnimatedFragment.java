package yef.gwalior.aks.com.yef;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.io.File;

public class AnimatedFragment extends android.support.v4.app.Fragment {

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

        v = inflater.inflate(R.layout.animatedfragment, container, false);
        ViewFlipper viewFlipper = (ViewFlipper)v.findViewById(R.id.flipperid2);
        viewFlipper.startFlipping();


        if(language==false){
            TextView t1=v.findViewById(R.id.animatedt1);
            TextView t2=v.findViewById(R.id.animatedt2);
            TextView t3=v.findViewById(R.id.animatedt3);
            TextView t4=v.findViewById(R.id.animatedt4);
            TextView t5=v.findViewById(R.id.animatedt5);
            TextView t6=v.findViewById(R.id.animatedt6);
            TextView t7=v.findViewById(R.id.animatedt7);
            TextView t8=v.findViewById(R.id.animatedt8);
            TextView t9=v.findViewById(R.id.animatedt9);
            TextView t10=v.findViewById(R.id.animatedt10);
            TextView t11=v.findViewById(R.id.animatedt11);
            TextView t12=v.findViewById(R.id.animatedt12);
            TextView t13=v.findViewById(R.id.animatedt13);
            TextView t14=v.findViewById(R.id.animatedt14);
            TextView t15=v.findViewById(R.id.animatedt15);
            TextView t16=v.findViewById(R.id.animatedt16);
            TextView t17=v.findViewById(R.id.animatedt17);
            TextView t18=v.findViewById(R.id.animatedt18);
            TextView t19=v.findViewById(R.id.animatedt19);
            TextView t20=v.findViewById(R.id.animatedt20);
            TextView t21=v.findViewById(R.id.animatedt21);
            TextView t22=v.findViewById(R.id.animatedt22);
            TextView t23=v.findViewById(R.id.animatedt23);
            TextView t24=v.findViewById(R.id.animatedt24);
            TextView t25=v.findViewById(R.id.animatedt25);
            TextView t26=v.findViewById(R.id.animatedt26);
            TextView t27=v.findViewById(R.id.animatedt27);
            TextView t28=v.findViewById(R.id.animatedt28);
            TextView t29=v.findViewById(R.id.animatedt29);
                t1.setText("दिल्ली नृत्य कार्यक्रम");
                t2.setText("उत्साही चेहरे");
                t3.setText("स्वयंसेवा कार्य");
                t4.setText("मैथ रेस २०१७");
                t5.setText("ज़रूरतमंदों में खाद्य वितरण");
                t6.setText("ज़रूरतमंदों में खाद्य वितरण");
                t7.setText("ज़रूरतमंदों में खाद्य वितरण");
                t8.setText("गणतंत्र दिवस उत्सव");
                t9.setText("दिल्ली नृत्य कार्यक्रम");
                t10.setText("क्रिसमस समारोह :)");
                t11.setText("छात्रों को शिक्षित करना");
                t12.setText("छात्रों को शिक्षित करना");
                t13.setText("थोडा जोश ;)");
                t14.setText("गणतंत्र दिवस उत्सव");
                t15.setText("गणतंत्र दिवस उत्सव");
                t16.setText("YEF छात्रों द्वारा किए गए मोमबत्तियां");
                t17.setText("YEF छात्रों द्वारा किए गए मोमबत्तियां");
                t18.setText("YEF छात्रों द्वारा किए गए मोमबत्तियां");
                t19.setText("YEF छात्रों द्वारा किए गए मोमबत्तियां");
                t20.setText("बच्चों द्वारा दीया तैयारी युवाओं को सशक्त बनाना");
                t21.setText("दीया तैयारी स्व रोजगार");
                t22.setText("YEF छात्रों द्वारा एलईडी बल्ब बनाना स्वरोजगार और स्वसशक्तिकरण");
                t23.setText("सेल्फी समय");
                t24.setText("गणतंत्र दिवस उत्सव");
                t25.setText("ज़रूरतमंदों में खाद्य वितरण");
                t26.setText("छात्रों को शिक्षित करना");
                t27.setText("ज़रूरतमंदों में खाद्य वितरण");
                t28.setText("संस्थान ध्येय");
                t29.setText("एप निर्माता");



        }

        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */
       deleteCache(getContext());
        return v;
    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }
    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}


