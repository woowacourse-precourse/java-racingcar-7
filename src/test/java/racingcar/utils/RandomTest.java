package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomTest {

    @Test
    @DisplayName("랜덤 숫자는 지정된 범위 사이의 숫자가 나와야한다.(0부터 9사이)")
    void randomNumberRange() {
        for (int i = 0; i < 1000; i++) {
            // given & when
            int randomNumber = Random.createRandomNumber();
            // then
            assertThat(randomNumber).isLessThanOrEqualTo(9);
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
        }
    }

}