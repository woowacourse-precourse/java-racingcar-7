package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @DisplayName("0~9 사이의 정수를 만드는 테스트")
    @Test
    void makeRandomNumberTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        assertThat(randomNumberGenerator.makeRandomNumber()).isBetween(0, 9);
    }
}