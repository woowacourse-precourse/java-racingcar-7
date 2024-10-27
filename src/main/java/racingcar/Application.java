package racingcar;

import static racingcar.RacingConstants.INITIAL_MOVE_COUNT;
import static racingcar.RacingConstants.MAX_NUMBER_IN_RANGE;
import static racingcar.RacingConstants.MIN_NUMBER_IN_RANGE;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        InputController inputController = new InputController(inputValidator);
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new NumberGenerator(MIN_NUMBER_IN_RANGE, MAX_NUMBER_IN_RANGE);
        List<Car> cars;
        int totalAttempts;
        Move move;
        Racing racing;

        String inputNames = inputView.requestCarNames();
        List<String> carNames = inputController.extractCarNames(inputNames);
        cars = carNames.stream().map(name -> new Car(name, INITIAL_MOVE_COUNT)).toList();

        String inputAttempts = inputView.requestTotalAttempts();
        totalAttempts = inputController.convertToNumber(inputAttempts);

        move = new Move(cars, numberGenerator);
        racing = new Racing(cars, totalAttempts, move, outputView);
        racing.race();
        racing.announceWinners();
    }
}
