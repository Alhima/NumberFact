package cachosoftware.com.numberfacts.data;

/**
 * Created by Alvaro Hidalgo on 14/1/17.
 */
public class BaseService<T> {

    protected T service;

    public BaseService(T service){
        this.service=service;
    }
}
