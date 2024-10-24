package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRace {

    private static final String RACE_PROCESS_MESSAGE = "\n실행 결과";
    private static final String CAR_CURRENT_POSITION_MESSAGE = "%s : %s\n";
    private static final int RANDOM_RANGE_START = 0;
    private static final int RANDOM_RANGE_END = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final Cars cars;
    private final int roundCount;

    public CarRace(Cars cars, int roundCount) {
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public void start() {
        System.out.println(RACE_PROCESS_MESSAGE);
        for (int i = 0; i < roundCount; i++) {
            moveCarsIfAble();
            displayCarsPositions();
        }
    }

    private void moveCarsIfAble() {
        for (Car car : cars.getCars()) {
            if (canMove()) {
                car.moveForward();
            }
        }
    }

    private void displayCarsPositions() {
        for (Car car : cars.getCars()) {
            System.out.printf((CAR_CURRENT_POSITION_MESSAGE), car.getName(), car.displayPosition());
        }
        System.out.println();
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END) >= MOVE_THRESHOLD;
    }
}
