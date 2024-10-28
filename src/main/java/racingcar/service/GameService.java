package racingcar.service;

import racingcar.model.Car;
import racingcar.model.NumberOfAttempt;
import racingcar.service.util.ManageCarMovement;
import racingcar.service.util.RandomNumberGenerator;
import racingcar.view.OutputView;
import racingcar.view.constant.RunConstant;

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

    private void moveCarBasedOnRandomNumber() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        for (String name : car.getCars()) {
            int randomNumber = generator.getRandomNumber();
            if (randomNumber >= RunConstant.MOVE_THRESHOLD) {
                manageCarMovement.update(name);
            }
        }
    }
}