package racingcar.domain;

import java.util.Objects;
import racingcar.constant.Rule;
import racingcar.util.NumberGenerator;
import racingcar.util.RacingCarValidator;

public class Car {

    private final String name;
    private final NumberGenerator randomNumberGenerator;
    private long score;

    private Car(final String name, final NumberGenerator randomNumberGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
        score = 0L;
    }

    public static Car of(final String name, final NumberGenerator randomNumberGenerator) {
        RacingCarValidator.validateCarNameLength(name, Rule.CAR_NAME_LENGTH_MAX);
        return new Car(name, randomNumberGenerator);
    }

    public String getName() {
        return this.name;
    }

    public long getScore() {
        return this.score;
    }

    public void go() {
        final int number = randomNumberGenerator.generate();
        if (isExceedForwardCondition(number)) {
            score++;
        }
    }

    private boolean isExceedForwardCondition(final int number) {
        return number >= Rule.CAR_FORWARD_CONDITION;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        final Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
