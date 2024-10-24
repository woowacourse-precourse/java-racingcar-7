package racingcar.domain.car;

import java.util.Objects;

public class CarName {

    private final String carName;
    public final int NAME_THRESHOLD = 5;

    public CarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 " + NAME_THRESHOLD + "글자를 초과했습니다.");
        }
        this.carName = name;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carName);
    }
}
