package racingcar;

import static racingcar.RacingConstants.CAR_START_POSITION;
import static racingcar.RacingConstants.MAX_NUMBER;
import static racingcar.RacingConstants.MIN_NUMBER;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new NumberGenerator(MIN_NUMBER, MAX_NUMBER);
        NumberValidator numberValidator = new NumberValidator();
        List<Car> cars;
        int totalAttempts;
        Move move;
        Racing racing;

        String input = inputView.requestCarNames();
        inputValidator.validateCompetitor(input);
        cars = Arrays.stream(input.split(",")).map(name -> new Car(name, CAR_START_POSITION)).toList();
        totalAttempts = Integer.parseInt(inputView.requestTotalAttempts());
        move = new Move(cars, numberValidator, numberGenerator);
        racing = new Racing(cars, totalAttempts, move, outputView);
        racing.race();
        racing.announceWinners();
    }
}
