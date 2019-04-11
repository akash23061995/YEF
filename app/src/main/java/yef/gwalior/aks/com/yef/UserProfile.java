package yef.gwalior.aks.com.yef;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import java.io.Serializable;
import org.w3c.dom.Text;


public class UserProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public String uid, name=null, email=null, photoUrl=null;
    public String uname=null, ugender=null, uemail=null, uphotourl=null, uphoneno=null, ubday=null, uplace=null, ustate=null, ucity=null, uaboutme=null, ugraduationlevel=null, ugraduationfield=null, utypeofyouth=null;
    public int uage=0;
    DatabaseReference myDatabase;
    public boolean language;
    EditText selectDate;
    private Button btnCover, btnProfile;
    private ImageView profilepic, coverpic;
    FirebaseStorage storage;
    StorageReference storageReference;
    private Uri filePath1,filePath2;
    public int n = 1;
    private final int PICK_IMAGE_REQUEST = 71;
    private int mYear, mMonth, mDay, currentYear;
    ArrayAdapter<String> dataAdapter, dataAdapter2, dataAdapter3, dataAdapter4, dataAdapter5;
    List<String> categories3;
    private FirebaseAuth mAuth;
    FirebaseUser mfirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            language = extras.getBoolean("langkey");
            uid = extras.getString("userid");
            name = extras.getString("name");
            email = extras.getString("email");
            photoUrl = extras.getString("photourl");
        }
        if (language == false) {
            btnCover = findViewById(R.id.coverpicupdate);
            btnProfile = findViewById(R.id.profilepicupdate);
            profilepic = findViewById(R.id.profile_image);
            coverpic = findViewById(R.id.cover_image);
            TextView name1 = findViewById(R.id.name);
            EditText entername = findViewById(R.id.entername);
            EditText aboutme = findViewById(R.id.aboutme);
            EditText email1 = findViewById(R.id.email);
            RadioGroup gender = findViewById(R.id.gender);
            EditText address = findViewById(R.id.Address);
            EditText phone = findViewById(R.id.phone);
            int gen = gender.getCheckedRadioButtonId();
            RadioButton genradio = findViewById(gen);
            RadioButton m=findViewById(R.id.male);
            RadioButton f=findViewById(R.id.female);
            RadioButton o=findViewById(R.id.other);
            EditText date=findViewById(R.id.date);
            TextView t1=findViewById(R.id.edulevel);
            TextView t2=findViewById(R.id.edufield);
            TextView t3=findViewById(R.id.youthtype);
            Button b=findViewById(R.id.update);
            TextView belve=findViewById(R.id.beileveus);

            btnCover.setText("अपलोड");
            btnProfile.setText("अपलोड");
            entername.setHint("नाम");
            aboutme.setHint("स्वयं का विवरण दें");
            email1.setHint("ईमेल");
            m.setText("पुरुष");
            f.setText("महिला");
            o.setText("अन्य");
            date.setHint("जन्म तिथि");
            address.setHint("पता");
            phone.setHint("फोन");
            t1.setText("शिक्षा स्तर");
            t2.setText("शिक्षा क्षेत्र");
            t3.setText("युवा प्रकार");
            b.setText("सेव");
            b.setTextSize(25);
            belve.setText("हम पर विश्वास कीजिये, यह जानकारी हमें युवाओं को बेहतर तरीके से आकार देने में मदद करती है। \n © YEF 2018 गोपनीयता नीति");


        }
        if(language==false)
            Toast.makeText(this, "कृपया सुनिश्चित करें कि सभी फ़ील्ड चुने गए हैं!", Toast.LENGTH_LONG).show();
           else
            Toast.makeText(this, "Please ensure all fields are selected!", Toast.LENGTH_LONG).show();

        btnCover = findViewById(R.id.coverpicupdate);
        btnProfile = findViewById(R.id.profilepicupdate);
        profilepic = findViewById(R.id.profile_image);
        coverpic = findViewById(R.id.cover_image);
        TextView name1 = findViewById(R.id.name);
        EditText entername = findViewById(R.id.entername);
        EditText aboutme = findViewById(R.id.aboutme);
        EditText email1 = findViewById(R.id.email);
        RadioGroup gender = findViewById(R.id.gender);
        EditText address = findViewById(R.id.Address);
        EditText phone = findViewById(R.id.phone);
        int gen = gender.getCheckedRadioButtonId();
        RadioButton genradio = findViewById(gen);

        if (name != null) {
            name1.setText("" + name);
            uname = name;
        }

        if (email != null) {
            email1.setText("" + email);
            uemail = email;
        }
        if (photoUrl != null) {
            Picasso.with(this).load(photoUrl).into(profilepic);
            uphotourl = photoUrl;
        }


        btnCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = 1;
                chooseImage1();
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = 2;
                chooseImage1();
            }
        });
        selectDate = (EditText) findViewById(R.id.date);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);
        Spinner spinner4 = findViewById(R.id.spinner4);
        Spinner spinner5 = findViewById(R.id.spinner5);
        List<String> categories = new ArrayList<String>();
        categories.add("Select");
        categories.add("Below Metric");
        categories.add("Metric");
        categories.add("High School");
        categories.add("Diploma");
        categories.add("Graduate");
        categories.add("Post Graduate");
        categories.add("Doctorate");
        categories.add("Other");
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);
        //second
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Select State");
        categories2.add("Andaman and Nicobar Islands");
        categories2.add("Andhra Pradesh");
        categories2.add("Arunachal Pradesh");
        categories2.add("Assam");
        categories2.add("Bihar");
        categories2.add("Chandigarh");
        categories2.add("Chhattisgarh");
        categories2.add("Dadra and Nagar Haveli");
        categories2.add("Daman and Diu");
        categories2.add("Delhi");
        categories2.add("Goa");
        categories2.add("Gujarat");
        categories2.add("Haryana");
        categories2.add("Himachal Pradesh");
        categories2.add("Jammu and Kashmir");
        categories2.add("Jharkhand");
        categories2.add("Karnataka");
        categories2.add("Kerala");
        categories2.add("Lakshadweep");
        categories2.add("Madhya Pradesh");
        categories2.add("Maharashtra");
        categories2.add("Manipur");
        categories2.add("Meghalaya");
        categories2.add("Mizoram");
        categories2.add("Nagaland");
        categories2.add("Orissa");
        categories2.add("Puducherry");
        categories2.add("Punjab");
        categories2.add("Rajasthan");
        categories2.add("Sikkim");
        categories2.add("Tamil Nadu");
        categories2.add("Telangana");
        categories2.add("Tripura");
        categories2.add("Uttarakhand");
        categories2.add("Uttar Pradesh");
        categories2.add("West Bengal");
        dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
        spinner2.setOnItemSelectedListener(this);

//fourth
        List<String> categories4 = new ArrayList<String>();
        categories4.add("Select");
        categories4.add("Accountancy");
        categories4.add("Aeronautics");
        categories4.add("Agriculture");
        categories4.add("Architecture");
        categories4.add("Arts");
        categories4.add("Astrology");
        categories4.add("Astronomy");
        categories4.add("Biology");
        categories4.add("Biotechnology");
        categories4.add("Chemistry");
        categories4.add("Chemical Engineering");
        categories4.add("Computer Science");
        categories4.add("Commerce");
        categories4.add("Civil Engineering");
        categories4.add("Economics");
        categories4.add("Electrical Engineering");
        categories4.add("Electronics Engineering");
        categories4.add("Engineering");
        categories4.add("Finance");
        categories4.add("Food Technology");
        categories4.add("Geology");
        categories4.add("Geography");
        categories4.add("History");
        categories4.add("Home Science");
        categories4.add("Hotel Management");
        categories4.add("Humanities");
        categories4.add("Information Technology");
        categories4.add("Law");
        categories4.add("Management");
        categories4.add("Marine Engineering");
        categories4.add("Marketing");
        categories4.add("MBBS");
        categories4.add("Mechanical Engineering");
        categories4.add("Material Science");
        categories4.add("Political Science");
        categories4.add("Physics");
        categories4.add("Statistics");
        categories4.add("Sales");
        categories4.add("Technology");
        categories4.add("Other");

        dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories4) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(dataAdapter4);
        spinner4.setOnItemSelectedListener(this);
//fifth
        List<String> categories5 = new ArrayList<String>();
        categories5.add("Select");
        categories5.add("Creative");
        categories5.add("Passionate");
        categories5.add("Rough");
        categories5.add("Smart");
        categories5.add("Cheerful");
        categories5.add("Happy");
        categories5.add("Serious");
        categories5.add("Dreamer");
        categories5.add("Practical");
        categories5.add("Intelligent");
        categories5.add("Funny");
        dataAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories5) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(dataAdapter5);
        spinner5.setOnItemSelectedListener(this);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
    selectDate.setInputType(0);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item

        switch (parent.getId()) {
            case R.id.spinner:
                String item1 = parent.getItemAtPosition(position).toString();
                ugraduationlevel = item1;
            case R.id.spinner2:
                Spinner spinner3 = findViewById(R.id.spinner3);
                String item2 = parent.getItemAtPosition(position).toString();
                ustate = item2;
                // Spinner Drop down elements
                switch (item2) {
                    case "Andaman and Nicobar Islands":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Bamboo Flat");
                        categories3.add("Garacherama");
                        categories3.add("Port Blair");
                        categories3.add("Prothrapur");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Andhra Pradesh":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Adoni");
                        categories3.add("Amaravati");
                        categories3.add("Anantapur");
                        categories3.add("Chandragiri");
                        categories3.add("Chittoor");
                        categories3.add("Dowlaiswaram");
                        categories3.add("Eluru");
                        categories3.add("Guntur");
                        categories3.add("Kadapa");
                        categories3.add("Kakinada");
                        categories3.add("Kurnool");
                        categories3.add("Machilipatnam");
                        categories3.add("Nagarjunakonda");
                        categories3.add("Rajahmundry");
                        categories3.add("Srikakulam");
                        categories3.add("Tirupati");
                        categories3.add("Vijayawada");
                        categories3.add("Visakhapatnam");
                        categories3.add("Vizianagaram");
                        categories3.add("Yemmiganur");

                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Arunachal Pradesh":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Aalo");
                        categories3.add("Itanagar");
                        categories3.add("Naharlagun");
                        categories3.add("Pasighat");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Assam":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Dhuburi");
                        categories3.add("Dibrugarh");
                        categories3.add("Dispur");
                        categories3.add("Guwahati");
                        categories3.add("Jorhat");
                        categories3.add("Nagaon");
                        categories3.add("Sibsagar");
                        categories3.add("Silchar");
                        categories3.add("Tezpur");
                        categories3.add("Tinsukia");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Bihar":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Ara");
                        categories3.add("Baruni");
                        categories3.add("Begusarai");
                        categories3.add("Bettiah");
                        categories3.add("Bhagalpur");
                        categories3.add("Bihar Sharif");
                        categories3.add("Bodh Gaya");
                        categories3.add("Buxar");
                        categories3.add("Chapra");
                        categories3.add("Darbhanga");
                        categories3.add("Dehri");
                        categories3.add("Dinapur Nizamat");
                        categories3.add("Gaya");
                        categories3.add("Hajipur");
                        categories3.add("Jamalpur");
                        categories3.add("Katihar");
                        categories3.add("Madhubani");
                        categories3.add("Motihari");
                        categories3.add("Munger");
                        categories3.add("Muzzafarpur");
                        categories3.add("Patna");
                        categories3.add("Purnia");
                        categories3.add("Pusa");
                        categories3.add("Saharsa");
                        categories3.add("Samastipur");
                        categories3.add("Sasaram");
                        categories3.add("Sitamarhi");
                        categories3.add("Siwan");

                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Chandigarh":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Chandigarh");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Chhattisgarh":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Ambikapur");
                        categories3.add("Bhilai");
                        categories3.add("Bilaspur");
                        categories3.add("Dhamtari");
                        categories3.add("Durg");
                        categories3.add("Jagdalpur");
                        categories3.add("Raipur");
                        categories3.add("Rajnandgaon");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Dadra and Nagar Haveli":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Dadra");
                        categories3.add("Masat");
                        categories3.add("Naroli");
                        categories3.add("Samarvarni");
                        categories3.add("Silvassa");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Daman and Diu":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Dadhel");
                        categories3.add("Daman");
                        categories3.add("Diu");
                        categories3.add("Kachigam");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Delhi":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("New Delhi");
                        categories3.add("North Delhi");
                        categories3.add("North West Delhi");
                        categories3.add("West Delhi");
                        categories3.add("South West Delhi");
                        categories3.add("South Delhi");
                        categories3.add("South East Delhi");
                        categories3.add("Cental Delhi");
                        categories3.add("North East Delhi");
                        categories3.add("Shahdara");
                        categories3.add("East Delhi");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Goa":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Mapusa");
                        categories3.add("Madgaon");
                        categories3.add("Mormugao");
                        categories3.add("Panaji");
                        categories3.add("Ponda");
                        categories3.add("Sancoale");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Gujarat":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Ahmadabad");
                        categories3.add("Amreli");
                        categories3.add("Bharuch");
                        categories3.add("Bhavnagar");
                        categories3.add("Bhuj");
                        categories3.add("Dwarka");
                        categories3.add("Gandhinagar");
                        categories3.add("Godhra");
                        categories3.add("Jamnagar");
                        categories3.add("Junagadh");
                        categories3.add("Kandla");
                        categories3.add("Khambhat");
                        categories3.add("Kheda");
                        categories3.add("Mahesana");
                        categories3.add("Morvi");
                        categories3.add("Nadiad");
                        categories3.add("Navsari");
                        categories3.add("Okha");
                        categories3.add("Palanpur");
                        categories3.add("Patan");
                        categories3.add("Porbandar");
                        categories3.add("Rajkot");
                        categories3.add("Surat");
                        categories3.add("Surendranagar");
                        categories3.add("Valsad");
                        categories3.add("Veraval");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Haryana":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Ambala");
                        categories3.add("Bhiwani");
                        categories3.add("Chandigarh");
                        categories3.add("Faridabad");
                        categories3.add("Firozpur Jhirka");
                        categories3.add("Gurgaon");
                        categories3.add("Hansi");
                        categories3.add("Hisar");
                        categories3.add("Jind");
                        categories3.add("Kaithal");
                        categories3.add("Karnal");
                        categories3.add("Kurukshetra");
                        categories3.add("Panipat");
                        categories3.add("Pehowa");
                        categories3.add("Rewari");
                        categories3.add("Rohtak");
                        categories3.add("Sirsa");
                        categories3.add("Sonepat");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Himachal Pradesh":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Bilaspur");
                        categories3.add("Chamba");
                        categories3.add("Dalhousie");
                        categories3.add("Dharmshala");
                        categories3.add("Hamirpur");
                        categories3.add("Kangra");
                        categories3.add("Kullu");
                        categories3.add("Mandi");
                        categories3.add("Nahan");
                        categories3.add("Shimla");
                        categories3.add("Una");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Jammu and Kashmir":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Anantnag");
                        categories3.add("Baramula");
                        categories3.add("Doda");
                        categories3.add("Gulmarg");
                        categories3.add("Jammu");
                        categories3.add("Kathua");
                        categories3.add("Leh");
                        categories3.add("Poonch");
                        categories3.add("Rajauri");
                        categories3.add("Srinagar");
                        categories3.add("Udhampur");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Jharkhand":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Bokaro");
                        categories3.add("Chaibasa");
                        categories3.add("Deoghar");
                        categories3.add("Dhanbad");
                        categories3.add("Dumka");
                        categories3.add("Giridih");
                        categories3.add("Hazaribag");
                        categories3.add("Jamshedpur");
                        categories3.add("Jharia");
                        categories3.add("Rajmahal");
                        categories3.add("Ranchi");
                        categories3.add("Saraikela");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Karnataka":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Badami");
                        categories3.add("Ballari");
                        categories3.add("Bangalore");
                        categories3.add("Belgavi");
                        categories3.add("Bhadravati");
                        categories3.add("Bidar");
                        categories3.add("Chikkamangaluru");
                        categories3.add("Chitradurga");
                        categories3.add("Davangere");
                        categories3.add("Halebid");
                        categories3.add("Hassan");
                        categories3.add("Hubballi Dharwad");
                        categories3.add("Kalaburagi");
                        categories3.add("Kolar");
                        categories3.add("Madikeri");
                        categories3.add("Mandya");
                        categories3.add("Mangaluru");
                        categories3.add("Mysuru");
                        categories3.add("Raichur");
                        categories3.add("Shivamogga");
                        categories3.add("Sharavanabelagola");
                        categories3.add("Shrirangapattana");
                        categories3.add("Tumkuru");

                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Kerala":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Alappuzha");
                        categories3.add("Badagara");
                        categories3.add("Idukki");
                        categories3.add("Kannur");
                        categories3.add("Kochi");
                        categories3.add("Kollam");
                        categories3.add("Kottayam");
                        categories3.add("Kozhikode");
                        categories3.add("Mattancheri");
                        categories3.add("Palakkad");
                        categories3.add("Thalassery");
                        categories3.add("Thiruvananthapuram");
                        categories3.add("Thrissur");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Lakshadweep":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Amini");
                        categories3.add("Andrott");
                        categories3.add("Kavaratti");
                        categories3.add("Minicoy");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Madhya Pradesh":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Balaghat");
                        categories3.add("Barwani");
                        categories3.add("Betul");
                        categories3.add("Bharhut");
                        categories3.add("Bhind");
                        categories3.add("Bhojpur");
                        categories3.add("Bhopal");
                        categories3.add("Burhanpur");
                        categories3.add("Chhatarpur");
                        categories3.add("Chhindwara");
                        categories3.add("Damoh");
                        categories3.add("Datia");
                        categories3.add("Dewas");
                        categories3.add("Dhar");
                        categories3.add("Guna");
                        categories3.add("Gwalior");
                        categories3.add("Hoshangabad");
                        categories3.add("Indore");
                        categories3.add("Itarsi");
                        categories3.add("Jabalpur");
                        categories3.add("Jhabua");
                        categories3.add("Khajuraho");
                        categories3.add("Khandwa");
                        categories3.add("Khargaon");
                        categories3.add("Maheshwar");
                        categories3.add("Mandla");
                        categories3.add("Mandsaur");
                        categories3.add("Mhow");
                        categories3.add("Morena");
                        categories3.add("Murwara");
                        categories3.add("Narsimhapur");
                        categories3.add("NArsinghgarh");
                        categories3.add("Neemuch");
                        categories3.add("Orchha");
                        categories3.add("Panna");
                        categories3.add("Raisen");
                        categories3.add("Rajgarh");
                        categories3.add("Ratlam");
                        categories3.add("Rewa");
                        categories3.add("Sagar");
                        categories3.add("Sarangpur");
                        categories3.add("Satna");
                        categories3.add("Sehore");
                        categories3.add("Seoni");
                        categories3.add("Shahdol");
                        categories3.add("Shajapur");
                        categories3.add("Sheopur");
                        categories3.add("Shivpuri");
                        categories3.add("Ujjain");
                        categories3.add("Vidisha");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Maharashtra":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Ahmadnagar");
                        categories3.add("Akola");
                        categories3.add("Amravati");
                        categories3.add("Aurangabad");
                        categories3.add("Bhandara");
                        categories3.add("Bhusawal");
                        categories3.add("Bid");
                        categories3.add("Buldana");
                        categories3.add("Chandrapur");
                        categories3.add("Daulatabad");
                        categories3.add("Dhule");
                        categories3.add("Jalgaon");
                        categories3.add("Kalyan");
                        categories3.add("Karli");
                        categories3.add("Kolhapur");
                        categories3.add("Mahabaleshwar");
                        categories3.add("Malegaon");
                        categories3.add("Matheran");
                        categories3.add("Mumbai");
                        categories3.add("Nagpur");
                        categories3.add("Nanded");
                        categories3.add("Nashik");
                        categories3.add("Osmanabad");
                        categories3.add("Pandharpur");
                        categories3.add("Parbhani");
                        categories3.add("Pune");
                        categories3.add("Ratnagiri");
                        categories3.add("Sangli");
                        categories3.add("Satara");
                        categories3.add("Sevagram");
                        categories3.add("Solapur");
                        categories3.add("Thane");
                        categories3.add("Ulhasnagar");
                        categories3.add("Vasai-Virar");
                        categories3.add("Wardha");
                        categories3.add("Yavatmal");

                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Manipur":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Imphal");
                        categories3.add("Kakching");
                        categories3.add("Mayang Imphal");
                        categories3.add("Thoubal");
                        categories3.add("Ukhrul");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Meghalaya":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Jowai");
                        categories3.add("Nongstoin");
                        categories3.add("Shillong");
                        categories3.add("Tura");
                        categories3.add("Williamnagar");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Mizoram":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Aizawl");
                        categories3.add("Champhai");
                        categories3.add("Kolasib");
                        categories3.add("Lawngtlai");
                        categories3.add("Lunglei");
                        categories3.add("Saiha");
                        categories3.add("Serchipp");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Nagaland":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Dimapur");
                        categories3.add("Kohima");
                        categories3.add("Mokokchung");
                        categories3.add("Mon");
                        categories3.add("Tuensang");
                        categories3.add("Wokha");
                        categories3.add("Zunheboto");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Orissa":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Balangir");
                        categories3.add("Baleshwar");
                        categories3.add("Baripada");
                        categories3.add("Bhubaneshwar");
                        categories3.add("Brahmapur");
                        categories3.add("Cuttack");
                        categories3.add("Dhenkanal");
                        categories3.add("Keonjhar");
                        categories3.add("Konark");
                        categories3.add("Koraput");
                        categories3.add("Paradip");
                        categories3.add("Phulabani");
                        categories3.add("Puri");
                        categories3.add("Sambalpur");
                        categories3.add("Udaygiri");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Puducherry":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Karaikal");
                        categories3.add("Mahe");
                        categories3.add("Puducherry");
                        categories3.add("Yanam");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Punjab":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Amritsar");
                        categories3.add("Batala");
                        categories3.add("Chandigarh");
                        categories3.add("Faridkot");
                        categories3.add("Firozpur");
                        categories3.add("Gurdaspur");
                        categories3.add("Hoshiarpur");
                        categories3.add("Jalandhar");
                        categories3.add("Kapurthala");
                        categories3.add("Ludhiana");
                        categories3.add("Nabha");
                        categories3.add("Patiala");
                        categories3.add("Rupnagar");
                        categories3.add("Sangrur");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Rajasthan":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Abu");
                        categories3.add("Ajmer");
                        categories3.add("Alwar");
                        categories3.add("Amer");
                        categories3.add("Barmer");
                        categories3.add("Beawar");
                        categories3.add("Bharatpur");
                        categories3.add("Bhilwara");
                        categories3.add("Bikaner");
                        categories3.add("Bundi");
                        categories3.add("Chittorgarh");
                        categories3.add("Churu");
                        categories3.add("Dhaulpur");
                        categories3.add("Dungarpur");
                        categories3.add("Ganganagar");
                        categories3.add("Hanumangarh");
                        categories3.add("Jaipur");
                        categories3.add("Jaisalmer");
                        categories3.add("Jalor");
                        categories3.add("Jhalawar");
                        categories3.add("Jhunjhunu");
                        categories3.add("Jodhpur");
                        categories3.add("Kishangarh");
                        categories3.add("Kota");
                        categories3.add("Merta");
                        categories3.add("Nagaur");
                        categories3.add("Nathdwara");
                        categories3.add("Pali");
                        categories3.add("Phalodi");
                        categories3.add("Pushkar");
                        categories3.add("Sawai Madhopur");
                        categories3.add("Shahpura");
                        categories3.add("Sikar");
                        categories3.add("Sirohi");
                        categories3.add("Tonk");
                        categories3.add("Udaipur");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Sikkim":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Gangtok");
                        categories3.add("Gyalsing");
                        categories3.add("Lachung");
                        categories3.add("Mangan");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Tamil Nadu":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Arcot");
                        categories3.add("Chengalpattu");
                        categories3.add("Chennai");
                        categories3.add("Chidambaram");
                        categories3.add("Coimbatore");
                        categories3.add("Cuddalore");
                        categories3.add("Dharmapuri");
                        categories3.add("Dindigul");
                        categories3.add("Erode");
                        categories3.add("Kanchipuram");
                        categories3.add("Kanyakumari");
                        categories3.add("Kodaikanal");
                        categories3.add("Kumbakonam");
                        categories3.add("Madurai");
                        categories3.add("Mamallapuram");
                        categories3.add("Nagappattinam");
                        categories3.add("Nagercoil");
                        categories3.add("Palayankottai");
                        categories3.add("Pudukottai");
                        categories3.add("Rajapaliyam");
                        categories3.add("Ramnathapuram");
                        categories3.add("Salem");
                        categories3.add("Thanjavur");
                        categories3.add("Tiruchchirappalli");
                        categories3.add("Tirunelveli");
                        categories3.add("Tiruppur");
                        categories3.add("Tuticorin");
                        categories3.add("Udhagamandalam");
                        categories3.add("Vellore");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Telangana":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Hyderabad");
                        categories3.add("Karimnagar");
                        categories3.add("Khammam");
                        categories3.add("Mahbubnagar");
                        categories3.add("Nizamabad");
                        categories3.add("Sangareddi");
                        categories3.add("Warangal");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Tripura":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Agartala");
                        categories3.add("Belonia");
                        categories3.add("Bishalgarh");
                        categories3.add("Dharmanagar");
                        categories3.add("Kailashahar");
                        categories3.add("Teliamura");
                        categories3.add("Udaipur");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Uttarakhand":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Almora");
                        categories3.add("Dehradun");
                        categories3.add("Haridwar");
                        categories3.add("Kathgodam");
                        categories3.add("Mussorie");
                        categories3.add("Nainital");
                        categories3.add("Pithoragarh");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "Uttar Pradesh":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Agra");
                        categories3.add("Aligarh");
                        categories3.add("Allahabad");
                        categories3.add("Amroha");
                        categories3.add("Ayodhya");
                        categories3.add("Azamgarh");
                        categories3.add("Bahraich");
                        categories3.add("Balia");
                        categories3.add("Banda");
                        categories3.add("Barabanki");
                        categories3.add("Bareilly");
                        categories3.add("Basti");
                        categories3.add("Bijnor");
                        categories3.add("Bithur");
                        categories3.add("Budaun");
                        categories3.add("Bulandshahar");
                        categories3.add("Deoria");
                        categories3.add("Etah");
                        categories3.add("Etawah");
                        categories3.add("Faizabad");
                        categories3.add("Farrukhabad");
                        categories3.add("Fatehpur");
                        categories3.add("Fatehpur Sikri");
                        categories3.add("Ghaziabad");
                        categories3.add("Ghazipur");
                        categories3.add("Gonda");
                        categories3.add("Gorakhpur");
                        categories3.add("Hamirpur");
                        categories3.add("Hardoi");
                        categories3.add("Hathras");
                        categories3.add("Jalaun");
                        categories3.add("Jaunpur");
                        categories3.add("Jhansi");
                        categories3.add("Kannauj");
                        categories3.add("Kanpur");
                        categories3.add("Lakhimpur");
                        categories3.add("Lalitpur");
                        categories3.add("Lucknow");
                        categories3.add("Mainpuri");
                        categories3.add("Mathura");
                        categories3.add("Meerut");
                        categories3.add("Mirzapur");
                        categories3.add("Moradabad");
                        categories3.add("Muzzafarnagar");
                        categories3.add("Partapgarh");
                        categories3.add("Rae Bareli");
                        categories3.add("Rampur");
                        categories3.add("Saharanpur");
                        categories3.add("Sambhal");
                        categories3.add("Shahjahanpur");
                        categories3.add("Sitapur");
                        categories3.add("Sultanpur");
                        categories3.add("Tehri");
                        categories3.add("Varanasi");
                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;
                    case "West Bengal":
                        categories3 = new ArrayList<String>();
                        categories3.add("Select City");
                        categories3.add("Alipore");
                        categories3.add("Alipur Duar");
                        categories3.add("Asansol");
                        categories3.add("Baharampur");
                        categories3.add("Bally");
                        categories3.add("Balurghat");
                        categories3.add("Bankura");
                        categories3.add("Baranagar");
                        categories3.add("Barasat");
                        categories3.add("Barrackpore");
                        categories3.add("Basirhat");
                        categories3.add("Bhatpara");
                        categories3.add("Bishnupur");
                        categories3.add("Budge Budge");
                        categories3.add("Burdwan");
                        categories3.add("Chandernagore");
                        categories3.add("Darjiling");
                        categories3.add("Diamond Harbour");
                        categories3.add("Dum Dum");
                        categories3.add("Durgapur");
                        categories3.add("Halisahar");
                        categories3.add("Haora");
                        categories3.add("Hugli");
                        categories3.add("Ingraj Bazar");
                        categories3.add("Jalpaiguri");
                        categories3.add("Kalimpong");
                        categories3.add("Kamarhati");
                        categories3.add("Kanchrapara");
                        categories3.add("Kharagpur");
                        categories3.add("Koch Bihar");
                        categories3.add("Kolkata");
                        categories3.add("Krishnanagar");
                        categories3.add("Malda");
                        categories3.add("Midnapore");
                        categories3.add("Murshidabad");
                        categories3.add("Navadwip");
                        categories3.add("Palashi");
                        categories3.add("Panihati");
                        categories3.add("Purulia");
                        categories3.add("Raiganj");
                        categories3.add("Santipur");
                        categories3.add("Shantiniketan");
                        categories3.add("Shrirampur");
                        categories3.add("Siliguri");
                        categories3.add("Siuri");
                        categories3.add("Tamluk");
                        categories3.add("Titagarh");

                        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3) {
                            @Override
                            public boolean isEnabled(int position) {
                                if (position == 0) {
                                    // Disable the first item from Spinner
                                    // First item will be use for hint
                                    return false;
                                } else {
                                    return true;
                                }
                            }

                            @Override
                            public View getDropDownView(int position, View convertView,
                                                        ViewGroup parent) {
                                View view = super.getDropDownView(position, convertView, parent);
                                TextView tv = (TextView) view;
                                if (position == 0) {
                                    // Set the hint text color gray
                                    tv.setTextColor(Color.GRAY);
                                } else {
                                    tv.setTextColor(Color.BLACK);
                                }
                                return view;
                            }
                        };
                        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter(dataAdapter3);
                        spinner3.setOnItemSelectedListener(this);
                        break;

                }

            case R.id.spinner3:
                String item3 = parent.getItemAtPosition(position).toString();
                ucity = item3;
                break;
            case R.id.spinner4:
                String item4 = parent.getItemAtPosition(position).toString();
                ugraduationfield = item4;
            case R.id.spinner5:
                String item5 = parent.getItemAtPosition(position).toString();
                utypeofyouth = item5;

        }

    }


    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void privacyLink(View view) {
        String privacy = "privacyyef";
        Intent intent = new Intent(UserProfile.this, WebViewSampleActivity.class);
        intent.putExtra("privacyyef", privacy);
        startActivity(intent);
    }

    public void datepick(View view) {

        if (view == selectDate) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            selectDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        ubday = "" + mDay + "-" + mMonth + "-" + mYear;
        uage = currentYear - mYear;
    }

    public void chooseImage1() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            try {
                if (n == 1)  { filePath1 = data.getData();
                   Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath1);
                    coverpic.setImageBitmap(bitmap);
                }
                if (n == 2) { filePath2=data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath2);
                    profilepic.setImageBitmap(bitmap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateProfile(View view) {
        btnCover = findViewById(R.id.coverpicupdate);
        btnProfile = findViewById(R.id.profilepicupdate);
        profilepic = findViewById(R.id.profile_image);
        coverpic = findViewById(R.id.cover_image);
        TextView name1 = findViewById(R.id.name);
        EditText entername = (EditText)findViewById(R.id.entername);
        EditText Aboutme = (EditText)findViewById(R.id.aboutme);
        EditText email1 = (EditText)findViewById(R.id.email);
        RadioGroup gender = (RadioGroup)findViewById(R.id.gender);
        EditText address = (EditText)findViewById(R.id.Address);
        EditText phone = (EditText)findViewById(R.id.phone);
        EditText bday=(EditText)findViewById(R.id.date);
        int gen =0;
        RadioButton male=findViewById(R.id.male);
        gen=gender.getCheckedRadioButtonId();
        RadioButton genradio = null;
                genradio= findViewById(gen);
                if(gen!=-1)
       ugender = genradio.getText().toString();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);
        Spinner spinner5 = (Spinner)findViewById(R.id.spinner5);

        uphoneno = phone.getText().toString();
        uplace = address.getText().toString();
        uaboutme = Aboutme.getText().toString();
        currentYear = Calendar.getInstance().get(Calendar.YEAR);
        uname = entername.getText().toString();
        ustate=spinner2.getSelectedItem().toString();
      try{  ucity=spinner3.getSelectedItem().toString();}
      catch(Exception e){
      }
        ugraduationlevel=spinner.getSelectedItem().toString();
        ugraduationfield=spinner4.getSelectedItem().toString();
        utypeofyouth=spinner5.getSelectedItem().toString();
        if(filePath2==null) {
            TextView profileimg=findViewById(R.id.profileerr);
            profileimg.requestFocus();
            profileimg.setError("Please change Profile Picture");
       return;
        }
        if(filePath1==null)
        {
            TextView coverimg=findViewById(R.id.covererr);
            coverimg.requestFocus();
            coverimg.setError("Please change Cover Picture");
            return;
        }
    if(entername.getText().length()==0) {
        entername.requestFocus();
        entername.setError("Please fill your name");
        return;
    }
    if(email!=null) {
        uemail = email;

        }
        if(email1.getText().length()!=0){
            uemail=email1.getText().toString();
        }
        if(email1.getText().length()==0) {
        email1.requestFocus();
        email1.setError("Please provide email");
        return;
    }
        if(Aboutme.getText().length()==0) {
           Aboutme.requestFocus();
           Aboutme.setError("Please Describe yourself");
           return;
        }
        if (gender.getCheckedRadioButtonId() == -1)
        {
            male.requestFocus();
            male.setError("Please select Gender");
            return;
        }
     if(bday.getText().length()==0) {
         bday.requestFocus();
         bday.setError("Provide your Birth date");
         return;
     }
         if(address.getText().length()==0) {
             address.requestFocus();
             address.setError("Provide your Address");
             return;
             }
             if(spinner2.getSelectedItem()=="Select State") {
                 TextView errorText = (TextView)spinner2.getSelectedView();
                 errorText.setError("");
                 errorText.setTextColor(Color.RED);
                 errorText.setText("Select State");
                 return;
                 }
        if(spinner3.getSelectedItem()==null||spinner3.getSelectedItem()=="Select City") {
            TextView errorText = (TextView)spinner3.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);
            errorText.setText("Select City");
            return;
        }
        if(phone.getText().length()==0) {
            phone.requestFocus();
            phone.setError("Enter Mobile Number");
            return;
        }
        if(spinner.getSelectedItem()=="Select") {
            TextView errorText = (TextView) spinner.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Select Graduation Level");
            return;
    }
        if(spinner4.getSelectedItem()=="Select") {
            TextView errorText = (TextView) spinner4.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Select Graduation Field");
            return;
    }
        if(spinner5.getSelectedItem()=="Select") {
            TextView errorText = (TextView) spinner5.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Select Type of Youth");
            return;
    }





        if(filePath1 != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            // progressDialog.setTitle("Uploading...");
            // progressDialog.show();

            final StorageReference ref = storageReference.child("Cover_images").child(uid);
            ref.putFile(filePath1).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            final Uri downloadUrl = uri;


                        }
                    });
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(UserProfile.this, "Failed to upload Cover Photo" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

        }

        if(filePath2 != null)
        {
           final ProgressDialog progressDialog = new ProgressDialog(this);
         //   progressDialog.setTitle("Uploading...");
           // progressDialog.show();

           final StorageReference ref = storageReference.child("Profile_images").child(uid);
            ref.putFile(filePath2).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        final Uri downloadUrl = uri;


                    }
                });
            }
        })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(UserProfile.this, "Failed to upload Profile Photo"+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                 }

        final MainActivity.User user = new MainActivity.User(uname,ugender ,uemail,uphotourl,uphoneno,ubday,uplace,ustate,ucity,uaboutme,ugraduationlevel,ugraduationfield,utypeofyouth,uage);

        myDatabase = FirebaseDatabase.getInstance().getReference();
        final ProgressDialog progress=new ProgressDialog(this);
        progress.setTitle("Updating Profile..");
        progress.show();
        myDatabase.child("users").child(uid).setValue(user)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progress.dismiss();
                        Toast.makeText(UserProfile.this,"Failed to Update Profile",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progress.dismiss();

                        AuthUI.getInstance().signOut(UserProfile.this);
                        Intent i=new Intent(UserProfile.this,VideoActivity.class);
                        startActivity(i);                    }
                });


    }

private void requestFocus(View view){
        if(view.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
}

}
