package controller;

import static racingcar.Car.createDefaultCar;

import java.util.ArrayList;
import java.util.List;
import racingcar.Car;
import racingcar.Racing;
import util.RandomGenerator;
import view.InputView;
import view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Racing racing = createRacing();
        playAllRacing(racing, inputView.inputAttemptCount());
        printWinner(racing);
    }

    private Racing createRacing() {
        String carNames = inputView.inputCarNames();
        List<Car> cars = makeCars(carNames);
        return new Racing(cars);
    }

    private void playAllRacing(Racing racing, int attemptCount) {
        outputView.printf("%n실행 결과%n");
        for (int i = 0; i < attemptCount; i++) {
            racing.playRacing();
            outputView.printRacing(racing.racingInfo());
        }
    }

    private void printWinner(Racing racing) {
        outputView.finalWinners(racing.findWinners());
    }

    private List<Car> makeCars(String inputCarNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            cars.add(createDefaultCar(carName, new RandomGenerator()));
        }
        return cars;
    }
}
