package racingcar.domain.car;

public class CarInfo {
    private final String name;
    private final int currentPosition;

    public CarInfo(CarName carName, CarPosition currentCarPosition) {
        this.name = carName.getName();
        this.currentPosition = currentCarPosition.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
