package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void 영과_구_사이의_랜덤_숫자_반환한다() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        
        // when
        int randomNumber = randomNumberGenerator.generate();
        
        // then
        assertThat(randomNumber).isBetween(0, 9);
    }
}
