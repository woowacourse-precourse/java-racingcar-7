package racingcar.model;

public class CarMover {
    public void move(Car car, int randomValue) {
        if (canMove(randomValue)) {
            car.move();
        }
    }

    public boolean canMove(int randomValue) {
        return randomValue >= 4;
    }
}
