package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;
import java.util.function.Supplier;

public class Car {
    private Integer position;
    private final String name;
    private final Supplier<Integer> randomSupplier;

    public Car(String name) {
        this(name, ()-> Randoms.pickNumberInRange(0, 9));
    }

    public Car(String name, Supplier<Integer> randomSupplier) {
        validateCarNameLength(name);
        this.name = name;
        this.position = 0;
        this.randomSupplier = randomSupplier;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name has to be 5 or under 5.");
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void moveIfPossible() {
        if (randomSupplier.get() >= 4) {
            goForward();
        }
    }

    public void goForward() {
        position++;
    }

    /**
     * 객체의 문자열 표현을 반환합니다.
     * 이 표현은 객체의 이름과 함께 현재 위치에 해당하는
     * 대시('-')로 구성된 문자열을 포함합니다.
     *
     * @return 이름과 현재 위치에 따라 결정된 대시가 포함된
     *         형식 "이름 : ----" 형태의 문자열을 반환합니다.
     */
    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
