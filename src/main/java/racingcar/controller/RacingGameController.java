package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();

    public void start() {
        String carNamesInput = InputView.getCarNames();
        List<Car> cars = racingGameService.createCars(carNamesInput);

        String moveCountInput = InputView.getMoveCount();
        int moveCount = racingGameService.parseMoveCount(moveCountInput);

        racingGameService.startRace(cars, moveCount);

        List<Car> winners = racingGameService.findWinners(cars);
        printWinners(winners);
    }

    private void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }
}
