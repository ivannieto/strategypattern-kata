import java.util.List;

public class AnalyticsController {


    List<Long> getInteractionTimes(Attempt attempt, String type) {
      InteractionTimesService interactionTimesService = new InteractionTimesService();
      StrategyFactory strategyFactory = new StrategyFactory();
      IStrategy strategy = strategyFactory.get(type);
      
      return interactionTimesService.getInteractionTimes(attempt, strategy);
    }
}
