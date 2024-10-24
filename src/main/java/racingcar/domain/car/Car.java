package racingcar.domain.car;


import java.util.Map;
import java.util.Objects;

public class Car {
    private final Name name;
    private final Position currentPosition;

    public Car(String name) {
        this.name = new Name(name);
        this.currentPosition = new Position();
    }

    public void accelerator() {
        currentPosition.addPosition();
    }

    public boolean isAheadOf(Integer otherCarPosition) {
        return currentPosition.isGreaterThan(otherCarPosition);
    }

    public Map<String, Integer> getCarInfo() {
        return Map.of(name.getName(), currentPosition.getCurrentPosition());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
