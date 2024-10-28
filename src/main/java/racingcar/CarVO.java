package racingcar;

public class CarVO {
    private final String carName;
    private int position;

    public CarVO(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
