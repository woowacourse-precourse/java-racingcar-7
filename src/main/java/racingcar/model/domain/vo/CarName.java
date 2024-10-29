package racingcar.model.domain.vo;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (this.name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 1자 이상이여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CarName carName = (CarName) o;

        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
