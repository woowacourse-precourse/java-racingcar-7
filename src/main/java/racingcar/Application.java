package racingcar;

public class Application {
    public static void main(String[] args) {
        String inputCarName = Input.inputCarName();
        String inputTrialNumber = Input.inputTrialNumber();
        RacingCar racingCar = new RacingCar(inputCarName, inputTrialNumber);
        racingCar.run();
    }
}
