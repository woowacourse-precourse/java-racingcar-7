package racingcar.model;

import racingcar.exception.UserErrorMessage;

/*
* 자동차 모델을 정의하는 클래스
 */
public class RacingCar {

    private final String carName;
    private int resultToMove;

    public RacingCar(String carName) {
        this.carName = carName;
        this.resultToMove = 0;
    }

    public String getCarName() {
        return carName;
    }

    public static String validateCarNames(String carNames) { // 자동차 이름 입력 확인
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_BLANK);
        } else {
            return carNames;
        }
    }

    public static void validateCarName(String carName) { // 각각의 자동차 이름 조건 확인
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_BLANK);
        } else if (carName.length() > 5) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_LENGTH);
        }
    }

    public int getResultToMove() {
        return resultToMove;
    }

    public void plusResultToMove() {
        resultToMove += 1;
    }

}
