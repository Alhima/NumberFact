package cachosoftware.com.numberfacts.fragments;

import cachosoftware.com.numberfacts.utils.base.BaseView;

/**
 * Created by Alvaro Hidalgo on 24/2/17.
 */

public interface MainView extends BaseView {

    void showLoading(boolean show);
    void resetData();
    void setFact(String fact);

}
