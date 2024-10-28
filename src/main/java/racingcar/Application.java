package racingcar;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        validateCarNames(carNames);

        int attempts = InputView.getAttempts();

        RacingGame game = new RacingGame(carNames, attempts);
        game.play();
    }

    private static void validateCarNames(List<String> carNames) {
        carNames.forEach(Car::validateName);
    }
}
