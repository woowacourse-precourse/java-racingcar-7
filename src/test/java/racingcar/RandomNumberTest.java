package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    void 범위_내의_랜덤된_숫자를_반환한다() {
        //given
        int start = 0;
        int end = 9;

        //when
        int actual = RandomNumber.generateInRange(0, 9);

        //then
        assertThat(actual).isBetween(start, end);
    }

}
