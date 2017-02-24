package cachosoftware.com.numberfacts.data;

import retrofit2.Retrofit;

/**
 * Created by Alvaro Hidalgo on 13/1/17.
 */

public class ServiceGenerator {

    private Retrofit retrofit;

    public ServiceGenerator (Retrofit retrofit){
        this.retrofit=retrofit;
    }

    public <T> T createService(Class<T> clazz){
        return retrofit.create(clazz);
    }

}


