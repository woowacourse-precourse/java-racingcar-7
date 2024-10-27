package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int distance = 0;
    static final String SYMBOL = "-";

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 5글자 이상입니다.");
        }
        this.name = name;
    }

    public void drive() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            distance += 1;
        }
    }

}
