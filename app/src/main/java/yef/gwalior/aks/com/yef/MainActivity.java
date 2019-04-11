package yef.gwalior.aks.com.yef;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import android.app.AlertDialog;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.File;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
boolean language;
String name,email,photourl;
Uri photoUrl;
 ImageView profilepic;
String uid;
    private FirebaseAuth mAuth;
    FirebaseUser mfirebaseUser;
    DatabaseReference myDatabase;
    public String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            language= extras.getBoolean("langkey");
           name= extras.getString("name");
            email=extras.getString("email");
        uid=extras.getString("userid");


        }

// fb app id 2119952854993197

        com.github.clans.fab.FloatingActionMenu fabMenu = findViewById(R.id.floatingMenu);
        com.github.clans.fab.FloatingActionButton fab1=findViewById(R.id.fabCall);
        com.github.clans.fab.FloatingActionButton fab2=findViewById(R.id.fabGmail);
        com.github.clans.fab.FloatingActionButton fab3=findViewById(R.id.fabGMaps);
        com.github.clans.fab.FloatingActionButton fab4=findViewById(R.id.fabWhatsAp);
        com.github.clans.fab.FloatingActionButton fab5=findViewById(R.id.fabWebsite);

        if(language==false){
            fab5.setLabelText("हमारी वेबसाइट पर पधारें");
            fab1.setLabelText("हमें फोन करें");
            fab2.setLabelText("हमें ईमेल करें");
            fab3.setLabelText("हमारा पता \n७४,मसूदपुर डेयरी,वसन्त कुन्ज,नई दिल्\u200Dली - ११००७०");
            fab4.setLabelText("हम से बात करें");
           fabMenu.setMenuButtonLabelText("निरस्त करें");
            TextView t11=findViewById(R.id.nameapphome1);
            TextView t12=findViewById(R.id.applogotext1);
            TextView t13=findViewById(R.id.applogodetail1);
            TextView t21=findViewById(R.id.nameapphome2);
            TextView t22=findViewById(R.id.applogotext2);
            TextView t23=findViewById(R.id.applogodetail2);
            TextView t31=findViewById(R.id.nameapphome3);
            TextView t32=findViewById(R.id.applogotext3);
            TextView t33=findViewById(R.id.applogodetail3);
            TextView t41=findViewById(R.id.nameapphome4);
            TextView t42=findViewById(R.id.applogotext4);
            TextView t43=findViewById(R.id.applogodetail4);
            TextView t51=findViewById(R.id.nameapphome5);
            TextView t52=findViewById(R.id.applogotext5);
            TextView t53=findViewById(R.id.applogodetail5);
            TextView t61=findViewById(R.id.nameapphome6);
            TextView t62=findViewById(R.id.applogotext6);
            TextView t63=findViewById(R.id.applogodetail6);
            TextView t71=findViewById(R.id.nameapphome7);
            TextView t72=findViewById(R.id.applogotext7);
            TextView t73=findViewById(R.id.applogodetail7);

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
        ViewFlipper flipper=findViewById(R.id.flipperid3);
        flipper.startFlipping();
        flipper.setInAnimation(this, R.anim.fade_in);
        flipper.setOutAnimation(this, R.anim.fade_out);

        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String web1="websiteyef";
                Intent i=new Intent(MainActivity.this,WebViewSampleActivity.class);
                i.putExtra("langkey",language);
                i.putExtra("openwebsite",web1);
                startActivity(i);

            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: +91 8459084690"));
                startActivity(intent);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("https")
                        .authority("www.google.com").appendPath("maps").appendPath("dir").appendPath("").appendQueryParameter("api", "1")
                        .appendQueryParameter("destination", 28.530681 + "," + 77.152394);
                String url = builder.build().toString();
                Log.d("Directions", url);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            });
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num="+91 8459084690";
                Uri uri = Uri.parse("smsto:" +num);
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                i.setPackage("com.whatsapp");
                i.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                i.putExtra(Intent.EXTRA_TEXT, "I'm the body.");
                  try {
                    startActivity(i);
                } catch (android.content.ActivityNotFoundException ex) {
                      final String appPackageName = "com.whatsapp"; // getPackageName() from Context or Activity object
                     startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                      }
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        mfirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseUserMetadata metadata = mfirebaseUser.getMetadata();
        if (metadata.getCreationTimestamp() == metadata.getLastSignInTimestamp()) {
            // The user is new, show them a fancy intro screen!


            writeNewUser(uid,name,"",email,photourl, "","","","","","","","","",0);
            writeNewFeedback(uid,"","",0);
            Intent i2=new Intent(this,NewUserWelcomeSplash.class);
            i2.putExtra("userid",uid);
            i2.putExtra("name",name);
            i2.putExtra("email",email);
            i2.putExtra("langkey",language);
            startActivity(i2);
        } else {

        }
        StorageReference mProfileRef =
                FirebaseStorage.getInstance().getReference().child("Profile_images").child(uid);
       deleteCache(this);

     final  ImageView accpic=findViewById(R.id.accountpic);
        final long THREE_MEGABYTE = 3*1024 * 1024;
        try {
            mProfileRef.getBytes(THREE_MEGABYTE)
                    .addOnSuccessListener(new OnSuccessListener<byte[]>() {
                        @Override
                        public void onSuccess(byte[] bytes) {
                            Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                            DisplayMetrics dm = new DisplayMetrics();
                            getWindowManager().getDefaultDisplay().getMetrics(dm);

                            accpic.setImageBitmap(bm);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                }
            });
        }
        catch (Exception e){
            Toast.makeText(this,"Memory Error",Toast.LENGTH_SHORT).show();
        }
DatabaseReference ref=FirebaseDatabase.getInstance().getReference();
DatabaseReference userRef=ref.child("users").child(uid);

        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MainActivity.User user = dataSnapshot.getValue(MainActivity.User.class);
              TextView name=findViewById(R.id.userview);
                name.setText(user.getName());
                username=user.getName();
                //do what you want with the email
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    //oncreate khatam
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
    private void writeNewFeedback(String userId,String buttonvalue, String feedbackvalue,int rating ) {
        Feedback feedback = new Feedback(buttonvalue,feedbackvalue ,rating);

        myDatabase = FirebaseDatabase.getInstance().getReference();
        myDatabase.child("feedback").child(userId).setValue(feedback);

    }
    public static class Feedback {
        public String buttonvalue, feedbackvalue;
        public int rating;

        public Feedback(String buttonvalue, String feedbackvalue,int rating) {
            this.buttonvalue = buttonvalue;
            this.feedbackvalue = feedbackvalue;
            this.rating = rating;
        }
        //phone no bday place of living about you  type of youth education and its field
        public Feedback(){}

        public String getButtonvalue() {return buttonvalue;}
        public void setButtonvalue(String buttonvalue) {this.buttonvalue = buttonvalue;}

        public String getFeedbackvalue() {return feedbackvalue;}
        public void setFeedbackvalue(String feedbackvalue) {this.feedbackvalue= feedbackvalue;}

        public int getRating() {return rating;}
        public void setRating(int rating) {this.rating = rating;}


    }


    private void writeNewUser(String userId, String name,String gender ,String email,String photouri,String phoneno,String bday,String place,String state,String city,String aboutme,String graduationlevel,String degree,String type_of_youth,int age) {
        User user = new User(name,gender ,email,photouri,phoneno,bday,place,state,city,aboutme,graduationlevel,degree,type_of_youth,age);

        myDatabase = FirebaseDatabase.getInstance().getReference();
        myDatabase.child("users").child(userId).setValue(user);

    }
    public static class User {
       public String name, gender, emailAddress,photouri,phoneno,bday,place,state,city,aboutme,graduationlevel,degree,type_of_youth;
        public int age;

        public User(String name, String gender, String emailAddress,String photouri,String phoneno,String bday,String place,String state,String city,String aboutme,String graduationlevel,String degree,String type_of_youth,int age) {
            this.name = name;
            this.gender = gender;
            this.emailAddress = emailAddress;
            this.photouri= photouri;
            this.phoneno= phoneno;
            this.bday= bday;
            this.place=place;
            this.state=state;
            this.city=city;
            this.aboutme=aboutme;
            this.graduationlevel=graduationlevel;
            this.degree=degree;
            this.type_of_youth=type_of_youth;
            this.age = age;
        }
//phone no bday place of living about you  type of youth education and its field
   public User(){}

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}

        public String getGender() {return gender;}
        public void setGender(String gender) {this.gender= gender;}

        public String getEmailAddress() {return emailAddress;}
        public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}

        public String getPhotouri(){return photouri;}
        public void setPhotouri(String photouri){this.photouri= photouri;}

        public String getPhoneno(){return phoneno;}
        public void setPhoneno(String phoneno){this.phoneno= phoneno;}

        public String getBday(){return bday;}
        public void setBday(String bday){this.bday= bday;}

        public String getPlace(){return place;}
        public void setPlace(String place){this.place= place;}

        public String getState(){return state;}
        public void setState(String state){this.state= state;}

        public String getCity(){return city;}
        public void setCity(String city){this.city= city;}

        public String getAboutme(){return aboutme;}
        public void setAboutme(String aboutme){this.aboutme= aboutme;}

        public String getGraduationlevel(){return graduationlevel;}
        public void setGraduationlevel(String graduationlevel){this.graduationlevel= graduationlevel;}

        public String getDegree(){return degree;}
        public void setDegree(String degree){this.degree= degree;}

        public String getType_of_youth(){return type_of_youth;}
        public void setType_of_youth(String type_of_youth){this.type_of_youth=type_of_youth;}

        public int getAge() {return age;}
        public void setAge(int age) {this.age= age;}


    }



@Override public void onResume(){
        super.onResume();
        if(username!=null&&language==true)
    Toast.makeText(this,"Welcome back "+username+"!",Toast.LENGTH_LONG).show();
    if(username!=null&&language==false)
        Toast.makeText(this,"पुनः स्वागत है ! "+username+"!",Toast.LENGTH_LONG).show();

}


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                // super.onBackPressed();
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

        } else {
            getFragmentManager().popBackStack();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
      if(language==false) {
          TextView nameapp = findViewById(R.id.nameapp);
          MenuItem action1 = menu.findItem(R.id.action_profile);
          action1.setTitle("प्रोफाइल");
          MenuItem action2 = menu.findItem(R.id.action_updateprofile);
          action2.setTitle("प्रोफाइल बदलें");
          MenuItem action3 = menu.findItem(R.id.action_changelanguage);
          action3.setTitle("भाषा बदलें");
          MenuItem action4 = menu.findItem(R.id.action_privacypolicy);
          action4.setTitle("गोपनीयता नीति");
          MenuItem action5 = menu.findItem(R.id.action_About);
          action5.setTitle("एप निर्माता");
          MenuItem action6 = menu.findItem(R.id.action_rateus);
          action6.setTitle("मूल्यांकन करें");
          MenuItem action8 = menu.findItem(R.id.action_logout);
          action8.setTitle("लोग आउट");
          nameapp.setText("YEF भारत");

      }
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu2 = navigationView.getMenu();
if(language==false) {
    MenuItem nav_home = menu2.findItem(R.id.home);
    nav_home.setTitle("होम");
    MenuItem nav_aboutus = menu2.findItem(R.id.aboutus);
    nav_aboutus.setTitle("बारे में");
    MenuItem nav_events = menu2.findItem(R.id.events);
    nav_events.setTitle("आयोजन");
    MenuItem nav_updates = menu2.findItem(R.id.updates);
    nav_updates.setTitle("सूचनाये");
    MenuItem nav_gallery = menu2.findItem(R.id.gallery);
    nav_gallery.setTitle("तस्वीरें");
    MenuItem nav_projects = menu2.findItem(R.id.projects);
    nav_projects.setTitle("परियोजनायें");
    MenuItem nav_products = menu2.findItem(R.id.products);
    nav_products.setTitle("हमारे उत्पाद");
    MenuItem nav_joinus = menu2.findItem(R.id.joinus);
    nav_joinus.setTitle("हमारा साथ दें");
    MenuItem nav_donate = menu2.findItem(R.id.donate);
    nav_donate.setTitle("दान करें");
    MenuItem nav_connect = menu2.findItem(R.id.connect);
    nav_connect.setTitle("हमसे जुडें");
    MenuItem nav_share = menu2.findItem(R.id.nav_share);
    nav_share.setTitle("शेयर करें");
    MenuItem nav_feed = menu2.findItem(R.id.feedback);
    nav_feed.setTitle("प्रतिक्रिया दें");
    MenuItem getinvolve=menu2.findItem(R.id.getinvolvetext);
    getinvolve.setTitle("सहयोग करें");
    MenuItem communicate=menu2.findItem(R.id.communicatetext);
    communicate.setTitle("संवाद करें");
    MenuItem animatedgallery=menu2.findItem(R.id.animatedgallery);
    animatedgallery.setTitle("एनिमेटेड गैलरी");
    MenuItem diwali=menu2.findItem(R.id.diwali);
    diwali.setTitle("दीवाली विशेष");

}

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_updateprofile) {
            Intent i=new Intent(this,UserProfile.class);
            i.putExtra("langkey",language);
            i.putExtra("userid",uid);
            i.putExtra("name",name);
            i.putExtra("email",email);
            i.putExtra("photourl",photoUrl);
            startActivity(i);
            return true;
        }
        if(id== R.id.action_profile){
            Intent i=new Intent(this,ShowProfile.class);
            i.putExtra("langkey",language);
            i.putExtra("uid",uid);
            startActivity(i);
            return true;
        }
        if(id== R.id.action_changelanguage){
            Intent i=new Intent(this,LanguageSelect.class);
            startActivity(i);
            return true;
        }
        if(id== R.id.action_privacypolicy){
            String privacy = "privacyyef";
            Intent intent = new Intent(this, WebViewSampleActivity.class);
            Toast.makeText(this, "Privacy Policy Loading....", Toast.LENGTH_LONG).show();
            intent.putExtra("privacyyef", privacy);
            intent.putExtra("langkey",language);
            startActivity(intent);

            return true;
        }

        if(id== R.id.action_About){
            Intent i=new Intent(this,AppDeveloper.class);
            i.putExtra("langkey",language);
            startActivity(i);
            return true;
        }
        if(id== R.id.action_rateus){
            final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
           }

        if (id == R.id.action_logout) {
            AuthUI.getInstance().signOut(this);
            Intent i=new Intent(this,LanguageSelect.class);
                   startActivity(i);


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int id = item.getItemId();
        Fragment newFragment;

        if (id == R.id.home) {
            homeFragment homeFragmentt = new homeFragment();
            Bundle bundle = new Bundle();
            int value=1;
            bundle.putInt("val", value);
            bundle.putBoolean("langkey",language);
            homeFragmentt.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,homeFragmentt)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.aboutus) {
            homeFragment homeFragmentt = new homeFragment();
            Bundle bundle = new Bundle();
            int value=2;
            bundle.putInt("val", value);
            bundle.putBoolean("langkey",language);
            homeFragmentt.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,homeFragmentt)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.events) {
            homeFragment homeFragmentt = new homeFragment();
            Bundle bundle = new Bundle();
            int value=3;
            bundle.putInt("val", value);
            bundle.putBoolean("langkey",language);
            homeFragmentt.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,homeFragmentt)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.updates) {
            homeFragment homeFragmentt = new homeFragment();
            Bundle bundle = new Bundle();
            int value=5;
            bundle.putInt("val", value);
            bundle.putBoolean("langkey",language);
            homeFragmentt.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,homeFragmentt)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.gallery) {
           Intent i=new Intent(MainActivity.this,GallerysActivity.class);
           i.putExtra("langkey",language);
           startActivity(i);

        }else if (id == R.id.animatedgallery) {
            AnimatedFragment anime = new AnimatedFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("langkey", language);
            anime.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, anime)
                    .addToBackStack(null)
                    .commit();

        }
        else if (id == R.id.projects) {
            webFragment webfrag = new webFragment();
            Bundle bundle = new Bundle();
            String project="project";
            bundle.putString("project", project);
            bundle.putBoolean("langkey",language);
            webfrag.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,webfrag)
                    .addToBackStack(null)
                    .commit();


        }else if (id == R.id.products) {
            homeFragment homeFragmentt = new homeFragment();
            Bundle bundle = new Bundle();
            int value=4;
            bundle.putInt("val", value);
            bundle.putBoolean("langkey",language);
            homeFragmentt.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,homeFragmentt)
                    .addToBackStack(null)
                    .commit();

        }else if (id == R.id.joinus) {
            webFragment webfrag = new webFragment();
            Bundle bundle = new Bundle();
          String joinus="JoinUs";
            bundle.putString("joinus", joinus);
            bundle.putBoolean("langkey",language);
            webfrag.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,webfrag)
                    .addToBackStack(null)
                    .commit();


        }else if (id == R.id.donate) {
            donateFragment donate= new donateFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("langkey", language);
            donate.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,donate)
                    .addToBackStack(null)
                    .commit();

        }else if (id == R.id.diwali) {
            diwaliFragment diwali= new diwaliFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("langkey", language);
            diwali.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,diwali)
                    .addToBackStack(null)
                    .commit();


        }else if (id == R.id.connect) {
              connectFragment   connect= new connectFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("langkey", language);
            connect.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,connect)
                    .addToBackStack(null)
                    .commit();


        }else if (id == R.id.nav_share) {
            Intent i=new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_SUBJECT,"YEF");
            i.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=yef.gwalior.aks.com.yef");
            startActivity(Intent.createChooser(i,"Share via"));

        }else if (id == R.id.feedback) {
            feedbackFragment feedbackFragmentt = new feedbackFragment();
            Bundle bundle = new Bundle();
            bundle.putString("uid", uid);
            bundle.putBoolean("langkey",language);
            feedbackFragmentt.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,feedbackFragmentt)
                    .addToBackStack(null)
                    .commit();

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
   public void openyefwebsite(View view)
   {
       String web1="websiteyef";
       Intent i=new Intent(MainActivity.this,WebViewSampleActivity.class);
       i.putExtra("openwebsite",web1);
       i.putExtra("langkey",language);
       startActivity(i);
   }
   public  void profileopenfrompic(View view)
   {
       Intent i=new Intent(this,ShowProfile.class);
       i.putExtra("langkey",language);
       i.putExtra("uid",uid);
       startActivity(i);
   }

}
