package racingcar.Model;

public class Car {
    private String carName;

    public Car(String carName) {
        lengthValidation(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void lengthValidation(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException();
        }
        else if (carName.length() < Rule.MIN_LENGTH.value() || carName.length() > Rule.MAX_LENGTH.value()) {
            throw new IllegalArgumentException();
        }
    }
}
