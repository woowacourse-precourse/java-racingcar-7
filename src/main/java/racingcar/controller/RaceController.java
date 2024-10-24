package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String userInput = inputView.CarNamesInput();
        int attemptsNum = inputView.attemptsNumInput();

        List<Car> cars = new ArrayList<>();
        for (String carName : userInput.split(",")) {
            cars.add(Car.from(carName));
        }

        outputView.showExecuteMessage();
        for (int cnt = 0; cnt < attemptsNum; cnt++) {
            forwardWithRandomCondition(cars);
            outputView.showStatus(cars);
        }

        List<String> winnersName = findWinners(cars);
        outputView.showWinners(winnersName);
    }



    private List<String> findWinners(List<Car> cars) {
        int maxStatus = findMaxProgress(cars);
        List<String> winnersName = new ArrayList<>();
        for (Car car : cars) {
            if (maxStatus == car.status()) {
                winnersName.add(car.name());
            }
        }
        return winnersName;
    }

    private int findMaxProgress(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.status(), max);
        }
        return max;
    }

    private void forwardWithRandomCondition(List<Car> cars) {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                car.forward();
            }
        }
    }
}
