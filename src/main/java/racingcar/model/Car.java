package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private final String name;
    public Car(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        this.name = name;
    }
}
