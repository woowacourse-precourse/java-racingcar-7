package racingcar;

public class CarMover {

    private final MovePolicy movePolicy;

    public CarMover(MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
    }

    public void run(final Car car) {
        if (movePolicy.canMove()) {
            car.move();
        }
    }

}
