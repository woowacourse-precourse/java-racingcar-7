package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        List<String> carNames = inputView.readCarNames();
        int number = inputView.readNumber();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Racing racing = new Racing();
        OutputView outputView = new OutputView();
        for (int i = 0; i < number; i++) {
            racing.runRace(cars);
            outputView.printRoundStatus(cars);
        }

        outputView.printFinalWinners(racing.getWinners(cars));
    }
}
