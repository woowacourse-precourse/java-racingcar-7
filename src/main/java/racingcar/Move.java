package racingcar;

public class Move {
    private final Car car;
    private final NumberValidator numberValidator;
    private final NumberGenerator numberGenerator;

    public Move(Car car, NumberValidator numberValidator, NumberGenerator numberGenerator) {
        this.car = car;
        this.numberValidator = numberValidator;
        this.numberGenerator = numberGenerator;
    }

    public void tryOnce() {
        int randomNumber = numberGenerator.pickOne();
        boolean canMove = numberValidator.isAboveLowerBound(randomNumber);
        car.moveForwardIf(canMove);
    }
}
