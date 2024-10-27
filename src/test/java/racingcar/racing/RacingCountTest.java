package racingcar.racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "a12"})
    void 경주_횟수에_숫자가_아닌_값을_입력하면_예외가_발생한다(String input) {
        //when & then
        Assertions.assertThatThrownBy(() -> {
                    RacingCount racingCount = new RacingCount(input);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "", " ", "\n"})
    void 경주_횟수가_1회_이상이지_않을_경우_예외가_발생한다(String input) {
        //when & then
        Assertions.assertThatThrownBy(() -> {
                    RacingCount racingCount = new RacingCount(input);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("시도횟수는 최소 ");
    }
}
