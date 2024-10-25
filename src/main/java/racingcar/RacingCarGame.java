package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;


public class RacingCarGame {

    private final int attemptCount;
    private final CarManager carManager = new CarManager();
    private final OutputView outputView = new OutputView();

    public RacingCarGame(InputValueContainer inputValueContainer) {
        List<String> carNames = inputValueContainer.getCarNames();
        int attemptCount = inputValueContainer.getAttemptCount();

        carManager.createCars(carNames);
        this.attemptCount = attemptCount;
    }

    public void play() {
        moveCars();
        outputView.renderResult(attemptCount);
    }

    private void moveCars() {
        for (int i = 0; i < attemptCount; i++) {
            List<Car> cars = carManager.getCars();
            cars.forEach(car -> {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    car.move();
                }
                outputView.saveCarPosition(car);
            });
        }
    }
}
