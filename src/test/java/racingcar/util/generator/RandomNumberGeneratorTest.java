package racingcar.util.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.generator.RandomNumberGenerator;

public class RandomNumberGeneratorTest {
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }
    @Test
    @DisplayName("유효한 범위의 랜덤한 숫자를 생성하는지 검증")
    void testGenerateNumberWithinRange() {

        for (int i = 0; i < 100; i++) {
            //given
            //when
            int number = randomNumberGenerator.generateNumber();
            //then
            assertTrue(number >= 0 && number <= 9);
        }
    }
}
