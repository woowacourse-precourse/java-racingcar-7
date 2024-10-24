package racingcar.domain.car;

public class CarInfo {
    private final String name;
    private final int currentPosition;

    public CarInfo(Name name, Position currentPosition) {
        this.name = name.getName();
        this.currentPosition = currentPosition.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
