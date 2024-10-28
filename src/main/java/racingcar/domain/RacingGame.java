package racingcar.domain;

import java.util.List;
import racingcar.utils.RandomNumber;
import racingcar.views.OutputView;

public class RacingGame {
    private final CarList carList;

    public RacingGame(CarList carList) {
        this.carList = carList;
    }

    public void play(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            tryToMoveCars();
            printCurrentPositions();
        }
        printWinners();
    }

    private void tryToMoveCars() {
        for (Car car : carList.getCarList()) {
            car.tryToMove(RandomNumber.generate());
        }
    }

    private void printCurrentPositions() {
        List<Car> cars = carList.getCarList();
        for (Car car : carList.getCarList()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printWinners() {
        List<Car> cars = carList.getCarList();
        String winners = WinnerFinder.calculateWinners(cars);
        OutputView.printResult(winners);
    }
}
