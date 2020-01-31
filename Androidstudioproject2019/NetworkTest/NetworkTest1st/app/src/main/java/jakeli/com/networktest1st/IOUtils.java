package jakeli.com.networktest1st;

import java.io.InputStream;
import java.io.Reader;

public class IOUtils {
    public static void closeQuietly(InputStream in){

        try{ in.close();

        }catch(Exception e) {

        }
    }

    public static void closeQuiety(Reader reader){
        try{
            reader.close();
        }catch(Exception e){

        }
    }
}
