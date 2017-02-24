package cachosoftware.com.numberfacts.fragments;

import cachosoftware.com.numberfacts.data.DataHandler;
import cachosoftware.com.numberfacts.data.ServiceListener;
import cachosoftware.com.numberfacts.model.NumberFact;
import cachosoftware.com.numberfacts.utils.base.BaseInteractor;

/**
 * Created by Alvaro Hidalgo on 24/2/17.
 */

public class MainIterator extends BaseInteractor{


    public void getYearFact(int number, ServiceListener<NumberFact> listener) {
        addCall(DataHandler.getInstance().getNumberHandler().getYear(number, listener));
    }

    public void getRandomYear(ServiceListener<NumberFact> listener) {
        addCall(DataHandler.getInstance().getNumberHandler().getYear(listener));
    }

    public void getMathFact(int number, ServiceListener<NumberFact> listener) {
        addCall(DataHandler.getInstance().getNumberHandler().getMath(number, listener));
    }


    public void getRandomMath(ServiceListener<NumberFact> listener) {
        addCall(DataHandler.getInstance().getNumberHandler().getMath(listener));
    }

    public void getDate(int day, int month, ServiceListener<NumberFact> listener) {
        addCall(DataHandler.getInstance().getNumberHandler().getDate(day, month, listener));
    }

    public void getRandomDate( ServiceListener<NumberFact> listener) {
        addCall(DataHandler.getInstance().getNumberHandler().getDate(listener));
    }

    public void getTriviaFromNumer(int number, ServiceListener<NumberFact> listener) {
        addCall(DataHandler.getInstance().getNumberHandler().getTrivia(number, listener));
    }

    public void getRandomTrivia(ServiceListener<NumberFact> listener) {
        addCall(DataHandler.getInstance().getNumberHandler().getTrivia(listener));
    }



}
