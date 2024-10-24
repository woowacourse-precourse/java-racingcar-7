package racingcar.controller;

import java.util.List;
import racingcar.service.RacingGameService;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void startGame() {
        List<Car> cars = createCars();

        int moveCount = inputView.getMoveCount();
        runRace(moveCount, cars);

        announceWinners(cars);
    }

    private List<Car> createCars() {
        List<String> carNames = inputView.getCarNames();
        return carNames.stream()
                .map(Car::of)
                .toList();
    }

    private void runRace(int moveCount, List<Car> cars) {
        outputView.printLine();
        outputView.printResultMessage();

        for (int i = 0; i < moveCount; i++) {
            raceCars(cars);
            System.out.println();
        }
    }

    private void raceCars(List<Car> cars) {
        for (Car car : cars) {
            racingGameService.race(car);
            int currentDistance = racingGameService.getCurrentDistance(car);
            outputView.printCurrentDistance(car.getName(), currentDistance);
        }
    }

    private void announceWinners(List<Car> cars) {
        List<String> winners = racingGameService.getWinners(cars);
        outputView.printWinners(winners);
    }
}
