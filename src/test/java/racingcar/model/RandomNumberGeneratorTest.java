package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void 영에서_9_사이의_무작위_값을_생성한다() {
        // given
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        int testTrial = 100;

        // when & then
        for (int i = 0; i < testTrial; i++) {
            int number = numberGenerator.generate();
            assertTrue(number >= 0 && number <= 9);
        }
    }
}