package racingcar.service;

import racingcar.model.Car;
import racingcar.model.NumberOfAttempt;
import racingcar.service.util.ManageCarMovement;
import racingcar.service.util.RandomNumberGenerator;
import racingcar.view.OutputView;
import racingcar.view.constant.RunConstant;

import java.util.*;

public class GameService {
    private final Car car;
    private final NumberOfAttempt numberOfAttempt;
    private final ManageCarMovement manageCarMovement = new ManageCarMovement();
    private final OutputView outputView = new OutputView();

    public GameService(Car car, NumberOfAttempt numberOfAttempt) {
        this.car = car;
        this.numberOfAttempt = numberOfAttempt;
        manageCarMovement.initialize(car.getCars());
    }

    public void showExecutionResult() {
        int repeatCount = numberOfAttempt.getNumber();
        outputView.printExecutionStartMessage();

        while (repeatCount != 0) {
            moveCarBasedOnRandomNumber();
            outputView.printExecutionResult(manageCarMovement, car.getCars());
            repeatCount--;
        }
    }

    public void showWinners() {
        List<String> winners = getGameWinner();
        outputView.printFinalResult(winners);
    }

    private void moveCarBasedOnRandomNumber() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        for (String name : car.getCars()) {
            int randomNumber = generator.getRandomNumber();
            if (randomNumber >= RunConstant.MOVE_THRESHOLD) {
                manageCarMovement.update(name);
            }
        }
    }

    public List<String> getGameWinner() {
        Map<String, String> movementCount = manageCarMovement.getCarMovementCount();
        String maxMovement = Collections.max(movementCount.values());

        List<String> carNames = car.getCars();
        List<String> winners = new ArrayList<>();

        for (String carName : carNames) {
            if (movementCount.get(carName).equals(maxMovement))
                winners.add(carName);
        }
        return winners;
    }
}