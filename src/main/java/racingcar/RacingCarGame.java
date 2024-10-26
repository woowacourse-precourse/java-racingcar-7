package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;
import racingcar.car.CarManager;
import racingcar.view.input.InputValueContainer;
import racingcar.view.output.OutputLogRepository;
import racingcar.view.output.OutputView;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


public class RacingCarGame {

    private final int attemptCount;
    private final CarManager carManager = new CarManager();
    private final OutputLogRepository outputLogRepository = new OutputLogRepository();

    public RacingCarGame(InputValueContainer inputValueContainer) {
        List<String> carNames = inputValueContainer.getCarNames();
        int attemptCount = inputValueContainer.getAttemptCount();

        carManager.createCars(carNames);
        this.attemptCount = attemptCount;
    }

    public GameResult getGameResult() {
        return new GameResult(attemptCount, outputLogRepository.getCarPositionLog());
    }

    public void play() {
        moveCars();
    }

    private void moveCars() {
        for (int i = 0; i < attemptCount; i++) {
            List<Car> cars = carManager.getCars();
            cars.forEach(car -> {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    car.move();
                }
                outputLogRepository.saveCarPositionLog(car);
            });
        }
    }
}
