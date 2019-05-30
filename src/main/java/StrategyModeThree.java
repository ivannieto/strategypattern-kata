import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StrategyModeThree implements IStrategy {
    private IStrategy prevStrategy;

    public StrategyModeThree(IStrategy prevStrategy) {
        this.prevStrategy = prevStrategy;
    }

    // the array double[] m MUST BE SORTED
    public static double median(List<Long> m) {
        int middle = m.size() / 2;
        if (m.size() % 2 == 1) {
            return m.get(middle);
        } else {
            return (m.get(middle-1) + m.get(middle)) / 2.0;
        }
    }

    @Override
    public List<Long> getInteractionTimes(Attempt attempt) {

        List<Long> filteredIT = this.prevStrategy.getInteractionTimes(attempt);
        double median = median(filteredIT);

        List<Long> expectedIts = new ArrayList<>();
        for (Long IT : filteredIT) {

            if (IT < median * 0.9)
                expectedIts.add(IT);
            if (IT > median * -0.9)
                expectedIts.add(IT);
        }
        return expectedIts;
    }

}