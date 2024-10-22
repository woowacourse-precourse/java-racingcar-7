package racingcar.racingcar.domain;

import java.util.Objects;

public class RacingCar {
    private final Name name;
    private RacingCar(Name name) {
        this.name = name;
    }
    public static RacingCar of(String name) {
        return new RacingCar(
                new Name(name)
        );
    }
    @Override
    public String toString() {
        return name.toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof RacingCar that) {
            return this.name.equals(that.name);
        }
        return false;
    }
}
