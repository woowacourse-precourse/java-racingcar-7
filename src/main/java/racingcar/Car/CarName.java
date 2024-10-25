package racingcar.Car;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateNaming(carName);
        this.carName = carName;
    }

    public String getValue() {
        return carName;
    }

    private void validateNaming(String carName) {
        if(carName == null || carName.isEmpty() || carName.length() >5) {
            throw new IllegalArgumentException();
        }
    }

}