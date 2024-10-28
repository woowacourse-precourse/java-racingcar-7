package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.view.View.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ViewTest {
    @Test
    void 빈_이름_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateCarNames(" , "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어 있습니다.");
    }

    @Test
    void 이름_길이_초과_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateCarNames("pobi,abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 알파벳_아닌_이름_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateCarNames("pobi,12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 알파벳만 포함해야 합니다.");
    }

    @Test
    void 최소_자동차_수_미달_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateCarNames("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상 입력해야 합니다.");
    }

    @Test
    void 중복된_이름_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateCarNames("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 있습니다.");
    }
}