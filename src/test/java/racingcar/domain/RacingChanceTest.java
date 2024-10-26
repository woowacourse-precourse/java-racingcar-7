package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class RacingChanceTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 경기_횟수가_양수일_때_객체가_생성된다(String chance) {
        // given
        RacingChance racingChance = new RacingChance(chance);

        // when & then
        assertThat(racingChance.getRacingChance()).isEqualTo(Integer.parseInt(chance));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2"})
    void 경기_횟수가_음수일_때_예외가_발생한다(String chance) {
        // given
        String expected = "올바른 시도 횟수를 입력해주세요.";

        // when
        Throwable thrown = catchThrowable(() -> new RacingChance(chance));

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "/", "."})
    void 경기_횟수가_숫자가_아닐_때_예외가_발생한다(String chance) {
        // given
        String expected = "올바른 시도 횟수를 입력해주세요.";

        // when
        Throwable thrown = catchThrowable(() -> new RacingChance(chance));

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 경기_횟수가_빈_값일_경우_예외가_발생한다(String chance) {
        // given
        String expected = "올바른 시도 횟수를 입력해주세요.";

        // when
        Throwable thrown = catchThrowable(() -> new RacingChance(chance));

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }
}
