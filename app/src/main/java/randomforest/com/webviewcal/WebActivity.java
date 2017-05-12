package randomforest.com.webviewcal;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    Bundle webBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_content);

        webView=(WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        Configuration config=getResources().getConfiguration();
        webView.addJavascriptInterface(new ScriptInterface(this), "android");

        if(config.orientation==Configuration.ORIENTATION_PORTRAIT){

            webView.loadUrl("file:///android_asset/test2.html");



            if(savedInstanceState==null){


            }
            else{
               // webView.restoreState(savedInstanceState);
            }

        }

        else if(config.orientation==Configuration.ORIENTATION_LANDSCAPE){
            webView.loadUrl("file:///android_asset/test.html");


            if(savedInstanceState==null){



            }
            else{
               // webView.restoreState(savedInstanceState);
            }
        }





        //String customHtml = "<html><body><h2>Greetings from Aiub Android Class!</h2></body></html>";
        //webView.loadData(customHtml, "text/html", "UTF-8");

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){

          //  recreate();
        }

        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){

           // recreate();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        webBundle=new Bundle();
        webView.saveState(webBundle);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(webBundle);
    }
}
