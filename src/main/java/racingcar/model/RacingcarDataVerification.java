package racingcar.model;

import racingcar.constant.ErrorMessage;

public class RacingcarDataVerification {
    public void validateRacingCarNames(String[] racingCarList) {
        for (String RacingCar : racingCarList) {
            validateRacingCarNameLength(RacingCar);
            validateRacingCarNameNone(RacingCar);
        }
    }

    private void validateRacingCarNameLength(String racingCarName) {
        if (racingCarName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.OVER_CAR_NAME.getMessage());
        }
    }

    private void validateRacingCarNameNone(String racingCarName) {
        if (racingCarName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NONE_CAR_NAME.getMessage());
        }
    }
}
