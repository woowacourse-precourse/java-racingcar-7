package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("랜덤한 수를 만들어 내는 경우의 테스트")
    void generateRandomNumberTest() {
        //given

        //when
        int number = RandomNumberGenerator.generateNumber();
        //then
        assertThat(number).isBetween(0, 9);
    }
}
