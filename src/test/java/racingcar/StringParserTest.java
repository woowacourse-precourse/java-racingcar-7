package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class StringParserTest {
    @Test
    void 쉼표_기준으로_문자열을_분리() {
        // Given
        String input = "pobi,woni";
        String delimiter = ",";

        // When
        List<String> result = StringParser.parse(input, delimiter);

        // Then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("pobi", "woni");
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
}
