package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constants.ErrorMessage.NOT_ALLOWED_FIRST_LAST_BLANK;
import static racingcar.constants.ErrorMessage.NOT_ALLOWED_UNDER_MINIMUM_TRY_COUNT;
import static racingcar.constants.ErrorMessage.TRY_COUNT_MUST_BE_NUMERIC;

class TryCountTest {
    @Test
    void 문장_맨_앞에_공백이_포함되는_경우_예외가_발생한다() {
        // given
        String rawTryCount = " 1";

        // when & then
        assertThatThrownBy(() -> new TryCount(rawTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_FIRST_LAST_BLANK);
    }

    @Test
    void 문장_맨_뒤에_공백이_포함되는_경우_예외가_발생한다() {
        // given
        String rawTryCount = "1 ";

        // when & then
        assertThatThrownBy(() -> new TryCount(rawTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_FIRST_LAST_BLANK);
    }

    @Test
    void 문장_맨_앞과_맨_뒤에_공백이_포함되는_경우_예외가_발생한다() {
        // given
        String rawTryCount = " 1 ";

        // when & then
        assertThatThrownBy(() -> new TryCount(rawTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_FIRST_LAST_BLANK);
    }

    @Test
    void 문장에_정수가_아닌_다른_문자열이_입력되는_경우_예외가_발생한다() {
        // given
        String rawTryCount = "a";

        // when & then
        assertThatThrownBy(() -> new TryCount(rawTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TRY_COUNT_MUST_BE_NUMERIC);
    }

    @Test
    void 시도할_횟수가_1보다_작은_경우_예외가_발생한다() {
        // given
        String rawTryCount = "0";

        // when & then
        assertThatThrownBy(() -> new TryCount(rawTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_UNDER_MINIMUM_TRY_COUNT);
    }

    @Test
    void 문자열에서_정수로_변환하는_데_성공한다() {
        // given
        String rawTryCount = "1";
        TryCount tryCount = new TryCount(rawTryCount);
        int expected = Integer.parseInt(rawTryCount);

        // when
        int real = tryCount.toInteger();

        // then
        assertThat(real).isEqualTo(expected);
    }
}
