package racingcar.model;

public class RacePolicy {
    private static final int CAR_MOVEMENT_THRESHOLD = 4;

    public boolean canMoveForward(int randomNumber) {
        return randomNumber >= CAR_MOVEMENT_THRESHOLD;
    }
}
