package racingcar.util;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    @Test
    @DisplayName("랜덤 숫자가 0에서 9 사이의 값으로 생성되는지 테스트")
    void testGenerate() {
        Assertions.assertRandomNumberInRangeTest(() -> {
            int randomNumber = RandomNumberGenerator.generate();
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }, 0, 9);
    }
}