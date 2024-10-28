package racingcar.domain.randomnumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomIntegerGeneratorTest {

    @Test
    void 랜덤값_생성() {

        // given
        int lowerBound = 0;
        int upperBound = 9;
        RandomNumberGenerator<Integer> randomNumberGenerator = new RandomIntegerGenerator(lowerBound, upperBound);

        // when
        Integer number = randomNumberGenerator.pickNumber();

        // then
        assertThat(number).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

}