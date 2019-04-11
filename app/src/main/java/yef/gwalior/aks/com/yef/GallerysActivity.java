package yef.gwalior.aks.com.yef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class GallerysActivity extends AppCompatActivity {
    ImageView selectedImage;
public boolean language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallerys);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            language = extras.getBoolean("langkey");

        }

            Gallery gallery = (Gallery) findViewById(R.id.gallery);
        selectedImage=(ImageView)findViewById(R.id.imageView);
        gallery.setSpacing(1);
        final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(this);
        gallery.setAdapter(galleryImageAdapter);


        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void  onItemSelected  (AdapterView<?>  parent, View  v, int position, long id) {
                Animation grow = AnimationUtils.loadAnimation(GallerysActivity.this, R.anim.grow);
                TextView  tv=findViewById(R.id.gallerytext);

                switch (position)
              {
                  case 0:
                      tv.setText("Some Action ;)");
                      break;
                  case 1:
                      tv.setText("Enthusiastic Faces");
                      break;
                  case 2:
                      tv.setText("Volunteering Work");
                      break;
                  case 3:
                      tv.setText("Games");
                      break;
                  case 4:
                      tv.setText("Slum Food Distribution");
                      break;
                  case 5:
                      tv.setText("Slum Food Distribution");
                      break;
                  case 6:
                      tv.setText("Slum Food Distribution");
                      break;
                  case 7:
                      tv.setText("Dance Performance");
                      break;
                  case 8:
                      tv.setText("Dance Performance");
                      break;
                  case 9:
                      tv.setText("Christmas celebration :)");
                      break;
                  case 10:
                      tv.setText("Education Centre");
                      break;
                  case 11:
                      tv.setText("Child Query ;)");
                      break;
                  case 12:
                      tv.setText("Delhi Dance Program");
                      break;
                  case 13:
                      tv.setText("Candles made by YEF Students");
                      break;
                  case 14:
                      tv.setText("Candles made by YEF Students");
                      break;
                  case 15:
                      tv.setText("Diya Preparation by Children Empower the Young");
                      break;
                  case 16:
                      tv.setText("Diya made by YEF Students");
                      break;
                  case 17:
                      tv.setText("Diya Preparation Self Employment");
                      break;
                  case 18:
                      tv.setText("Republic Day Celebration");
                      break;
                  case 19:
                      tv.setText("Donation to Slum Kids");
                      break;
                  case 20:
                      tv.setText("Helping the Needy");
                      break;
                  case 21:
                      tv.setText("Educating Students");
                      break;
                  case 22:
                      tv.setText("Educating Children");
                      break;
                  case 23:
                      tv.setText("LED Making by YEf Students Empower and Employ Self");
                      break;


              }

              if(language==false){
                  switch (position)
                  {
                      case 0:
                          tv.setText("थोडा जोश ;)");
                          break;
                      case 1:
                          tv.setText("उत्साही चेहरे");
                          break;
                      case 2:
                          tv.setText("स्वयंसेवा कार्य");
                          break;
                      case 3:
                          tv.setText("खेल");
                          break;
                      case 4:
                          tv.setText("ज़रूरतमंदों में खाद्य वितरण");
                          break;
                      case 5:
                          tv.setText("ज़रूरतमंदों में खाद्य वितरण");
                          break;
                      case 6:
                          tv.setText("ज़रूरतमंदों में खाद्य वितरण");
                          break;
                      case 7:
                          tv.setText("नृत्य प्रदर्शन");
                          break;
                      case 8:
                          tv.setText("नृत्य प्रदर्शन");
                          break;
                      case 9:
                          tv.setText("क्रिसमस समारोह :)");
                          break;
                      case 10:
                          tv.setText("शिक्षा केंद्र");
                          break;
                      case 11:
                          tv.setText("बाल प्रश्न ;)");
                          break;
                      case 12:
                          tv.setText("दिल्ली नृत्य कार्यक्रम");
                          break;
                      case 13:
                          tv.setText("YEF छात्रों द्वारा किए गए मोमबत्तियां");
                          break;
                      case 14:
                          tv.setText("YEF छात्रों द्वारा किए गए मोमबत्तियां");
                          break;
                      case 15:
                          tv.setText("बच्चों द्वारा दीया तैयारी युवाओं को सशक्त बनाना");
                          break;
                      case 16:
                          tv.setText("बच्चों द्वारा दीया तैयारी");
                          break;
                      case 17:
                          tv.setText("दीया तैयारी स्व रोजगार");
                          break;
                      case 18:
                          tv.setText("गणतंत्र दिवस उत्सव");
                          break;
                      case 19:
                          tv.setText("स्लम बच्चों के लिए दान");
                          break;
                      case 20:
                          tv.setText("ज़रूरतमंदों की मदद");
                          break;
                      case 21:
                          tv.setText("छात्रों को शिक्षित करना");
                          break;
                      case 22:
                          tv.setText("छात्रों को शिक्षित करना");
                          break;
                      case 23:
                          tv.setText("YEF छात्रों द्वारा एलईडी बल्ब बनाना स्वरोजगार और स्वसशक्तिकरण");
                          break;
                          }
                  }
                View sideView = parent.findViewById(position - 1);
                if (sideView != null)
                    ((ImageView)sideView).setLayoutParams(new Gallery.LayoutParams(600, 400));

                sideView = parent.findViewById(position + 1);
                if (sideView != null)
                    ((ImageView)sideView).setLayoutParams(new Gallery.LayoutParams(600, 400));

                v.startAnimation(grow);
                v.setLayoutParams(new Gallery.LayoutParams(800, 750));
            }

            public void  onNothingSelected  (AdapterView<?>  parent) {
                System.out.println("NOTHING SELECTED");

            }
        });


                /*.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // show the selected Image
                selectedImage.setImageResource(galleryImageAdapter.mImageIds[position]);
            }
        });*/
    }

}

