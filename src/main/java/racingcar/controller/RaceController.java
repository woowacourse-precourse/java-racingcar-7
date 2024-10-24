package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class RaceController {

    private final InputView inputView;

    public RaceController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String userInput = inputView.CarNamesInput();
        int attemptsNum = inputView.attemptsNumInput();

        List<Car> cars = new ArrayList<>();
        for (String carName : userInput.split(",")) {
            cars.add(Car.from(carName));
        }

        System.out.println("실행 결과");
        for (int cnt = 0; cnt < attemptsNum; cnt++) {
            forwardWithRandomCondition(cars);
            outputStatus(cars);
        }

        int maxStatus = findMaxStatus(cars);
        List<String> winnersName = findWinners(cars, maxStatus);
        outputWinners(winnersName);
    }

    private void outputWinners(List<String> winnersName) {
        String result = String.join(", ", winnersName);
        System.out.println("최종 우승자 : " + result);
    }

    private List<String> findWinners(List<Car> cars, int maxStatus) {
        List<String> winnersName = new ArrayList<>();
        for (Car car : cars) {
            if (maxStatus == car.status()) {
                winnersName.add(car.name());
            }
        }
        return winnersName;
    }

    private int findMaxStatus(List<Car> cars) {
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

    private void outputStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.name() + " : ");
            for (int j = 0; j < car.status(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
