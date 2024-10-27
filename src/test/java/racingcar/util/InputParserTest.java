package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InputException;

class InputParserTest {

    @ParameterizedTest(name = "입력값 {0}파싱 테스트")
    @DisplayName("이름 파싱 테스트")
    @ValueSource(strings = {"pobi,crong", "pobi, crong", "    pobi, crong", "pobi, crong    ", "    pobi, crong    "})
    void parseName(String input) {
        // given
        List<String> expected = List.of("pobi", "crong");

        // when
        var parseResponse = InputParser.parseName(input);

        // then
        assertThat(parseResponse).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값이 빈값일 경우 오류 발생 테스트")
    void parseNameEmptyTest() {
        // given
        final String input = "";
        List<String> expected = List.of("");

        // when && then
        assertThatThrownBy(() -> InputParser.parseName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputException.INPUT_IS_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("입력값이 null일 경우 오류 발생 테스트")
    void parseNameNullTest() {
        // given
        final String input = null;
        List<String> expected = List.of("");

        // when && then
        assertThatThrownBy(() -> InputParser.parseName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputException.INPUT_IS_NULL_OR_EMPTY.getMessage());
    }
}