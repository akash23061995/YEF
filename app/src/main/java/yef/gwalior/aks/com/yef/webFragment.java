package yef.gwalior.aks.com.yef;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class webFragment extends android.support.v4.app.Fragment {

    public String joinus=null,donate501=null,donate2000=null,donate6000=null,donate10000=null,donate20000=null,donate24000=null,project=null;
    public View v;
    public boolean language;
    WebView wb;
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if(bundle != null) {
            language=bundle.getBoolean("langkey");
            joinus=bundle.getString("joinus");
            donate501=bundle.getString("open500");
            donate2000=bundle.getString("open2000");
            donate6000=bundle.getString("open6000");
            donate10000=bundle.getString("open10000");
            donate20000=bundle.getString("open20000");
            donate24000=bundle.getString("open24000");
           project=bundle.getString("project");
        }


            v = inflater.inflate(R.layout.activity_web_view_sample, container, false);



try {

    wb = v.findViewById(R.id.webView1);
    wb.getSettings().setJavaScriptEnabled(true);
    wb.getSettings().setLoadWithOverviewMode(true);
    wb.getSettings().setUseWideViewPort(true);
    wb.getSettings().setBuiltInZoomControls(true);
    wb.getSettings().setPluginState(WebSettings.PluginState.ON);
    //  wb.getSettings().setPluginsEnabled(true);
    wb.setWebViewClient(new HelloWebViewClient());

    final ProgressDialog progress=new ProgressDialog(getContext());

    if(language==false)
        progress.setTitle("लोड हो रहा है..");
    else
        progress.setTitle("Loading ..");
    progress.show();

    if(joinus!=null)
        wb.loadUrl("https://www.yefindia.in/index.php/get-involved/volunteer");
    wb.setWebViewClient(new WebViewClient() {
        @Override
        public void onPageCommitVisible(WebView view, String url) {
            super.onPageCommitVisible(view, url);
            progress.dismiss();
        }
    });
    if(project!=null)
        wb.loadUrl("https://www.yefindia.in/blog");
    wb.setWebViewClient(new WebViewClient() {
        @Override
        public void onPageCommitVisible(WebView view, String url) {
            super.onPageCommitVisible(view, url);
            progress.dismiss();
        }
    });
}
catch (Exception e){if(language==false)
    Toast.makeText(getContext(),"अपने डेटा कनेक्शन की जांच करें",Toast.LENGTH_LONG).show();
else
    Toast.makeText(getContext(),"Check your Data Connection",Toast.LENGTH_LONG).show();
}

        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        return v;


    }

}