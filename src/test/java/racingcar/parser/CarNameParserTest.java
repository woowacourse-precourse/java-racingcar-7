package racingcar.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameParserTest {

    @Test
    @DisplayName("정상 파싱")
    void success_ValidParsing() {
        // Given
        String input = "pobi,woni,jun";
        ParserConfig config = ParserConfig.DEFAULT;
        CarNameParser parser = new CarNameParser(config);

        // When
        String[] carNames = parser.parse(input);

        // Then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("예외 - 구분자만 입력")
    void fail_OnlyDelimiter() {
        // Given
        String input = ",";
        ParserConfig config = ParserConfig.DEFAULT;
        CarNameParser parser = new CarNameParser(config);

        // When & Then
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구분자만 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("예외 - 자동차이름 길이초과")
    void fail_NameExceedsLength() {
        // Given
        String input = "pobi,woni,jun123";
        ParserConfig config = ParserConfig.DEFAULT;
        CarNameParser parser = new CarNameParser(config);

        // When & Then
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 0 이상 5글자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("예외 - 특수문자를 입력")
    void fail_InvalidCharacters() {
        // Given
        String input = "pobi,woni,jun@";
        ParserConfig config = ParserConfig.DEFAULT;
        CarNameParser parser = new CarNameParser(config);

        // When & Then
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사용할 수 없는 자동차 이름입니다.");
    }

    @Test
    @DisplayName("예외 빈 자동차이름")
    void fail_BlankName() {
        // Given
        String input = "pobi,,jun";
        ParserConfig config = ParserConfig.DEFAULT;
        CarNameParser parser = new CarNameParser(config);

        // When & Then
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 0 이상 5글자 이하만 가능합니다.");
    }
}