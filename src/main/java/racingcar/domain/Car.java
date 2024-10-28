package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.ErrorMessage;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    // 0~9의 랜덤 정수를 생성하고 4 이상이면 전진
    public void drive() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.distance++;
        }
    }
    // 입력받은 이름이 5글자 이상인지, 비어있는 값인지 판별
    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_FIVE.getMessage());
        }
         if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_EMPTY.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
