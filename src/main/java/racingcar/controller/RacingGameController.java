package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.controller.dto.RaceResultDTO;
import racingcar.model.Car;
import racingcar.model.DefaultRandomNumberGenerator;
import racingcar.model.RacingGame;
import racingcar.model.policy.RandomForwardMovementPolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        String carNames = inputCarNames();
        List<String> parsedCarNames = parseCarNames(carNames);
        int tryCount = inputTryCount();
        RacingGame racingGame = new RacingGame(
                new RandomForwardMovementPolicy(new DefaultRandomNumberGenerator()),
                tryCount
        );
        parsedCarNames.forEach(carName -> {
            Car car = new Car(carName, racingGame.getCarId());
            racingGame.join(car);
        });
        outputView.printResultTitle();
        IntStream.range(0, tryCount).forEach(i -> {
            racingGame.playRound();
            List<Car> cars = racingGame.getCurrentCarState();
            outputView.printRoundResult(RaceResultDTO.from(cars));
        });
        List<String> winnerNames = racingGame.getWinners().stream()
                .map(Car::getName)
                .toList();
        outputView.printWinnerNames(winnerNames);
    }

    public String inputCarNames() {
        outputView.requestCarNames();
        return inputView.readCarNames();
    }

    public int inputTryCount() {
        outputView.requestTotalRound();
        try {
            return Integer.parseInt(inputView.readTotalRound());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해주세요.");
        }
    }

    public List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
