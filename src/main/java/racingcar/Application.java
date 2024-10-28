package racingcar;

import static racingcar.RacingConstants.INITIAL_MOVE_COUNT;
import static racingcar.RacingConstants.MAX_NUMBER_IN_RANGE;
import static racingcar.RacingConstants.MIN_NUMBER_IN_RANGE;
import static racingcar.RacingConstants.MIN_NUMBER_TO_MOVE;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        InputController inputController = new InputController(inputValidator);
        OutputView outputView = new OutputView();
        RacingRule racingRule = new RacingRule(MIN_NUMBER_IN_RANGE, MAX_NUMBER_IN_RANGE, MIN_NUMBER_TO_MOVE);
        Racers racers;
        int totalAttempts;
        Racing racing;

        String inputNames = inputView.requestCarNames();
        List<String> carNames = inputController.extractCarNames(inputNames);
        racers = new Racers(carNames.stream().map(name -> new Car(name, INITIAL_MOVE_COUNT)).toList());

        String inputAttempts = inputView.requestTotalAttempts();
        totalAttempts = inputController.convertToNumber(inputAttempts);

        racing = new Racing(racers, racingRule, outputView, totalAttempts);
        racing.race();
        racing.announceWinners();
    }
}
