package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    void 난수를_생성한다() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        int randomNum = randomNumberGenerator.generateNumber();

        assertThat(randomNum).isGreaterThanOrEqualTo(0);
        assertThat(randomNum).isLessThanOrEqualTo(9);
    }
}