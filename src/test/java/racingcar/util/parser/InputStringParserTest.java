package racingcar.util.parser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.util.Message.ErrorMessage.DUPLICATE_NAME_ERROR;
import static racingcar.util.Message.ErrorMessage.INVALID_DELIMITER_ERROR;
import static racingcar.util.Message.ErrorMessage.NAME_MAX_LENGTH_ERROR;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class InputStringParserTest {

    private final InputStringParser parser = new InputStringParser();

    @Test
    @DisplayName("적절한 입력을 했을 경우 자동차 이름을 잘 분해하는지 검증")
    void testExtractTokensWithValidInput() {
        //given
        String input = "minso,suji,win12";
        //when
        Set<String> tokens = parser.extractTokens(input);
        // then
        assertEquals(3, tokens.size());
        assertTrue(tokens.contains("minso"));
        assertTrue(tokens.contains("suji"));
        assertTrue(tokens.contains("win12"));
    }

    @ParameterizedTest
    @DisplayName("중복된 이름을 입력한 경우에 대한 예외처리")
    @ValueSource(strings = {"pobi,woni,pobi", "우테코11,우테코11,minso", "민서,민서,죠스"})
    void testExtractTokensWithDuplicateNames(final String inputString) {
        //given
        //when
        //then
        assertThatThrownBy(() -> parser.extractTokens(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NAME_ERROR);
    }

    @ParameterizedTest
    @DisplayName("잘못된 구분자를 입력한 경우의 예외처리")
    @ValueSource(strings = {"pobi,woni!pobi", "우테코11;우테코11 minso", "민서@민서\\죠스"})
    void testExtractTokensWithInvalidDelimiter(final String inputString) {
        //given
        //when
        //then
        assertThatThrownBy(() -> parser.extractTokens(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DELIMITER_ERROR);
    }
}
