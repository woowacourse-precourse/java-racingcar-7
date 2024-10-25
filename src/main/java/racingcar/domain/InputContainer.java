package racingcar.domain;

public class InputContainer {

    private String cars;
    private int attempts;

    public InputContainer(String cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public String getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }
}
