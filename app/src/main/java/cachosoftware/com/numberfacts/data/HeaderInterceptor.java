package cachosoftware.com.numberfacts.data;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Alvaro Hidalgo on 14/1/17.
 */

public class HeaderInterceptor implements Interceptor {
    public static final String CONTENTTYPE = "Content-Type";
    public static final String JSON = "application/json";



    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder()
                .addHeader(CONTENTTYPE, JSON);
        return chain.proceed(builder.build());
    }
}
