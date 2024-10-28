package racingcar.model;

public class CarState {

    private final String name;
    private final int position;

    public CarState(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}