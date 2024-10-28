package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNames = InputView.readCarNames();
        int raceCount = InputView.readNumber();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Racing racing = new Racing(cars);
        for (int i = 0; i < raceCount; i++) {
            racing.runSingleRound();
            OutputView.printRoundStatus(cars);
        }

        OutputView.printFinalWinners(racing.getWinners());
    }
}
