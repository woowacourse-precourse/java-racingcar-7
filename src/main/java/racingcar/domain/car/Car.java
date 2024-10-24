package racingcar.domain.car;


import java.util.Map;

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
}
