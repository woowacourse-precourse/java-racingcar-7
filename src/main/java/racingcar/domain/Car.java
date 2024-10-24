package racingcar.domain;

import java.util.Objects;
import racingcar.constant.Rule;
import racingcar.util.NumberGenerator;

public class Car {

    private final String name;
    private final NumberGenerator randomNumberGenerator;
    private long score;

    public Car(final String name, final NumberGenerator randomNumberGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
        score = 0L;
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
