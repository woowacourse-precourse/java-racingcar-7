package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private int score = 0;

    private Car(String carName) {
        this.carName = carName;
    }

    public static Car createCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        return new Car(carName);
    }

    public int proceed() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            score += 1;
        }
        return score;
    }

    public String getCarName() {
        return carName;
    }

    public int getScore() {
        return score;
    }
}
