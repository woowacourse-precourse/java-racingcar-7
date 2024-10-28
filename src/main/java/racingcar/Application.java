package racingcar;

public class Application {
    public static void main(String[] args) {
        Car[] cars = Initialize.initializeCars();
        int attemptCount = Initialize.initializeAttemptCount();

        ValidateValue.validateValue(cars, attemptCount);

        Racing.start(cars, attemptCount);
    }
}
