package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    void 랜덤값테스트() {
        final RandomGenerator randomGenerator = new RandomGenerator();
        Assertions.assertThat(randomGenerator.getRandomValue());
    }

}