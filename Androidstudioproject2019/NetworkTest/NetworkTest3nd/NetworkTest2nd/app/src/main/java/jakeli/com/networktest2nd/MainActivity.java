package jakeli.com.networktest2nd;

import android.arch.lifecycle.MediatorLiveData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;

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
    EditText editText;
    Button asynchronousGet, synchronousGet, asynchronousPost;

    private String url = "http://v.juhe.cn/weather/index";
    private final String KEY = "5ec2e2b0909fbd130a1bb18ae6189d79";


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
        editText = (EditText)findViewById(R.id.edit_text);


    }

    void postRequest(String postUrl, String postBody) throws IOException{


    }

    void run() throws IOException{
//        url.getChars(editText.getText());
//        url.
//        url = url + "?" + "cityname=\"" + editText.getText() + "\"&key=" + KEY;
        String paramCity = URLEncoder.encode(editText.getText().toString(), "UTF-8");
        //%E6%B1%9F%E9%97%A8   江门
        url = "http://v.juhe.cn/weather/index?" + "cityname=" +  paramCity  +"&dtype=&format=&key=5ec2e2b0909fbd130a1bb18ae6189d79";
//        url = "http://v.juhe.cn/weather/index?cityname=%E6%B1%9F%E9%97%A8&dtype=&format=&key=5ec2e2b0909fbd130a1bb18ae6189d79";
//               http://v.juhe.cn/weather/index?cityname=%E6%B1%9F%E9%97%A8dtype=&format=&key=5ec2e2b0909fbd130a1bb18ae6189d79
        Log.d("TAG", "run: " + url);


        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.d("TAG", "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String myResponse = response.body().string();
                Log.d("TAG", "onResponse: ");
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            JSONObject json = new JSONObject(myResponse);
//                            txtString.setText("First Name: " + json.getJSONObject("data").getString("first_name") + "\nLast Name: " + json.getJSONObject("data").getString("last_name"));
                            txtString.setText(json.toString());

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
