package cachosoftware.com.numberfacts.data;

/**
 * Created by a Monkey on 14/1/17.
 */

public interface ServiceListener<T> {

    void onResponse(T response);
    void onError(Exception e);

}
