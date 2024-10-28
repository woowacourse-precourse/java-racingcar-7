package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThreadLocalRandomNumberGeneratorTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void pickRandomNumberInRange() {
        // given
        RandomNumberGenerator randomNumberGenerator = new ThreadLocalRandomNumberGenerator();

        // when
        int randomNumber = randomNumberGenerator.pickRandomNumberInRange(0, 9);

        // then
        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }
}