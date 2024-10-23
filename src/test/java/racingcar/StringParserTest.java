package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class StringParserTest {
    @Test
    void 쉼표_기준으로_문자열을_분리() {
        // Given
        String input = "pobi,woni,jun";
        String delimiter = ",";

        // When
        List<String> result = StringParser.parse(input, delimiter);

        // Then
        assertThat(result).hasSize(3);
        assertThat(result).containsExactly("pobi", "woni","jun");
    }

    @Test
    void 쉼표_기준으로_문자열을_분리_원소1개() {
        // Given
        String input = "pobi";
        String delimiter = ",";

        // When
        List<String> result = StringParser.parse(input, delimiter);

        // Then
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly("pobi");
    }

    @Test
    void 쉼표_기준으로_문자열을_분리_공백문자포함() {
        // Given
        String input = " pobi ,woni ";
        String delimiter = ",";

        // When
        List<String> result = StringParser.parse(input, delimiter);

        // Then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("pobi", "woni");
    }

    @Test
    void 빈_입력값() {
        // Given
        String input = "";
        String delimiter = ",";

        // When & Then
        assertSimpleTest(() ->
            assertThatThrownBy(() -> StringParser.parse(input, delimiter))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력값이 비어있습니다.")
        );
    }

    @Test
    void 빈_구분자() {
        // Given
        String input = "woni";
        String delimiter = "";

        // When & Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> StringParser.parse(input, delimiter))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("구분자가 비어있습니다.")
        );
    }

    @Test
    void 입력으로_공백문자만_들어옴() {
        // Given
        String input = "   ";
        String delimiter = ",";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> StringParser.parse(input, delimiter))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("빈 문자열은 자동차 이름으로 사용할 수 없습니다.")
        );
    }

    @Test
    void 입력으로_공백문자와_쉼표만_들어옴() {
        // Given
        String input = " ,  ,";
        String delimiter = ",";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> StringParser.parse(input, delimiter))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("빈 문자열은 자동차 이름으로 사용할 수 없습니다.")
        );
    }
}
