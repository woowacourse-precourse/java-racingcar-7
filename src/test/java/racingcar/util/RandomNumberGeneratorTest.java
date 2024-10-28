package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

class RandomNumberGeneratorTest {
    @DisplayName("0~9 사이의 무작위 값을 생성한다.")
    @Test
    void generate() {
        // when
        int randomNumber = RandomNumberGenerator.generate();

        // then
        assertThat(randomNumber).isBetween(0, 9);
    }

}