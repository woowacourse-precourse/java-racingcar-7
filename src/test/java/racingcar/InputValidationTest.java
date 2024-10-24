package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {
    private final Validation validation = new Validation();

    @Test
    void 입력받은_자동차_이름_형식이_올바른_경우() {
        assertThat(validation.validateCarName("pobi,woni,jun")).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    @Test
    void 자동차_이름이_한_대만_입력된_경우() {
        assertThatThrownBy(
                () -> validation.validateCarName("pobi")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력에_여섯자_이상의_자동차_이름이_존재하는_경우() {
        assertThatThrownBy(
                () -> validation.validateCarName("makingascene")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_알파벳이나_숫자_외의_문자를_포함하는_경우() {
        assertThatThrownBy(
                () -> validation.validateCarName("t_t")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_정상적으로_입력된_경우() {
        assertThat(validation.validateRoundLimit("5")).isEqualTo(5);
    }

    @Test
    void 시도_횟수_입력이_백_초과인_경우() {
        assertThatThrownBy(
                validation.validateRoundLimit("150")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_입력이_양의_정수가_아닌_경우() {
        assertThatThrownBy(
                validation.validateRoundLimit("-10")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_입력이_숫자_형태가_아닌_경우() {
        assertThatThrownBy(
                validation.validateRoundLimit("a")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
