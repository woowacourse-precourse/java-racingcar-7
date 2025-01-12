package controller;

import static racingcar.Car.createDefaultCar;

import exception.CustomIllegalArgException;
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
        try {
            Racing racing = createRacing();
            playAllRacing(racing, validCount(inputView.inputAttemptCount()));
            printWinner(racing);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private Racing createRacing() throws CustomIllegalArgException {
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

    private List<Car> makeCars(String inputCarNames) throws CustomIllegalArgException {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            cars.add(createDefaultCar(carName, new RandomGenerator()));
        }
        return cars;
    }

    private int validCount(String inputCount) {
        try {
            int attemptCount = Integer.parseInt(inputCount);
            if (attemptCount < 1 || attemptCount > 1_000_000_000) {
                throw new IllegalArgumentException("시도 횟수는 1 이상 1,000,000,000 이하의 숫자여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgException("숫자만 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            throw new CustomIllegalArgException(e.getMessage());
        }
    }
}
