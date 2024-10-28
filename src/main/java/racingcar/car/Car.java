package racingcar.car;

import racingcar.constant.Constant;
import racingcar.util.NumberGenerator;

public class Car implements Comparable<Car> {

    private static final int MAX = 9;
    private static final int MIN = 0;
    private static final int STOP_VALUE = 3;
    private static final int DEFAULT_MOVEMENT_DISTANCE = 1;

    private final NumberGenerator randomGenerator;
    private final String name;
    private int position;

    public Car(final String name, final NumberGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.name = name;
        this.position = 0;
    }

    public void move() {
        final int randomNumber = randomGenerator.generator();

        validateRange(randomNumber);
        if (isPossible(randomNumber)) {
            this.position += DEFAULT_MOVEMENT_DISTANCE;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.name + " : " + "-".repeat(this.position);
    }

    private void validateRange(final int randomNumber) {
        if (isRangeOut(randomNumber)) {
            throw new IllegalArgumentException(Constant.RANDOM_RANGE_VALUE_ERROR_STRING);
        }
    }

    private boolean isRangeOut(final int number) {
        return number < MIN || number > MAX;
    }

    private boolean isPossible(final int randomNumber) {
        return randomNumber > STOP_VALUE;
    }

    public boolean isSamePosition(final Car car) {
        return this.position == car.position;
    }

    @Override
    public int compareTo(final Car car) {
        return this.position - car.position;
    }

}
