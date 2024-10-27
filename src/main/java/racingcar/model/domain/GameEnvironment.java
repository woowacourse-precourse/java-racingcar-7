package racingcar.model.domain;

public class GameEnvironment {

    private Integer attemptCount;

    public Integer getAttemptCount() {
        return attemptCount;
    }

    public void modifyAttemptCount(Integer attemptCount) {
        this.attemptCount = attemptCount;
    }
}
