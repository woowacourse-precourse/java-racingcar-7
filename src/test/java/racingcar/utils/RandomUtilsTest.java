package racingcar.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RandomUtilsTest {
    @Test
    @DisplayName("범위 내의 무작위 숫자를 생성한다")
    void generateRandomNUmber() {
        //given
        int min = 0;
        int max = 9;

        //when
        int actual = RandomUtils.generate();

        //then
        assertThat(actual).isBetween(min, max);
    }
}