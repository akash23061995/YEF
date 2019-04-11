package yef.gwalior.aks.com.yef;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class ShowProfile extends AppCompatActivity {
public boolean language;
public String uid;
public boolean appdeveloper=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);
      Intent i=getIntent();
        //  MainActivity.User user = (MainActivity.User) i.getSerializableExtra("uservalue");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            language= extras.getBoolean("langkey");
               uid=extras.getString("uid");
            appdeveloper=extras.getBoolean("appdeveloper");
        }

        if(appdeveloper==true){
            uid="dN6UruCtBuTO0IFJWPO1zuy36903";


        }
               DatabaseReference userRef = ref.child("users").child(uid);

        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MainActivity.User user = dataSnapshot.getValue(MainActivity.User.class);


                TextView name, aboutme, email, gender, dateofbirth, address, phone, edulevel, edufield, typeofyouth;
                name = findViewById(R.id.name);
                aboutme = findViewById(R.id.aboutmetext);
                email = findViewById(R.id.emailtext);
                gender = findViewById(R.id.gendertext);
                dateofbirth = findViewById(R.id.bdaytext);
                address = findViewById(R.id.addresstext);
                phone = findViewById(R.id.phonetext);
                edulevel = findViewById(R.id.educationleveltext);
                edufield = findViewById(R.id.educationfieldtext);
                typeofyouth = findViewById(R.id.typeofyouthtext);
                final ImageView profile = findViewById(R.id.profile_imageeview);
                final ImageView cover = findViewById(R.id.cover_imageeview);

                name.setText(user.getName());
                aboutme.setText(user.getAboutme());
                email.setText(user.getEmailAddress());
                gender.setText(user.getGender());
                dateofbirth.setText(user.getBday());
                address.setText("" + user.getPlace() + "," + user.getCity() + "," + user.getState());
                phone.setText(user.getPhoneno());
                edulevel.setText(user.getGraduationlevel());
                edufield.setText(user.getDegree());
                typeofyouth.setText(user.getType_of_youth());

           if(language==false) {
               TextView t1 = findViewById(R.id.showproft1);
               TextView t2 = findViewById(R.id.showproft2);
               TextView t3 = findViewById(R.id.showproft3);
               TextView t4 = findViewById(R.id.showproft4);
               TextView t5 = findViewById(R.id.showproft5);
               TextView t6 = findViewById(R.id.showproft6);
               TextView t7 = findViewById(R.id.showproft7);
               TextView t8 = findViewById(R.id.showproft8);
               TextView t9 = findViewById(R.id.showproft9);
               TextView t10 = findViewById(R.id.showproft10);
               t1.setText("व्यक्ति के बारे में");
               t2.setText("ईमेल");
               t3.setText("लिगं");
               t4.setText("जन्म तिथि");
               t5.setText("पता");
               t6.setText("फोन");
               t7.setText("शिक्षा स्तर");
               t8.setText("शिक्षा क्षेत्र");
               t9.setText("युवा प्रकार");
               t10.setText("हम पर विश्वास कीजिये, यह जानकारी हमें युवाओं को बेहतर तरीके से आकार देने में मदद करती है। \n © YEF 2018 गोपनीयता नीति");

           }
               }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        TextView name,aboutme,email,gender,dateofbirth,address,phone,edulevel,edufield,typeofyouth;
        name=findViewById(R.id.name);
        aboutme=findViewById(R.id.aboutmetext);
        email=findViewById(R.id.emailtext);
        gender=findViewById(R.id.gendertext);
        dateofbirth=findViewById(R.id.bdaytext);
        address=findViewById(R.id.addresstext);
        phone=findViewById(R.id.phonetext);
        edulevel=findViewById(R.id.educationleveltext);
        edufield=findViewById(R.id.educationfieldtext);
        typeofyouth=findViewById(R.id.typeofyouthtext);
        final ImageView profile=findViewById(R.id.profile_imageeview);
       final ImageView cover=findViewById(R.id.cover_imageeview);

        StorageReference mCoverRef =
                FirebaseStorage.getInstance().getReference().child("Cover_images").child(uid);

        StorageReference mProfileRef =
                FirebaseStorage.getInstance().getReference().child("Profile_images").child(uid);
       /* Glide.with(this )
                .load(coverurl)
                .centerCrop()
                .into(cover);
*/
       try {
           final long FIVE_MEGABYTE = 5 * 1024 * 1024;
           final ProgressDialog progress=new ProgressDialog(this);
           progress.setTitle("Loading Profile..");
           if(language==false)
               progress.setTitle("प्रोफाइल लोड हो रहा है...");
           progress.show();

           mCoverRef.getBytes(FIVE_MEGABYTE)
                   .addOnSuccessListener(new OnSuccessListener<byte[]>() {
                       @Override
                       public void onSuccess(byte[] bytes) {
                           Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                           DisplayMetrics dm = new DisplayMetrics();
                           getWindowManager().getDefaultDisplay().getMetrics(dm);
                          progress.dismiss();
                           cover.setImageBitmap(bm);
                       }
                   })
                   .addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception exception) {

                   Toast.makeText(ShowProfile.this,"Cover Image Loading Failed",Toast.LENGTH_SHORT).show();
               }
           });


           mProfileRef.getBytes(FIVE_MEGABYTE)
                   .addOnSuccessListener(new OnSuccessListener<byte[]>() {
                       @Override
                       public void onSuccess(byte[] bytes) {
                           Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                           DisplayMetrics dm = new DisplayMetrics();
                           getWindowManager().getDefaultDisplay().getMetrics(dm);

                           profile.setImageBitmap(bm);
                       }
                   }).addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception exception) {
                   Toast.makeText(ShowProfile.this,"Profile Image Loading Failed",Toast.LENGTH_SHORT).show();
               }
           });
       }
       catch (Exception e){if(language==false)
           Toast.makeText(this,"अपने डेटा कनेक्शन की जांच करें",Toast.LENGTH_LONG).show();
       else
           Toast.makeText(this,"Check your Data Connection",Toast.LENGTH_LONG).show();

       }
     deleteCache(this);
    }
    public void privacyLink(View view) {
        String privacy = "privacyyef";
        Intent intent = new Intent(ShowProfile.this, WebViewSampleActivity.class);
        intent.putExtra("privacyyef", privacy);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = currentUser.getUid();
        Intent i=new Intent(ShowProfile.this,MainActivity.class);
        i.putExtra("userid",uid);
        i.putExtra("langkey",language);
        deleteCache(this);


        startActivity(i);
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
