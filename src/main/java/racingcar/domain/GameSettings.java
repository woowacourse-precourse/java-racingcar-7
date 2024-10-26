package racingcar.domain;
import java.util.List;
public class GameSettings {
    private final List<String> carName;
    private final int attemptCount;

    public GameSettings(List<String> carName, int attemptCount) {
        this.carName = carName;
        this.attemptCount = attemptCount;
    }
    public List<String> getCarName() {
        return carName;
    }
    public int getAttemptCount() {
        return attemptCount;
    }

}
