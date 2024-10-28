package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateEmptyName(name);
        validateLength(name);
        this.name = name;
        this.position = 0;
    }

    public Car forward() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            position++;
        }
        return this;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 5자리 이하 입니다");
        }
    }

    private void validateEmptyName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 문자열일 수 없습니다");
        }
    }
}
