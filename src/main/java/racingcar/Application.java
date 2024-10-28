package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        String carNamesInput = InputView.getCarNames();
        RaceController raceController = new RaceController();
        List<String> carNames = raceController.parseAndValidateCarNames(carNamesInput);

        int attempts = InputView.getAttempts();

        raceController.startRace(attempts);

    }
}
