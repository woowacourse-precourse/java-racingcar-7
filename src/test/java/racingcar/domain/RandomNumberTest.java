package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {
    @Test
    @DisplayName("0부터 9 사이의 무작위의 수가 잘 생성된다.")
    void generateRandomNumber () {
        // when
        RandomNumber randomNumber = new RandomNumber();

        // then
        assertThat(randomNumber.validRandomNumber()).isTrue();
    }

}