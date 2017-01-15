package cachosoftware.com.numberfacts.data;
import cachosoftware.com.numberfacts.model.NumberFact;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by a Monkey on 14/1/17.
 */

public class NumberHandler extends BaseService<NumberService> implements NumberHandlerInterface{

    public NumberHandler(NumberService service) {
        super(service);
    }

    @Override
    public Call getTrivia(int number, final ServiceListener<NumberFact> listener) {
        Call<NumberFact> call = service.getTrivia(number);

        call.enqueue(new Callback<NumberFact>() {
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                listener.onError((Exception) t);
            }
        });
        return call;
    }

    @Override
    public Call getMath(int number, final ServiceListener<NumberFact> listener) {
        Call<NumberFact> call = service.getMath(number);
        call.enqueue(new Callback<NumberFact>() {
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                listener.onError((Exception) t);
            }
        });
        return call;
    }

    @Override
    public Call getDate(int day, int month, final ServiceListener<NumberFact> listener) {
        Call<NumberFact> call = service.getDate(month,day);
        call.enqueue(new Callback<NumberFact>() {
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                listener.onError((Exception) t);
            }
        });
        return call;
    }

    @Override
    public Call getYear(int year, final ServiceListener<NumberFact> listener) {
        Call<NumberFact> call = service.getYear(year);
        call.enqueue(new Callback<NumberFact>() {
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                listener.onError((Exception) t);
            }
        });
        return call;
    }








    @Override
    public Call getTrivia(final ServiceListener<NumberFact> listener) {
        Call<NumberFact> call = service.getTrivia();

        call.enqueue(new Callback<NumberFact>() {
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                listener.onError((Exception) t);
            }
        });
        return call;
    }

    @Override
    public Call getMath(final ServiceListener<NumberFact> listener) {
        Call<NumberFact> call = service.getMath();
        call.enqueue(new Callback<NumberFact>() {
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                listener.onError((Exception) t);
            }
        });
        return call;
    }

    @Override
    public Call getDate(final ServiceListener<NumberFact> listener) {
        Call<NumberFact> call = service.getDate();
        call.enqueue(new Callback<NumberFact>() {
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                listener.onError((Exception) t);
            }
        });
        return call;
    }

    @Override
    public Call getYear(final ServiceListener<NumberFact> listener) {
        Call<NumberFact> call = service.getYear();
        call.enqueue(new Callback<NumberFact>() {
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                listener.onError((Exception) t);
            }
        });
        return call;
    }
}
