package cachosoftware.com.numberfacts.data;

import cachosoftware.com.numberfacts.model.NumberFact;
import retrofit2.Call;

/**
 * Created by Alvaro Hidalgo on 14/1/17.
 */
public interface NumberHandlerInterface {
    Call getTrivia(int number, final ServiceListener<NumberFact> listener);
    Call getMath(int number, final ServiceListener<NumberFact> listener);
    Call getDate(int day, int month, final ServiceListener<NumberFact> listener);
    Call getYear(int year, final ServiceListener<NumberFact> listener);


    Call getTrivia(final ServiceListener<NumberFact> listener);
    Call getMath(final ServiceListener<NumberFact> listener);
    Call getDate(final ServiceListener<NumberFact> listener);
    Call getYear(final ServiceListener<NumberFact> listener);
}
