package jakeli.com.networktest1st;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.net.URL;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{
    private ImageView imageView;
    private static String TAG = "JJJ";

    public DownloadImageTask(ImageView imageView){
        this.imageView=imageView;
    }


    //下载 图片
    @Override
    protected Bitmap doInBackground(String... params){
        String imageUrl = params[0];
        Log.i(TAG, "doInBackground: " +imageUrl);

        InputStream in = null;
        try{
            Log.i(TAG, "doInBackground:  inside try");




            URL url = new URL(imageUrl);


            Log.i(TAG, "doInBackground:  inside try");


            HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();

            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");//http协议
            long a = System.currentTimeMillis();
            Log.i(TAG, "doInBackground: time11111 = " + System.currentTimeMillis());
            httpConn.connect();
            long b = System.currentTimeMillis();
            Log.i(TAG, "doInBackground: time2222222 = " + System.currentTimeMillis());

            Log.i(TAG, "doInBackground:  time diff = " + (b-a));
            int resCode = httpConn.getResponseCode();

            if(resCode == HttpURLConnection.HTTP_OK){
                Log.i(TAG, "doInBackground:  httpo ko ko ok ");

                in = httpConn.getInputStream();
                long c = System.currentTimeMillis();

                Log.i(TAG, "doInBackground: time33333 = " + System.currentTimeMillis());

                Log.i(TAG, "doInBackground: time diff2 =   " +  (c - b));

            }else{
                return null;
            }

            Bitmap bitmap = BitmapFactory.decodeStream(in);
            return bitmap;


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            IOUtils.closeQuietly(in);
        }

        return null;


    }

    @Override
    protected void onPostExecute(Bitmap result){
        if(result != null){
            this.imageView.setImageBitmap(result);
        }else{
            Log.e(TAG, "onPostExecute: xxxxx");;
        }
    }
}
