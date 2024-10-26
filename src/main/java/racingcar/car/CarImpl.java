package racingcar.car;

public class CarImpl implements Car{
    private final String carName;
    public CarImpl(String carName) {
        this.carName = carName;
        carNameValidation();
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

    private void carNameValidation() {
        if (carName.length() > 5 || carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
}
