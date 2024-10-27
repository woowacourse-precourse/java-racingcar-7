package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberGeneratorTest {
    @RepeatedTest(10)
    @DisplayName("랜덤 숫자가 0에서 9 사이인지 테스트")
    void generateNumberBeBetween0And9() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        int randomNumber = randomNumberGenerator.generateNumber();

        // then
        assertThat(randomNumber).isBetween(0, 9);
    }
}
