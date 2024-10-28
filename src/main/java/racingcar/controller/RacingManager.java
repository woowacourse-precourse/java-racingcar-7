package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Random;
import racingcar.util.Direction;
import racingcar.view.OutputView;

public class RacingManager {

    private final Car car;
    private final Random random;
    private final OutputView view;
    private final DirectionController directionController;

    public RacingManager(Car car, Random random, OutputView view, DirectionController directionController) {
        this.car = car;
        this.random = random;
        this.view = view;
        this.directionController = directionController;
    }

    private void movingProcess(List<Car> cars) {
        for (Car c : cars) {
            int randomNum = random.generateRandomValueInRange();
            Direction direction = directionController.determineDirectionUsingThreshold(randomNum);
            c.moveToOrientedDirection(direction);
            view.printCarNameAndMovingStatus(c);
        }
        System.out.println();
    }

}
