package racingcar.domain;

import static racingcar.exception.ErrorMessage.*;

import racingcar.exception.RacingCarException;

public class RacingCar {
    private final String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void executeForward(MovementPolicy policy, RaceProgressManager manager) {
        validateNonNullDependencies(policy, manager);
        if (policy.shouldMove()) {
            manager.updateProgressForForward(this);
        }
    }

    private void validateNonNullDependencies(MovementPolicy policy, RaceProgressManager manager) {
        validateNonNullPolicy(policy);
        validateNonNullManager(manager);
    }

    private void validateNonNullPolicy(MovementPolicy policy) {
        if (policy == null) {
            throw RacingCarException.from(MOVEMENT_POLICY_NULL);
        }
    }

    private void validateNonNullManager(RaceProgressManager manager) {
        if (manager == null) {
            throw RacingCarException.from(RACE_PROGRESS_MANAGER_NULL);
        }
    }
}
