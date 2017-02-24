package cachosoftware.com.numberfacts.fragments;

import cachosoftware.com.numberfacts.data.DataHandler;
import cachosoftware.com.numberfacts.data.ServiceListener;
import cachosoftware.com.numberfacts.model.NumberFact;
import cachosoftware.com.numberfacts.utils.base.BasePresenter;

/**
 * Created by Alvaro Hidalgo on 24/2/17.
 */

public class MainPresenter extends BasePresenter<MainView, MainIterator>{

    public MainPresenter(MainView mView) {
        super(mView);
    }

    public void getYearFact(int number) {
        mView.showLoading(true);
        DataHandler.getInstance().getNumberHandler().getYear(number, getMyServiceListener());
    }

    public void getRandomYear() {
        mView.showLoading(true);
        DataHandler.getInstance().getNumberHandler().getYear(getMyServiceListener());
    }

    public void getMathFact(int number) {
        mView.showLoading(true);
        DataHandler.getInstance().getNumberHandler().getMath(number, getMyServiceListener());
    }

    public void getRandomMath() {
        mView.showLoading(true);
        DataHandler.getInstance().getNumberHandler().getMath(getMyServiceListener());
    }

    public void getDate(int day, int month) {
        mView.showLoading(true);
        DataHandler.getInstance().getNumberHandler().getDate(day, month, getMyServiceListener());
    }

    public void getRandomDate() {
        mView.showLoading(true);
        DataHandler.getInstance().getNumberHandler().getDate(getMyServiceListener());
    }


    public void getTriviaFromNumer(int number) {
        mView.showLoading(true);
        mInteractor.getTriviaFromNumer(number, getMyServiceListener());
    }


    public void getRandomTrivia() {
        mView.showLoading(true);
        DataHandler.getInstance().getNumberHandler().getTrivia(getMyServiceListener());
    }


    public ServiceListener<NumberFact> getMyServiceListener(){
        return new ServiceListener<NumberFact>() {
            @Override
            public void onResponse(NumberFact response) {
                if(mView!=null){
                    if(response!=null){
                        mView.showLoading(false);
                        mView.setFact(response.getText());
                        mView.resetData();
                    }
                }
            }
            @Override
            public void onError(Exception e) {
                if(mView!=null){
                    mView.showLoading(false);
                }
            }
        };
    }


    @Override
    protected MainIterator getInteractor() {
        return new MainIterator();
    }
}
