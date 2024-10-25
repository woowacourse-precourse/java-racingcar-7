package racingcar.car;

import racingcar.constant.Constant;
import racingcar.util.NumberGenerator;

public class Car implements Comparable<Car> {

    private static final int MAX = 9;
    private static final int MIN = 0;
    private static final int STOP_VALUE = 3;

    private final NumberGenerator randomGenerator;
    private final String name;
    private int position;

    public Car(String name, NumberGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.name = name;
        this.position = 0;
    }

    public void move() {
        final int randomNumber = randomGenerator.generator();

        if (isRange(randomNumber)) {
            throw new IllegalArgumentException(Constant.RANDOM_RANGE_VALUE_ERROR_STRING);
        }

        if (isPossible(randomNumber)) {
            this.position += 1;
        }
    }


    public String getName() {
        return name;
    }

    private boolean isRange(final int number) {
        return number < MIN || number > MAX;
    }

    private boolean isPossible(int randomNumber) {
        return randomNumber > STOP_VALUE;
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    @Override
    public int compareTo (Car car) {
        return this.position - car.position;
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position);
    }

}
