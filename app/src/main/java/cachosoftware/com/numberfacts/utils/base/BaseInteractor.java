package cachosoftware.com.numberfacts.utils.base;

import android.support.annotation.CallSuper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by Alvaro Hidalgo on 24/2/17.
 */


public abstract class BaseInteractor {

    private final List<Call> calls = new ArrayList<>();

    protected final void addCall(Call call){
        this.calls.add(call);
    }

    @CallSuper
    public void onDestroy(){
        for (Call call : calls) {
            if (call != null && !call.isCanceled()) call.cancel();
        }
    }
}
