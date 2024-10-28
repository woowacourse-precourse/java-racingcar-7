package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    public void 여러번_테스트하여_랜덤_숫자가_0부터_9_사이에_있는지_확인() {
        // given
        int testCount = 1000;

        // when & then
        for (int i = 0; i < testCount; i++) {
            int randomNumber = RandomNumberGenerator.generate();
            assertTrue(randomNumber >= 0 && randomNumber < 10);
        }
    }
}
