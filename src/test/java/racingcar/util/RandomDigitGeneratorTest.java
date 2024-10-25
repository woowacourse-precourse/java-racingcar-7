package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomDigitGeneratorTest {

    @RepeatedTest(1000)
    @DisplayName("0-9 사이의 랜덤한 값이 나오는지 1000번 반복 테스트")
    void randomNumberGenerator() {
        //given
        RandomGenerator randomGenerator = new RandomDigitGenerator();

        //when
        int actual = randomGenerator.generate();

        //then
        assertTrue(0 <= actual && actual <= 9);
    }
}