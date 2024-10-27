package racingcar;

import static racingcar.RacingConstants.CAR_START_POSITION;
import static racingcar.RacingConstants.MAX_NUMBER;
import static racingcar.RacingConstants.MIN_NUMBER;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        InputController inputController = new InputController(inputValidator);
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new NumberGenerator(MIN_NUMBER, MAX_NUMBER);
        NumberValidator numberValidator = new NumberValidator();
        List<Car> cars;
        int totalAttempts;
        Move move;
        Racing racing;

        String inputNames = inputView.requestCarNames();
        List<String> carNames = inputController.extractCarNames(inputNames);
        cars = carNames.stream().map(name -> new Car(name, CAR_START_POSITION)).toList();

        String inputAttempts = inputView.requestTotalAttempts();
        totalAttempts = inputController.convertToNumber(inputAttempts);

        move = new Move(cars, numberValidator, numberGenerator);
        racing = new Racing(cars, totalAttempts, move, outputView);
        racing.race();
        racing.announceWinners();
    }
}
