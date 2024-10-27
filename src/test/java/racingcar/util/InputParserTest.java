package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("입력값이 빈값일 경우 파싱 테스트")
    void parseNameEmpty() {
        // given
        final String input = "";
        List<String> expected = List.of("");

        // when
        var parseResponse = InputParser.parseName(input);

        // then
        assertThat(parseResponse).isEqualTo(expected);
    }
}