package jakeli.com.networktest2nd;

import android.arch.lifecycle.MediatorLiveData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    OkHttpClient client;

    TextView txtString;
    Button asynchronousGet, synchronousGet, asynchronousPost;

    private final String url = "https://reqres.in/api/users/2";
    private final String postUrl = "https://reqres.in/api/users/";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();

        setContentView(R.layout.activity_main);


        asynchronousGet = (Button)findViewById(R.id.asynchronousGet);
        synchronousGet = (Button)findViewById(R.id.synchronousGet);
        asynchronousPost = (Button)findViewById(R.id.asynchronousPost);

        asynchronousGet.setOnClickListener(this);
        synchronousGet.setOnClickListener(this);
        asynchronousPost.setOnClickListener(this);

        txtString = (TextView)findViewById(R.id.txtString);

    }

    void postRequest(String postUrl, String postBody) throws IOException{


    }

    void run() throws IOException{

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String myResponse = response.body().string();

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            JSONObject json = new JSONObject(myResponse);
                            txtString.setText("First Name: " + json.getJSONObject("data").getString("first_name") + "\nLast Name: " + json.getJSONObject("data").getString("last_name"));

                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.asynchronousGet:
                try{
                    run();
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case R.id.synchronousGet:
                OKHttpHandler okHttpHandler = new OKHttpHandler(txtString, client);
                okHttpHandler.execute(url);
                break;
            case R.id.asynchronousPost:

                break;
        }
    }
}
