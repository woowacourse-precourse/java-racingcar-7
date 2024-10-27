package racingcar.model;

public class RacingRecord {

    private final Car car;
    private int moveDistance;

    public RacingRecord(Car car) {
        this.car = car;
        moveDistance = 0;
    }

    public void recordMovement(int randomNumber) {
        if (car.canMoveUsing(randomNumber)) {
            moveDistance += 1;
        }
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public String getCarName() {
        return car.getName();
    }
}