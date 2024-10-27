package racingcar.model;

public class Car {
    private static final int MINIMUM_CAN_MOVE_CONDITION = 4;
    private static final int ONE_FORWARD_MOVE_DISTANCE = 1;
    private final RandomIntGenerator randomIntGenerator;
    private final String carName;
    private int position;

    public Car(String carName, RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove() {
        if (canMove()) {
            doMove();
        }
    }

    private boolean canMove() {
        return randomIntGenerator.getRandomNumber() >= MINIMUM_CAN_MOVE_CONDITION;
    }

    private void doMove() {
        position += ONE_FORWARD_MOVE_DISTANCE;
    }
}

