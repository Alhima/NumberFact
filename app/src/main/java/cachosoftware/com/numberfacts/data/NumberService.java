package cachosoftware.com.numberfacts.data;

import cachosoftware.com.numberfacts.model.NumberFact;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Alvaro Hidalgo on 14/1/17.
 */

public interface NumberService {


    @GET("{number}/trivia")
    Call<NumberFact> getTrivia(@Path("number") int number);

    @GET("{number}/math")
    Call<NumberFact> getMath(@Path("number") int number);

    @GET("{month}/{day}/date")
    Call<NumberFact> getDate(@Path("month") int month, @Path("day") int day);

    @GET("{number}/year")
    Call<NumberFact> getYear(@Path("number") int number);


    @GET("random/trivia")
    Call<NumberFact> getTrivia();

    @GET("random/math")
    Call<NumberFact> getMath();

    @GET("random/date")
    Call<NumberFact> getDate();

    @GET("random/year")
    Call<NumberFact> getYear();
}
