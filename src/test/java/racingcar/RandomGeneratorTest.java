package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomGeneratorTest {

    @Test
    void 랜덤숫자_반환테스트() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int randomNumber = randomNumberGenerator.generate();

        assertTrue(randomNumber >= 0);
        assertTrue(randomNumber <= 9);
    }
}
