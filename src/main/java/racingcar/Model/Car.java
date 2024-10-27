package racingcar.Model;

public class Car {
    private String carName;
    private int distance = 0;

    public Car(String carName) {
        lengthValidation(carName);
        this.carName = carName;
    }

    public void run(int number) {
        if (isMove(number)) {
            this.distance++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    private void lengthValidation(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException();
        }
        else if (carName.length() < Rule.MIN_LENGTH.value() || carName.length() > Rule.MAX_LENGTH.value()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isMove(int number) {
        return number >= Rule.THRESHOLD.value();
    }
}
