package racingcar.utills;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {

    private String delimiter = ",";

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "    ",","})
    void 입력이_빈_문자열이나_공백만_있을_경우_빈_리스트를_반환한다(String input) {
        // given

        // when
        List<String> result = StringParser.splitAndTrim(input, delimiter);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void 입력이_null_일_경우_빈_리스트를_반환한다() {
        // given
        String input = null;

        // when
        List<String> result = StringParser.splitAndTrim(input, delimiter);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void 정상_입력시_구분자로_나누고_각_요소의_공백을_제거하여_리스트를_반환한다() {
        // given
        String input = "  pobi ,  woni , jun  ";

        // when
        List<String> result = StringParser.splitAndTrim(input, delimiter);

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 구분자가_없는_경우_전체_문자열을_하나의_요소로_반환한다() {
        // given
        String input = "pobi";
        // when
        List<String> result = StringParser.splitAndTrim(input, delimiter);

        // then
        assertThat(result).containsExactly("pobi");
    }

    @Test
    void 빈_세그먼트가_포함된_입력_경우도_일단_반환한다() {
        // given
        String input = "pobi, ,woni,, jun,";

        // when
        List<String> result = StringParser.splitAndTrim(input, delimiter);

        // then
        assertThat(result).containsExactly("pobi", "", "woni", "", "jun");
    }
}