package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;


    public Car(String name) {
        this.name = name;
        validateCarName();
        this.position = 0;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position += 1;
        }
    }

    void validateCarName() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요. 공백이나 빈 문자열은 허용하지 않습니다.");
        }
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
