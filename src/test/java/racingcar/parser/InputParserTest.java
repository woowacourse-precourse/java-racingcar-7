package racingcar.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputValidator;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {

    private InputParser inputParser;
    private InputValidator inputValidator;

    @BeforeEach
    public void setUp() {
        inputValidator = new InputValidator();
        inputParser = new InputParser(inputValidator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"YOON,YOON,CHAN"})
    @DisplayName("자동차 이름이 중복될 때 예외 발생")
    public void testDuplicateCarName(String input) {
        // When
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> inputParser.parseCarNames(input));
        // Then
        assertEquals("중복된 자동차 이름이 있습니다", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"YOON,WOONG,CHAN"})
    @DisplayName("자동차 이름이 중복되지 않으면 정상 통과")
    public void testUniqueCarName(String input) {
        // When & then
        assertDoesNotThrow(()-> inputParser.parseCarNames(input));
    }
}
