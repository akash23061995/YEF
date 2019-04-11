package yef.gwalior.aks.com.yef;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class WebViewSampleActivity extends AppCompatActivity {
    public boolean language;
    WebView wb;
    public class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_sample);
        String web=null;String privacy=null;
        String donate501=null,donate2000=null,donate6000=null,donate10000=null,donate20000=null,donate24000=null,readmore=null,diwalidonate=null;
        Bundle  extras = getIntent().getExtras();
        if(extras != null) {
            language=extras.getBoolean("langkey");
        web= extras.getString("openwebsite");
            privacy=extras.getString("privacyyef");
            donate501=extras.getString("open500");
            donate2000=extras.getString("open2000");
            donate6000=extras.getString("open6000");
            donate10000=extras.getString("open10000");
            donate20000=extras.getString("open20000");
            donate24000=extras.getString("open24000");
            readmore=extras.getString("readmore");
            diwalidonate=extras.getString("donatediwali");
        }
try {
    wb = (WebView) findViewById(R.id.webView1);
    wb.getSettings().setJavaScriptEnabled(true);
    wb.getSettings().setLoadWithOverviewMode(true);
    wb.getSettings().setUseWideViewPort(true);
    wb.getSettings().setBuiltInZoomControls(true);
    wb.getSettings().setPluginState(WebSettings.PluginState.ON);
    //  wb.getSettings().setPluginsEnabled(true);
    wb.setWebViewClient(new HelloWebViewClient());
    if (web != null) {  final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();

        wb.loadUrl("http://www.yefindia.in");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }
    if (privacy != null) {
        final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();

        wb.loadUrl("https://www.freeprivacypolicy.com/privacy/view/8d213feadd016f6f5f436734a720ead1");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }
    if (donate501 != null) {
        final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();

        wb.loadUrl("https://www.instamojo.com/@yefindiango/l5fcfcdef463349e38447a5721298a019/");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }
    if (donate2000 != null) {
        final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();

        wb.loadUrl("https://www.instamojo.com/@yefindiango/lc917444b3ffa4599803b1ac52000317f/");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }
    if (donate6000 != null) {
        final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();

        wb.loadUrl("https://www.instamojo.com/@yefindiango/l4f1d03896bf040b2a0cd543f23928c1e/");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }
    if (donate10000 != null) {
        final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();

        wb.loadUrl("https://www.instamojo.com/@yefindiango/l18ef4dd7ff0641fb8e56caa1b7e583f4/");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }
    if (donate20000 != null) {
        final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();


        wb.loadUrl("https://www.instamojo.com/@yefindiango/l18ef4dd7ff0641fb8e56caa1b7e583f4/");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }
    if (donate24000 != null) {
        final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();


        wb.loadUrl("https://www.instamojo.com/@yefindiango/l18ef4dd7ff0641fb8e56caa1b7e583f4/");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }

    if (readmore != null) {
        final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();

        wb.loadUrl("http://impactgu.ru/community-women-3");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }
    if (diwalidonate != null) {
        final ProgressDialog progress = new ProgressDialog(this);
        if(language==false)
            progress.setTitle("लोड हो रहा है..");
        else
            progress.setTitle("Loading ..");
        progress.show();

        wb.loadUrl("http://impactgu.ru/IJ0nGv");
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progress.dismiss();
            }
        });
    }

}
catch (Exception e){
            if(language==false)
                Toast.makeText(this,"अपने डेटा कनेक्शन की जांच करें",Toast.LENGTH_LONG).show();
                else
            Toast.makeText(this,"Check your Data Connection",Toast.LENGTH_LONG).show();
}
    }
}
