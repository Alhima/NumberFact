package cachosoftware.com.numberfacts.utils.base;

import android.support.annotation.CallSuper;

/**
 * Created by Alvaro Hidalgo on 24/2/17.
 */

public abstract class BasePresenter<V extends BaseView, I extends BaseInteractor> {

    protected V mView;
    protected I mInteractor;

    public BasePresenter(V mView) {
        this.mView = mView;
        this.mInteractor = getInteractor();
    }

    protected abstract I getInteractor();

    @CallSuper
    public void onViewDetached() {
        this.mView = null;
        this.mInteractor.onDestroy();
    }
}
