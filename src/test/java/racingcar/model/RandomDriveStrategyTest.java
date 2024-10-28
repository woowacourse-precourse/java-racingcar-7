package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RandomDriveStrategyTest {

    @Test
    void 무작위_값이_4_이상이면_자동차는_전진한다() {
        // given
        NumberGenerator numberGenerator = new FixedNumberGenerator(4);
        RandomDriveStrategy driveStrategy = new RandomDriveStrategy(numberGenerator);

        // when
        int position = 5;
        int advancedPosition = driveStrategy.drive(position);

        // then
        assertEquals(position + 1, advancedPosition);
    }

    @Test
    void 무작위_값이_4_미만이면_자동차는_멈춘다() {
        // given
        NumberGenerator numberGenerator = new FixedNumberGenerator(3);
        RandomDriveStrategy driveStrategy = new RandomDriveStrategy(numberGenerator);

        // when
        int position = 5;
        int advancedPosition = driveStrategy.drive(position);

        // then
        assertEquals(position, advancedPosition);
    }

    private static class FixedNumberGenerator implements NumberGenerator {

        private final int fixedNumber;

        private FixedNumberGenerator(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        public int generate() {
            return fixedNumber;
        }
    }
}