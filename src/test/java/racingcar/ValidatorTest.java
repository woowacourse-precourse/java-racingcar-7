package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    Validator validator = new Validator();

    @Test
    void 자동차_이름_입력시_빈_문자열_검증() {
        assertThatThrownBy(() -> validator.validateCarNamesInput(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력은(는) 비어있을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {",one,two", "one,two,"})
    void 자동차_이름_입력시_구분자_위치_검증(String testStr) {
        assertThatThrownBy(() -> validator.validateCarNamesInput(testStr))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구분자는 차 이름 사이에 위치할 수 있습니다.");
    }

    @Test
    void 자동차_이름_기준_검증() {
        List<String> testEmptyStr = new ArrayList<>(List.of(""));
        List<String> testLongStr = new ArrayList<>(List.of("onetwo"));

        assertThatThrownBy(() -> validator.validateCarNamesLength(testEmptyStr, 5))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은(는) 비어있을 수 없습니다.");

        assertThatThrownBy(() -> validator.validateCarNamesLength(testLongStr, 5))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 기준을 넘길 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource({
        "'', '반복 횟수은(는) 비어있을 수 없습니다.'",
        "-123, '양수만 입력 가능합니다.'",
        "123abc45, '숫자만 입력 가능합니다.'"
    })
    void 반복_횟수_입력_검증(String input, String errorMessage) {
        assertThatThrownBy(() -> validator.validateRepeatCount(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(errorMessage);
    }
}