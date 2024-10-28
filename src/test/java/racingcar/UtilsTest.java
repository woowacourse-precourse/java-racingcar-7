package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.exception.ErrorCode;
import racingcar.utils.Utils;

public class UtilsTest {

    @Test
    void 공백_제거_테스트() {
        String inputWithWhitespace = " 1 2 3    4";
        String expected = "1234";

        String result = Utils.removeWhitespace(inputWithWhitespace);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 이름_길이_유효성_테스트() {
        String invalidName = "po bi ";

        assertThatThrownBy(() -> Utils.validateName(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_NAME_LENGTH.getMessage());
    }

    @Test
    void splitNames_테스트() {
        String input = "pobi, java,  woni"; // 공백 포함
        List<String> expectedNames = List.of("pobi", "java", "woni");

        List<String> result = Utils.splitNames(input);

        assertThat(result).isEqualTo(expectedNames);
    }

    @Test
    void 시도_횟수_입력_테스트() {
        String input = " 12 "; // 공백 포함
        int expected = 12;

        int result = Utils.inputToInt(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 시도_횟수_입력_예외_테스트() {
        String input = "1a3";

        assertThatThrownBy(() -> Utils.inputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_NUMBER.getMessage());
    }

    @Test
    void 시도_횟수_음수_예외_처리_테스트() {
        String input = "-1";

        assertThatThrownBy(() -> Utils.inputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_NUMBER.getMessage());
    }
}
