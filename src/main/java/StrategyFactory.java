public class StrategyFactory {

    public IStrategy get(String type) {

        if (type.equals("mode1"))
            return new StrategyModeOne();
        else if (type.equals("mode2"))
            return new StrategyModeTwo();
        else if (type.equals("mode3")) {
            IStrategy filteredStrategy = new StrategyModeTwo();
            return new StrategyModeThree(filteredStrategy);
        }
        return null;

    }
}