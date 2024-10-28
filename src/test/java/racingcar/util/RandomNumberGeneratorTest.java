package racingcar.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorTest {

    @Disabled
    @RepeatedTest(10000)
    @DisplayName("0에서 9 사이의 숫자만 생성되는지 확인")
    public void testRandomNumberInRange() {
        int randomNumber = RandomNumberGenerator.generate(0, 9);
        assertTrue(randomNumber >= 0 && randomNumber <= 9, "생성된 숫자가 0에서 9 사이에 있어야 합니다.");
    }
}

