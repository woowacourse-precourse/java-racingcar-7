package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.service.Service;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;

    public Controller(final InputView inputView, final OutputView outputView,
                      final Service service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public String inputCarNames() {
        return inputView.getCarNames();
    }

    public int inputAttemptCount() {
        return inputView.getAttemptCount();
    }

    public void printRoundResult(final Race race) {
        outputView.printEndLine();
        outputView.printGameResultMessage();
        race.getCarList().forEach(outputView::printRoundResult);
        outputView.printEndLine();
    }

    public List<String> getCarNames(final String carNames) {
        return service.splitCarNames(carNames);
    }

    public void printWinner(final Car car) {
        outputView.printWinner(car);
    }

    public List<Car> registerCar(final List<String> carNames) {
        return service.registerCar(carNames);
    }

    public void printWinners(final List<Car> winnerList) {
        outputView.printWinners(winnerList);
    }

    public void playGame(final Race race) {
        IntStream.range(0, race.getAttemptCount()).forEach(attemptCount -> {
            service.playRound(race);
            printRoundResult(race);
        });
    }

    public List<Car> getWinnerCarList(final Race race) {
        List<Car> carList = race.getCarList();
        int maxDistance = getMaxDistance(race);

        return service.getCarListWithMaxDistance(carList, maxDistance);
    }

    private int getMaxDistance(final Race race) {
        List<Integer> distanceList = race.getDistanceList();
        return service.getMaxDistance(distanceList);
    }
}
