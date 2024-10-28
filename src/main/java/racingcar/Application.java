package racingcar;

public class Application {
    public static void main(String[] args) {
        String cars = InputConsole.inputCarNames();
        String tryTimesString = InputConsole.inputTryTimes();
        InputConsole.resultGide();

        RacingCar racingCar = new RacingCar();
        racingCar.start(cars, tryTimesString);
    }
}
