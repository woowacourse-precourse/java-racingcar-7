package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 자동차_이름_입력시_빈_문자열_검증() {
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.validateCarNamesInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 비어있을 수 없습니다");
    }

    @Test
    void 자동차_이름_입력시_구분자_위치_검증() {
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.validateCarNamesInput(",one,two"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 차 이름 사이에 위치할 수 있습니다.");

        assertThatThrownBy(() -> validator.validateCarNamesInput("one,two,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 차 이름 사이에 위치할 수 있습니다.");
    }
}