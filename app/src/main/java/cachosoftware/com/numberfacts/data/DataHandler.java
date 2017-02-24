package cachosoftware.com.numberfacts.data;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alvaro Hidalgo on 13/1/17.
 */
public class DataHandler {

    public static final String BASEURL = "http://numbersapi.com/";

    private static DataHandler ourInstance;

    private static NumberHandlerInterface numberHandler;

    public static DataHandler getInstance() {
        if(ourInstance==null){
            ourInstance = new DataHandler();
        }
        return ourInstance;
    }

    private DataHandler() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor()).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceGenerator sGenerator= new ServiceGenerator(retrofit);
        numberHandler = new NumberHandler(sGenerator.createService(NumberService.class));
    }

    public NumberHandlerInterface getNumberHandler() {
        return numberHandler;
    }
}
