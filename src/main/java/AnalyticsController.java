import java.util.List;

public class AnalyticsController {

    List<Long> getInteractionTimes(Attempt attempt) {
      InteractionTimesService interactionTimesService = new InteractionTimesService();

      return interactionTimesService.getInteractionTimes(attempt);
    }
}
