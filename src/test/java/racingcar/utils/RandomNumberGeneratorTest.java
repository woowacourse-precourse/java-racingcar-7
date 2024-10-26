package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    final int MIN_NUMBER = 0;
    final int MAX_NUMBER = 9;

    @Test
    void 범위_내_숫자를_생성해야_한다() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        int randomNumber = randomNumberGenerator.getNumber();
        boolean isValidNumber = randomNumber >= MIN_NUMBER && randomNumber <= MAX_NUMBER;

        // then
        assertThat(isValidNumber).isTrue();
    }
}
