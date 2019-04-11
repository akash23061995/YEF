package yef.gwalior.aks.com.yef;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedbackFragment extends android.support.v4.app.Fragment implements View.OnClickListener{

public int i=0;
public View v;
public EditText E1;
boolean language;
    private FirebaseAuth mAuth;
    FirebaseUser mfirebaseUser;
    DatabaseReference myDatabase;
    public String username;
    public String uid,ubuttonvalue,ufeedbackvalue;
     public int urating=0;
@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
        language=bundle.getBoolean("langkey");
        uid=bundle.getString("uid");
        }


        v = inflater.inflate(R.layout.feedback_fragment, container, false);



    ImageView reaction1,reaction2,reaction3,reaction4,reaction5;
    Button b1,b2,b3,b4;
  E1=v.findViewById(R.id.feedbackstring);
    reaction1=v.findViewById(R.id.reaction1);
    reaction2=v.findViewById(R.id.reaction2);
    reaction3=v.findViewById(R.id.reaction3);
    reaction4=v.findViewById(R.id.reaction4);
    reaction5=v.findViewById(R.id.reaction5);
    b1=v.findViewById(R.id.suggestion);
    b2=v.findViewById(R.id.somethingnotright);
    b3=v.findViewById(R.id.compliment);
    b4=v.findViewById(R.id.sendfeedback);
    reaction1.setClickable(true);
    reaction2.setClickable(true);
    reaction3.setClickable(true);
    reaction4.setClickable(true);
    reaction5.setClickable(true);
    reaction1.setOnClickListener(this);
    reaction2.setOnClickListener(this);
    reaction3.setOnClickListener(this);
    reaction4.setOnClickListener(this);
    reaction5.setOnClickListener(this);
    b1.setOnClickListener(this);
    b2.setOnClickListener(this);
    b3.setOnClickListener(this);
    b4.setOnClickListener(this);

    TextView t1,t2,t3,t4;
    t1=v.findViewById(R.id.feedbackt1);
    t2=v.findViewById(R.id.feedbackt2);
    t3=v.findViewById(R.id.feedbackt3);
    t4=v.findViewById(R.id.feedbackt4);
if (language==false){
    t1.setText("हम इस एप्लिकेशन को बेहतर बनाने के लिए आपकी प्रतिक्रिया चाहते हैं।");
    t2.setText("इस एप्लिकेशन पर आपकी क्या राय है?किसी एक चेहरे पर क्लिक करें");
    t3.setText("कृपया नीचे अपनी प्रतिक्रिया श्रेणी का चयन करें। किसी एक बटन पर क्लिक करें");
    t4.setText("कृपया नीचे अपनी प्रतिक्रिया छोड़ दें। भेजें पर क्लिक करना न भूलें  बिना उसपर क्लिक किये फीडबैक हम तक नही पहुचेगा।");
    b1.setText("सुझाव");
    b2.setText("कुछ सही नहीं है");
    b3.setText("प्रशंसा");
    b4.setText("भेजें");
    E1.setHint("अपनी प्रतिक्रिया यहां लिखें");
}

    return v;

}

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.reaction1:
                if(language==false){
                    Toast.makeText(getActivity(),"हाय ! .... आप हमें १ रेट करते हैं . हम सोचते हैं कि आप हमसे गुस्से में हैं !",Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(getActivity(),"Ohoo!....You rate us 1.We think you are angry with us!",Toast.LENGTH_LONG).show();
                urating=1;
                break;
            case R.id.reaction2:
                if(language==false){
                Toast.makeText(getActivity(),"हे भगवान ! .... आप हमें २ रेट करते हैं । हमें लगता है कि आप हमारे साथ खुश नहीं हैं !",Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(getActivity(),"Oh!....You rate us 2.We think you are not happy with us!",Toast.LENGTH_LONG).show();
                urating=2;
                break;
            case R.id.reaction3:
                if(language==false){
                    Toast.makeText(getActivity(),"शुक्र है ! ... आप हमें ३ रेट करते हैं । हम सोचते हैं कि आप हमारे साथ ठीक हैं!",Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(getActivity(),"Hmmm!...You rate us 3.We think you are ok with us!",Toast.LENGTH_LONG).show();
                urating=3;
                break;
            case R.id.reaction4:
                if(language==false){
                    Toast.makeText(getActivity(),"वाह ! ... आप हमें ४ रेट करते हैं । हम सोचते हैं कि आप हमारे साथ अच्छे हैं !",Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(getActivity(),"Yay!...You rate us 4.We think you are good with us!",Toast.LENGTH_LONG).show();
                urating=4;
                break;
            case R.id.reaction5:
                if(language==false){
                    Toast.makeText(getActivity(),"गज़ब ! .... आप हमें ५ रेट करते हैं । हम सोचते हैं कि आप हमारे साथ बहुत खुश हैं !\n",Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(getActivity(),"Wow!....You rate us 5.We think you are happy with us!",Toast.LENGTH_LONG).show();
                urating=5;
                break;
            case R.id.suggestion:
                ubuttonvalue="Suggestion";
                if(language==false){
                    Toast.makeText(getActivity(),"आप सुझाव देना चाहते हैं, नीचे की जगह में लिखें।",Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(getActivity(),"You want to give suggestion,write in below space.",Toast.LENGTH_LONG).show();
                break;
            case R.id.somethingnotright:
                ubuttonvalue="Something is not right";
                if(language==false){
                    Toast.makeText(getActivity(),"इंगित करने के लिए धन्यवाद, यह आपके जैसे लोग हैं जो हमें सही करते हैं, नीचे की जगह में लिखें।",Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(getActivity(),"Thanks for pointing out,it's people like you who correct us,write in below space.",Toast.LENGTH_LONG).show();
                break;
            case R.id.compliment:
                ubuttonvalue="Compliment";
                if(language==false){
                    Toast.makeText(getActivity(),"प्रशंसा के लिए धन्यवाद यह आपके जैसे लोग हैं जो हमें प्रेरित करते हैं, नीचे दी गई जगह में अपनी तारीफ लिखें।",Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(getActivity(),"Thanks for the compliment its people like you who motivates us,write your compliment in below space.",Toast.LENGTH_LONG).show();
                break;
            case R.id.sendfeedback:
                try{  if(E1.getText().length()==0)
                {  E1.requestFocus();
                    E1.setError("Please fill this");

                    return;
                }
                ufeedbackvalue=E1.getText().toString();}
               catch(Exception e){};
                final MainActivity.Feedback feedback = new MainActivity.Feedback(ubuttonvalue ,ufeedbackvalue,urating);

                myDatabase = FirebaseDatabase.getInstance().getReference();
                final ProgressDialog progress=new ProgressDialog(getContext());
                if(language==false)
                    progress.setTitle("प्रतिक्रिया भेज रहे हैं");
                else
                progress.setTitle("Sending Feedback");
                progress.show();
                myDatabase.child("feedback").child(uid).setValue(feedback)
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progress.dismiss();
                    if(language==false)
                        Toast.makeText(getActivity(),"प्रतिक्रिया भेजने में विफल रहा",Toast.LENGTH_LONG).show();
                    else
                                Toast.makeText(getActivity(),"Failed to Send Feedback",Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                progress.dismiss();
                                if(language==false)
                                    Toast.makeText(getActivity(),"प्रतिक्रिया भेज दिया",Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(getActivity(),"Feedback Sent",Toast.LENGTH_LONG).show();
                            }
                        });


                break;
        }


    }



}

