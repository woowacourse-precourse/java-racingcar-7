package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자를 성공적으로 입력받음")
    void createRandomNumber() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        for (int i = 0; i < 10; i++) {
            int generateNumber = generator.getRandomNumber();

            assertThat(generateNumber).isGreaterThanOrEqualTo(0);
            assertThat(generateNumber).isLessThanOrEqualTo(9);
        }
    }
}
