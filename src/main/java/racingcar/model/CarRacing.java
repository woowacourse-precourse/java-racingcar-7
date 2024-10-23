package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacing {
    private final List<Car> carList = new ArrayList<>();
    private final List<Round> roundList = new ArrayList<>();
    private final InputView inputView;
    private final OutputView outputView;

    public CarRacing(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        enrollCars();
        startRounds();
        printWinner();
    }

    private void enrollCars() {
        List<String> carNameList = inputView.inputCarNames();

        carNameList.forEach(name -> {
            carList.add(Car.of(name));
        });
    }

    private void startRounds() {
        int trialCount = inputView.inputTrialCount();

        System.out.println("\n실행 결과");
        for (int round = 0; round < trialCount; round++) {
            carList.forEach(Car::moveIfPossible);
            roundList.add(Round.of(carList));
        }
    }

    private void printWinner() {
        int maxValue = Integer.MIN_VALUE;
        List<Car> winners = new ArrayList<>();

        for (Car car : carList) {
            int position = car.getPosition();

            if (position > maxValue) {
                maxValue = position;
            }
        }

        for (Car car : carList) {
            int position = car.getPosition();

            if (position == maxValue) {
                winners.add(car);
            }
        }

        outputView.printWinners(winners);
    }
}
