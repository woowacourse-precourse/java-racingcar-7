package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Model model = new Model();

        String carNameInput = inputView.inputCarNamesString();
        List<String> carNames = model.getCarNames(carNameInput);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        String attemptCountInput = inputView.inputAttemptCount();
        model.validateAttemptCount(attemptCountInput);
        int attemptCount = Integer.parseInt(attemptCountInput);

        RacingGame racingGame = new RacingGame();
        racingGame.playRace(cars, attemptCount);

        List<Car> winners = Winners.findwinner(cars);
    }
}
