package jakeli.com.networktest2nd;

import android.os.AsyncTask;
import android.view.textclassifier.TextLinks;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpHandler extends AsyncTask<String, Void, String> {
    private TextView txtString;
    OkHttpClient client;

    public OKHttpHandler(TextView txtView, OkHttpClient client){
        this.txtString = txtView;
        this.client = client;
    }

    @Override
    protected String doInBackground(String... params){
        Request.Builder builder = new Request.Builder();

        builder.url(params[0]);
        Request request = builder.build();

        try{
            Response response = client.newCall(request).execute();
            ////block     阻塞
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);
        txtString.setText(s);
    }

}
