package randomforest.com.webviewcal;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn=(Button) findViewById(R.id.url_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connmngr= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=connmngr.getActiveNetworkInfo();

                if(networkInfo!=null && networkInfo.isConnected()){

                        start_Web();


                }
                else{

                    start_Web();




                    btn.setText("Reload");
                    TextView error_msg=(TextView) findViewById(R.id.error_msg);
                    error_msg.setText("No Internet Connection");
                }


            }
        });
    }

    public void start_Web(){

        Intent intent =new Intent(getBaseContext(), WebActivity.class);
        startActivity(intent);
    }



}
