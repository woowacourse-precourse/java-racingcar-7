package racingcar.model;

public class Car {
    private String[] carNames;

    public Car(String input) {
        this.carNames = setCarName(input);
    }

    private String[] setCarName(String input) {
        return carNames = input.split(",");
    }

    public String[] getCarNames() {
        return carNames;
    }
}