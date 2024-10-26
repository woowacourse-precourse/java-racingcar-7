package racingcar.domain;


import java.util.Objects;

import static racingcar.domain.StringConstant.*;

public class Car {

    public static final int THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        validName(name);
        this.name = name;
        this.position = 0;
    }

    private void validName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 등록 해야합니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("앞 뒤 공백 제외 1글자 이상, 5글자 이하의 자동차 이름을 입력해주세요.");
        }
    }

    public void moveForwardIfDigitAboveThreshold(int digit) {
        if (digit < THRESHOLD) {
            return;
        }
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public void printPosition() {
        System.out.printf("%s : %s", name, POSITION_MARK.getValue().repeat(position));
        System.out.println();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}