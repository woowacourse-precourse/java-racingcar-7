package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @Test
    void 무작위_숫자_생성_테스트() {
        int randomValue = RandomGenerator.generateRandomNumber();
        assertThat(randomValue).isBetween(0, 9);
    }
}
