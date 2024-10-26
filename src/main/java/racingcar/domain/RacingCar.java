package racingcar.domain;

public class RacingCar {
    private final String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void executeForward(MovementPolicy policy, RaceProgressManager progressManager) {
        if (policy.shouldMove()) {
            progressManager.updateProgressForForward(this);
        }
    }
}
