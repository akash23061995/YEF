package yef.gwalior.aks.com.yef;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.List;

public class connectFragment extends android.support.v4.app.Fragment implements View.OnClickListener{
     public String YourPageURL;
     public Intent browserIntent;

    public int i=0;
    public View v;
    public boolean language;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            language=bundle.getBoolean("langkey");
        }

        v = inflater.inflate(R.layout.connect_fragment, container, false);
       TextView t1=v.findViewById(R.id.connecttext1);
        ImageView i1=v.findViewById(R.id.connect1);
        ImageView i2=v.findViewById(R.id.connect2);
        ImageView i3=v.findViewById(R.id.connect3);
        ImageView i4=v.findViewById(R.id.connect4);
        ImageView i5=v.findViewById(R.id.connect5);
        ImageView i6=v.findViewById(R.id.connect6);
        ImageView i7=v.findViewById(R.id.connect7);
        ImageView i8=v.findViewById(R.id.connect8);
        ImageView i9=v.findViewById(R.id.connect9);
        ImageView i10=v.findViewById(R.id.connect10);
        ImageView i11=v.findViewById(R.id.connect11);
        ImageView i12=v.findViewById(R.id.connect12);


        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
        i5.setOnClickListener(this);
        i6.setOnClickListener(this);
        i7.setOnClickListener(this);
        i8.setOnClickListener(this);
        i9.setOnClickListener(this);
        i10.setOnClickListener(this);
        i11.setOnClickListener(this);
        i12.setOnClickListener(this);

        if(language==false){
         t1.setText("इन प्लेटफार्मों के माध्यम से हमारे साथ जुड़ें और हमारे साथ अपने प्रश्न और अनुभव साझा करें\n");
        }

        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.connect1:
                Intent facebookAppIntent;
                try {
                    facebookAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1983682701901548"));
                    startActivity(facebookAppIntent);
                } catch (ActivityNotFoundException e) {
                    facebookAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com/yefindia.in-1883727135173361"));
                    startActivity(facebookAppIntent);
                }
                 break;

            case R.id.connect2:
                Intent emailSelectorIntent = new Intent(Intent.ACTION_SENDTO);
                emailSelectorIntent.setData(Uri.parse("mailto:"));

                final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"yefindia@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query @ YEF Team");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Write your query here....");
                emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                emailIntent.setSelector( emailSelectorIntent );

                startActivity(emailIntent);

                break;
            case R.id.connect3:
                Intent intent = null;
                try {
                    // get the Twitter app if possible
                    getActivity().getPackageManager().getPackageInfo("com.twitter.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/yefindia"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/yefindia"));
                }
                this.startActivity(intent);
                break;

            case R.id.connect4:
                String profile="107239469222100747447";
                try {

                    Intent intentgplus = new Intent(Intent.ACTION_VIEW);
                    intentgplus.setClassName("com.google.android.apps.plus",
                            "com.google.android.apps.plus.phone.UrlGatewayActivity");
                    intentgplus.putExtra("customAppUri",profile );
                    startActivity(intentgplus);
                } catch(ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/"+profile+"/posts")));
                }

                break;
            case R.id.connect5:
                Intent intentlinkedin;
           try {
               String linkedId = "b0432b159";

               getActivity().getPackageManager().getPackageInfo("com.linkedin.android", 0);
               intentlinkedin = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/youth-empowerment-foundation-b0432b159"));
               intentlinkedin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

           }
           catch (Exception e){
               intentlinkedin = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/youth-empowerment-foundation-b0432b159"));
               }

                this.startActivity(intentlinkedin);

                break;
            case R.id.connect6:

                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCLs5bATz7-gV6CagwgW7wVw"));
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/channel/UCLs5bATz7-gV6CagwgW7wVw"));
                try {
                    getContext().startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    getContext().startActivity(webIntent);
                }

            break;
            case R.id.connect7:
                Uri uri = Uri.parse("https://www.instagram.com/youth_empowermentfoundation/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/youth_empowermentfoundation/")));
                }

                break;
            case R.id.connect8:
                String num="+91 8459084690";
                Uri uri12 = Uri.parse("smsto:" +num);
                Intent i = new Intent(Intent.ACTION_SENDTO, uri12);
                i.setPackage("com.whatsapp");
                i.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                i.putExtra(Intent.EXTRA_TEXT, "I'm the body.");
                try {
                    startActivity(i);
                } catch (android.content.ActivityNotFoundException ex) {
                    final String appPackageName = "com.whatsapp"; // getPackageName() from Context or Activity object
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }



                break;
            case R.id.connect9:
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("https")
                        .authority("www.google.com").appendPath("maps").appendPath("dir").appendPath("").appendQueryParameter("api", "1")
                        .appendQueryParameter("destination", 28.530681 + "," + 77.152394);
                String url = builder.build().toString();
                Log.d("Directions", url);
                Intent i00 = new Intent(Intent.ACTION_VIEW);
                i00.setData(Uri.parse(url));
                startActivity(i00);


                break;
            case R.id.connect10:
                Intent intentcall = new Intent(Intent.ACTION_DIAL);
                intentcall.setData(Uri.parse("tel: +91 8459084690"));
                startActivity(intentcall);


                break;
            case R.id.connect11:
                String web1="websiteyef";
                Intent iwebsite=new Intent(getActivity(),WebViewSampleActivity.class);
                Toast.makeText(getActivity(),"Website Loading...",Toast.LENGTH_LONG).show();
                iwebsite.putExtra("openwebsite",web1);
                startActivity(iwebsite);

                break;
            case R.id.connect12:
                Intent emailSelectorIntent1 = new Intent(Intent.ACTION_SENDTO);
                emailSelectorIntent1.setData(Uri.parse("mailto:"));

                final Intent emailIntent1 = new Intent(Intent.ACTION_SEND);
                emailIntent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"akashsoni987654321@gmail.com"});
                emailIntent1.putExtra(Intent.EXTRA_SUBJECT, "Query @ App Developer");
                emailIntent1.putExtra(Intent.EXTRA_TEXT, "Write your query here....");
                emailIntent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                emailIntent1.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                emailIntent1.setSelector( emailSelectorIntent1 );

                startActivity(emailIntent1);


                break;


        }
    }

}
