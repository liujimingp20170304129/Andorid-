package jakeli.com.networktest1st;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imageView = (ImageView)this.findViewById(R.id.image_view);
        this.textView = (TextView)this.findViewById(R.id.textView);

    }

    public void downloadAndShowImage(View view){
        boolean networkOK = this.checkInternetConnection();
        if(!networkOK){
            return;
        }

        String imageUrl = "https://o7planning.org/download/static/default/demo-data/logo.png";
        DownloadImageTask task = new DownloadImageTask(this.imageView);
         task.execute(imageUrl);
    }

    public void downloadAndShowText(View view){
        boolean networkOK = this.checkInternetConnection();
        if(!networkOK){
            return;
        }

//        String jsonUrl = "http://o7planning.org/download/static/default/demo-data/company.json";
//
//        DownloadJSONTask task = new DownloadJSONTask(this.textView);
//        task.execute(jsonUrl);
    }


    private boolean checkInternetConnection(){
        // Get Connectivity Manager
        ConnectivityManager connManager =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Details about the currently active default data network
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            Toast.makeText(this, "No default network is currently active", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!networkInfo.isConnected()) {
            Toast.makeText(this, "Network is not connected", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!networkInfo.isAvailable()) {
            Toast.makeText(this, "Network not available", Toast.LENGTH_LONG).show();
            return false;
        }
        Toast.makeText(this, "Network OK", Toast.LENGTH_LONG).show();
        return true;
    }
}
