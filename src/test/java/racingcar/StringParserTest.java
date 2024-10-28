package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.StringParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringParserTest {

    private final StringParser stringParser = new StringParser();

    @Test
    void 이름_파싱() {
        String input = "car1, car2, car3";
        List<String> result = stringParser.parseCarNameString(input);

        assertThat(result).containsExactly("car1", "car2", "car3");
    }

    @Test
    void 이름_길이_예외() {
        String input = "car123456";

        assertThatThrownBy(() -> stringParser.parseCarNameString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

    @Test
    void 시도_횟수_파싱() {
        String input = "5";
        int result = stringParser.parseTryCountString(input);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 시도_횟수_예외() {
        String input = "0";

        assertThatThrownBy(() -> stringParser.parseTryCountString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }
}
