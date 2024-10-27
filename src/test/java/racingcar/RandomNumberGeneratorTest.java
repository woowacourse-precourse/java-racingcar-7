package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void 랜덤_숫자_범위_테스트() {
        assertThat(randomNumberGenerator.generate()).isBetween(0, 9);
    }
}