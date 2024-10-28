package racingcar.model;

import racingcar.exception.UserErrorMessage;

/*
* 자동차 모델을 정의하는 클래스
 */
public class LacingCar {

    private final String carName;
    private int resultToMove;

    public LacingCar(String carName) {
        this.carName = carName;
        this.resultToMove = 0;
    }

    public String getCarName() {
        return carName;
    }

    public static String validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_BLANK);
        } else if (carName.length() > 5) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_LENGTH);
        } else {
            return carName;
        }
    }

    public int getResultToMove() {
        return resultToMove;
    }

    public void plusResultToMove() {
        resultToMove += 1;
    }

}
