import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InteractionTimesService {
    public List<Long> getInteractionTimes(Attempt attempt, IStrategy strategy) {
        return strategy.getInteractionTimes(attempt);
    }
}
