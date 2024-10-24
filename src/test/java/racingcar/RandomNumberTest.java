package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    void 범위_내의_랜덤된_숫자를_반환한다() {
        //given
        int start = 0;
        int end = 9;

        //when
        int actual = RandomNumber.generateInRange(start, end);

        //then
        assertThat(actual).isBetween(start, end);
    }

    @Test
    void 시작_값이_마지막_값_보다_크면_예외가_발생한다() {
        //given
        int start = 11;
        int end = 10;

        //when & then
        assertThatThrownBy(() -> RandomNumber.generateInRange(start, end))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("startInclusive cannot be greater than endInclusive.");
    }

    @Test
    void 범위_내에_최댓값이_존재하면_예외가_발생한다() {
        //given
        int start = 0;
        int end = Integer.MAX_VALUE;

        //when & then
        assertThatThrownBy(() -> RandomNumber.generateInRange(start, end))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("endInclusive cannot be greater than Integer.MAX_VALUE.");
    }

    @Test
    void 최대_범위_이상이면_예외가_발생한다() {
        //given
        int start = -1;
        int end = Integer.MAX_VALUE - 1;

        //when & then
        assertThatThrownBy(() -> RandomNumber.generateInRange(start, end))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("the input range is too large.");
    }
}
