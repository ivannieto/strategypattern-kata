import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnalyticsControllerTest {

    @Test
    public void shouldReturnTheInteractionTimesOfAnAttempt() {

        List<Date> times = new ArrayList<Date>();

        long it1 = 200;
        long it2 = 300;
        List<Long> expectedIts = new ArrayList<>();
        expectedIts.add(it1);
        expectedIts.add(it2);

        Date d1 = new Date();
        Date d2 = new Date(d1.getTime() + it1);
        Date d3 = new Date(d2.getTime() + it2);
        times.add(d1);
        times.add(d2);
        times.add(d3);

        Attempt attempt = new Attempt(times);
        AnalyticsController controller = new AnalyticsController();
        List<Long> actualIts = controller.getInteractionTimes(attempt, "mode1");

        Assert.assertEquals(expectedIts, actualIts);
    }
}
