package racingcar;

public class MoveConstraints {

    private final RandomNumber randomNumber;

    public MoveConstraints(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void forwardOrStop(Car car) {
        if (isGreaterThanThree()) {
            car.move();
        }
    }

    private boolean isGreaterThanThree() {
        return randomNumber.generate() > 3;
    }


}
