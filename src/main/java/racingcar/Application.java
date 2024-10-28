package racingcar;

public class Application {
    public static void main(String[] args) {

        String carNamesInput = InputView.getCarNames();
        RaceController raceController = new RaceController();
        raceController.parseAndValidateCarNames(carNamesInput);

        int attempts = InputView.getAttempts();

        raceController.startRace(attempts);
    }
}
