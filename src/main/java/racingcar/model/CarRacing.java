package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacing {
    private final List<Car> carList = new ArrayList<>();
    private final InputView inputView;
    private final OutputView outputView;

    public CarRacing(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<String> carNameList = inputView.inputCarNames();
        int trialCount = inputView.inputTrialCount();

        carNameList.forEach(this::enroll);
        startRounds(trialCount);
        printWinner();
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

    private void startRounds(int trialCount) {
        System.out.println("\n실행 결과");

        for (int round = 0; round < trialCount; round++) {
            carList.forEach(Car::moveIfPossible);
            outputView.printLeaderBoard(carList);
        }
    }

    private void enroll(String name) {
        carList.add(Car.of(name));
    }
}
