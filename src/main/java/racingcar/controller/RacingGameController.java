package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.controller.dto.RaceRoundResultDTO;
import racingcar.model.Car;
import racingcar.model.policy.RandomMoveCondition;
import racingcar.model.RacingGame;
import racingcar.model.policy.CarMovePolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        List<Car> cars = parseCar(inputCarNames());
        int tryCount = inputTryCount();
        inputView.closeConsole();
        RacingGame racingGame = new RacingGame(
                new CarMovePolicy(new RandomMoveCondition()),
                tryCount
        );
        racingGame.join(cars);
        playRounds(racingGame, tryCount);
        printWinners(racingGame);
    }

    public void playRounds(RacingGame racingGame, int tryCount) {
        outputView.printResultTitle();
        IntStream.range(0, tryCount).forEach(i -> {
            racingGame.tryRound();
            List<Car> cars = racingGame.getCurrentCarState();
            outputView.printRoundResult(RaceRoundResultDTO.from(cars));
        });
    }

    private void printWinners(RacingGame racingGame) {
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
        outputView.requestTotalTryRound();
        try {
            return Integer.parseInt(inputView.readTryCount());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해주세요.");
        }
    }

    public List<Car> parseCar(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .toList();
    }
}
