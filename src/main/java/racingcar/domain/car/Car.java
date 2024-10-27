package racingcar.domain.car;

public class Car {
    private final Name name;
    private final Distance distance;

    private Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car of(String name) {
        return new Car(
                Name.of(name),
                Distance.zero()
        );
    }

    public Car move(Distance newDistance) {
        return new Car(name, newDistance);
    }

    public boolean hasSamePosition(int distance) {
        return Integer.valueOf(distance).equals(this.distance.getValue());
    }

    public int getDistance() {
        return this.distance.getValue();
    }


}
