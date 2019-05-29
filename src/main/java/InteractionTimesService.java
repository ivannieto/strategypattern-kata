import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InteractionTimesService {
    public List<Long> getInteractionTimes(Attempt attempt) {
        List<Long> expectedIts = new ArrayList<>();

        for (int i = 1; i < attempt.dates.size(); i++) {
            Date date1 = attempt.dates.get(i);
            Date date2 = attempt.dates.get(i - 1);
            expectedIts.add(date1.getTime() - date2.getTime());
        }

        return  expectedIts;
    }
}
