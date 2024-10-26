package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    void 자동차_이름_문자열이_없는_경우_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 없는 경우");
    }

    @Test
    void 자동차_이름_문자열에_쉼표_없는_경우_테스트() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobiwoni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표(,)가 포함되지 않은 경우");
    }

    @Test
    void 자동차_이름이_없는_경우_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 없는 경우");
    }

    @Test
    void 자동차_이름이_5자_초과하는_경우_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,javaji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 5자를 초과하는 경우");
    }

    @Test
    void 자동차_이름에_숫자나_특수문자가_포함된_경우_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("포비,j4un"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 알파벳이나 한글 이외의 문자");
    }

    @Test
    void 횟수_없는_경우_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateRound(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 없는 경우");
    }

    @Test
    void 횟수_숫자가_아닌_경우_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateRound("삼"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 경우");
    }

    @Test
    void 횟수_양수가_아닌_경우_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateRound("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수가 아닌 경우");
    }
}