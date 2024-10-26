package racingcar.car;

public class CarImpl implements Car{
    private final String carName;
    public CarImpl(String carName) {
        this.carName = carName;
    }

    @Override
    public void move(int randomNumber) {

    }

    @Override
    public String getCarName() {
        return carName;
    }

    @Override
    public int getPosition() {
        return 0;
    }
}
