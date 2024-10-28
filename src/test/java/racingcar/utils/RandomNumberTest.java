package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    @Test
    void 랜덤값이_범위_내에_있는지_확인() {
        int randomValue = RandomNumber.generate();
        assertThat(randomValue).isBetween(0, 9);
    }
}
