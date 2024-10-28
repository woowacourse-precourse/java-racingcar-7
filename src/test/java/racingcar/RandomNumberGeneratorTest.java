package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorTest {
    @Test
    void 랜덤으로_생성된_숫자가_0과_9_사이인지_테스트() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        int randomNumber = numberGenerator.generate();

        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }
}
