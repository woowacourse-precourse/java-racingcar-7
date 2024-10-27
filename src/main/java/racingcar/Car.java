package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private int forwardCount;

    public Car(String carName) {
        this.carName = validateName(carName);
        this.forwardCount = 0;
    }

    private String validateName(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("이름은 null이 될 수 없습니다.");
        }
        String trimmedName = carName.trim();
        if (trimmedName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        return trimmedName;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            forwardCount += 1;
        }
    }
}
