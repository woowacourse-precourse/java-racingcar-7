package racingcar.domain;

public class Car {

    private static final int FORWARD_NUMBER_LIMIT = 4;

    private final CarName name;
    private Integer distance;

    public Car(final String name) {
        this.name = new CarName(name);
        this.distance = 0;
    }

    public void forward(final int randomNumber) {
        if (randomNumber >= FORWARD_NUMBER_LIMIT) {
            distance++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public Integer getDistance() {
        return distance;
    }
}
