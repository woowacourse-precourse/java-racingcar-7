package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.enums.Delimiter;
import racingcar.enums.ViewMessage;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void play() {
        List<Car> cars = prepareCars();
        int rounds = inputRounds();
        int maxMoveCount = startRace(cars, rounds);
        printWinners(cars, maxMoveCount);
    }

    private List<Car> prepareCars() {
        String inputString = inputView.promptCarNames();
        return racingCarService.makeCarList(inputString);
    }

    private int inputRounds() {
        return Integer.parseInt(inputView.promptRounds());
    }

    private int startRace(List<Car> cars, int rounds) {
        outputView.printResult();
        int maxMoveCount = 0;
        while (rounds-- > 0) {
            maxMoveCount = runRace(cars, maxMoveCount);
        }
        return maxMoveCount;
    }

    private int runRace(List<Car> cars, int maxMoveCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            car.move();
            maxMoveCount = Math.max(maxMoveCount, car.moveCount);
            stringBuilder.append(car).append(ViewMessage.PRINT_BLANK.getMessage());
        }
        outputView.printRoundStatus(stringBuilder.toString());
        return maxMoveCount;
    }

    private void printWinners(List<Car> cars, int maxMoveCount) {
        List<String> winners = racingCarService.findWinners(cars, maxMoveCount);
        String result = String.join(Delimiter.COMMA_WITH_SPACE.getSymbol(), winners);
        outputView.printWinners(result);
    }
}
