package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Model model = new Model();

        String carNameInput = inputView.inputCarNamesString();
        List<String> carNames = model.getCarNames(carNameInput);
        Validator.validateCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        String attemptCountInput = inputView.inputAttemptCount();
        Validator.validateAttemptCount(attemptCountInput);
        int attemptCount = Integer.parseInt(attemptCountInput);

        RacingGame racingGame = new RacingGame();
        for (int i = 0; i < attemptCount; i++) {
            racingGame.playRace(cars);
            ResultView.printRaceResult(cars);
        }

        List<Car> winners = Winners.findWinner(cars);
        ResultView.printWinners(winners);
    }
}
