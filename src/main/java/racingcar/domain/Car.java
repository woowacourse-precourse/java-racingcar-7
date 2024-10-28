package racingcar.domain;

import java.util.Objects;
import racingcar.constant.Rule;
import racingcar.util.generator.NumberGenerator;

public class Car {

    private final CarName name;
    private final Score score;
    private final NumberGenerator randomNumberGenerator;


    public Car(final CarName name, final Score score, final NumberGenerator randomNumberGenerator) {
        this.name = name;
        this.score = score;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getScore() {
        return this.score.getValue();
    }

    public void go(final int score) {
        final int number = randomNumberGenerator.generate();
        if (isExceedForwardCondition(number)) {
            this.score.addValue(score);
        }
    }

    public boolean isWinner(final int maxScore) {
        return getScore() == maxScore;
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
        return Objects.equals(name.getValue(), car.name.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.getValue());
    }
}
