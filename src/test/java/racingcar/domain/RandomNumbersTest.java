package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.TestConstants.CAR_COUNT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersTest {
    @Test
    @DisplayName("입력한 수만큼 랜덤 숫자가 잘 생성된다.")
    void generateRandomNumbers () {
        // given
        Integer carCount = CAR_COUNT;

        // when
        RandomNumbers randomNumbers = new RandomNumbers(carCount);

        // then
        assertThat(randomNumbers.size()).isEqualTo(carCount);
    }

}