package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomGeneratorTest {
    @RepeatedTest(10)
    @DisplayName("랜덤 값이 0과 9 사이의 범위에 있는지 확인")
    void createRandomValue_withinRange() {
        int randomValue = RandomGenerator.createRandomValue();
        assertThat(randomValue).isBetween(0, 9);
    }
}