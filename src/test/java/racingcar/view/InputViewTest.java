package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.TryCount;

public class InputViewTest {

    @Test
    void 자동차_이름을_정상적으로_구분하는가() {
        List<String> names = InputView.splitNames("pobi,woni,jun");
        assertThat(names).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,,woni", "pobi,woni,,jun", "pobi,,woni,,jun"})
    void 자동차_이름_구분자가_연속으로_주어지는_경우_예외(String input) {
        assertThatThrownBy(() -> InputView.splitNames(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "pobi,", ",pobi"})
    void 자동차_이름이_빈_문자열인_경우_예외(String input) {
        assertThatThrownBy(() -> InputView.splitNames(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "예외케이스"})
    void 시도_횟수가_숫자가_아닌_경우_예외(String input) {
        assertThatThrownBy(() -> InputView.convertToInt(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-99, -1})
    void 시도_횟수가_음수인_경우_예외(int input) {
        assertThatThrownBy(() -> new TryCount(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
