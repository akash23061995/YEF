package yef.gwalior.aks.com.yef;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginByFirebaseActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth mAuth;
    private FirebaseUser mfirebaseUser;
    boolean language;
    String name,email,photoUrl;

    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.fui_auth_method_picker_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            language = extras.getBoolean("langkey");
        }
        if(language==false) {

        }
        signin();
        }
public void signin(){
    mfirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    if(mfirebaseUser!=null){
        takeHome();
    }
    else {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build());

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.yef_icon)
                        .setPrivacyPolicyUrl("https://www.freeprivacypolicy.com/privacy/view/adc22af935819d2cd4c6ee0af2fe6043")
                        .build(),
                RC_SIGN_IN);

    }

}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
               takeHome();

                }
                else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
                 Toast.makeText(getApplicationContext(),"Please Sign In",Toast.LENGTH_SHORT).show();
                   signin();
            }
        }
    }
  @Override  public  void onStart(){

       super.onStart();

    }

  @Override public void onStop(){
        super.onStop();

    }
@Override
public void onBackPressed() {
//    super.onBackPressed();
    Toast.makeText(getApplicationContext(),"Please Sign In",Toast.LENGTH_SHORT).show();
    signin();

}
    public void takeHome(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser!=null) {
            // Name, email address, and profile photo Url
            name = currentUser.getDisplayName();
            email = currentUser.getEmail();
            // Check if user's email is verified
            boolean emailVerified = currentUser.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = currentUser.getUid();
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("name", name);
            i.putExtra("email", email);
            i.putExtra("langkey", language);
            i.putExtra("userid",uid);
            startActivity(i);
        }
    }

}