import java.util.List;

public interface IStrategy {
    
    public List<Long> getInteractionTimes(Attempt attempt);
}