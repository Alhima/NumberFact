package cachosoftware.com.numberfacts;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import cachosoftware.com.numberfacts.data.DataHandler;
import cachosoftware.com.numberfacts.data.ServiceListener;
import cachosoftware.com.numberfacts.model.NumberFact;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CallsUnitTest {
    @Test
    public void getTriviaIsSuccesfull() throws Exception {

        final CountDownLatch c = new CountDownLatch(1);
        DataHandler.getInstance().getNumberHandler().getTrivia(42, new ServiceListener<NumberFact>() {
            @Override
            public void onResponse(NumberFact response) {
                assertNotNull(response.getText());
                c.countDown();
            }

            @Override
            public void onError(Exception e) {
                assertTrue(false);
                c.countDown();

            }
        });

        c.await();
    }

    @Test
    public void getDateIsSuccesfull() throws Exception {

        DataHandler.getInstance().getNumberHandler().getDate(15,9, new ServiceListener<NumberFact>() {
            @Override
            public void onResponse(NumberFact response) {
                assertNotNull(response.getText());
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    @Test
    public void getYearIsSuccesfull() throws Exception {

        DataHandler.getInstance().getNumberHandler().getYear(1999, new ServiceListener<NumberFact>() {
            @Override
            public void onResponse(NumberFact response) {
                assertNotNull(response.getText());
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }


    @Test
    public void getMathIsSuccesfull() throws Exception {

        DataHandler.getInstance().getNumberHandler().getMath(42, new ServiceListener<NumberFact>() {
            @Override
            public void onResponse(NumberFact response) {
                assertNotNull(response.getText());
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}