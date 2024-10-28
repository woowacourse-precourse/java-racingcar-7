package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.CarNameEmptyException;
import racingcar.exception.CarNameOverMaxLengthException;

public class RacingCar {

    public static final int MOVE_FORWARD_THRESHOLD = 4;

    private String name;
    private int distanceCovered;

    public RacingCar(String name) {
        Validator.validateName(name);
        this.name = name;
        this.distanceCovered = 0;
    }

    public RacingCar(String name, int distanceCovered) {
        Validator.validateName(name);
        this.name = name;
        this.distanceCovered = distanceCovered;
    }

    public void tryMoveForward() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_FORWARD_THRESHOLD) {
            moveForward();
        }
    }

    private void moveForward() {
        distanceCovered++;
    }

    public String getName() {
        return name;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    private static class Validator {

        private static final int MAX_NAME_LENGTH = 5;

        public static void validateName(String name) {
            validateNameEmpty(name);
            validateNameLength(name);
        }

        private static void validateNameEmpty(String name) {
            if (name.isEmpty()) {
                throw new CarNameEmptyException();
            }
        }

        private static void validateNameLength(String name) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new CarNameOverMaxLengthException(name);
            }
        }
    }
}
