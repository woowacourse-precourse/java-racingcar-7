package racingcar.model;

import racingcar.exception.UserErrorMessage;

/*
* 자동차 모델을 정의하는 클래스
 */
public class LacingCar {

    private final String carName;

    public LacingCar(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public boolean validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_BLANK);
        } else if (carName.length() > 5) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_LENGTH);
        } else {
            return true;
        }
    }

}
