package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomGeneratorTest {

    @Test
    void 숫자0에서_9까지_램덤숫자를_반환한다() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int randomNumber = randomNumberGenerator.generate();

        assertTrue(randomNumber >= 0);
        assertTrue(randomNumber <= 9);
    }
}
