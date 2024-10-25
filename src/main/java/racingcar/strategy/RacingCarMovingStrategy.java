package racingcar.strategy;

import racingcar.comparable.NumberComparable;
import racingcar.random.RandomNumberGenerator;

public class RacingCarMovingStrategy implements MovingStrategy {

    private final RandomNumberGenerator randomNumberGenerator;
    private final NumberComparable<Number> numberComparable;
    private final int forwardMinInclusive;

    public RacingCarMovingStrategy(final RandomNumberGenerator randomNumberGenerator,
                                   final NumberComparable<Number> numberComparable, final int forwardMinInclusive) {
        this.forwardMinInclusive = forwardMinInclusive;
        this.randomNumberGenerator = randomNumberGenerator;
        this.numberComparable = numberComparable;
    }

    @Override
    public boolean canMove() {
        Number value = randomNumberGenerator.pickNumber();
        return numberComparable.compare(value, forwardMinInclusive) >= 0;
    }
}
