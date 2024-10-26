package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.InputProcessor;

public class InputProcessorTest {

    @DisplayName("빈 문자열 또는 공백인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testEmptyOrBlankInput(String input) {
        InputProcessor inputProcessor = new InputProcessor();
        assertThrows(IllegalArgumentException.class, () -> inputProcessor.splitCarNames(input));
    }

    @DisplayName("자동차 이름 중에 빈 문자열이 또는 공백이 있는 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,, woni", ", pobi, woni", "pobi, woni,", ", , "})
    void testEmptyOrBlankCarName(String input) {
        InputProcessor inputProcessor = new InputProcessor();
        assertThrows(IllegalArgumentException.class, () -> inputProcessor.splitCarNames(input));
    }

    @DisplayName("자동차 이름이 6자 이상인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"pobi123, woni, jun", "pobi, 123456, jun", "pobi, woni, won123"})
    void testCarNameLengthExceedsLimit(String input) {
        InputProcessor inputProcessor = new InputProcessor();
        assertThrows(IllegalArgumentException.class, () -> inputProcessor.splitCarNames(input));
    }

    @DisplayName("유효한 자동차 이름 입력 - List 반환")
    @ParameterizedTest
    @MethodSource("provideValidCarName")
    void testValidCarName(String input, List<String> expected) {
        InputProcessor inputProcessor = new InputProcessor();
        List<String> result = inputProcessor.splitCarNames(input);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideValidCarName() {
        return Stream.of(
                Arguments.of("pobi,woni,jun", List.of("pobi", "woni", "jun")),
                Arguments.of("pobi , woni , jun", List.of("pobi", "woni", "jun")),
                Arguments.of("pobi", List.of("pobi")),
                Arguments.of("pobi,   jun", List.of("pobi", "jun")),
                Arguments.of("car pobi,  car jun", List.of("car pobi", "car jun"))
        );
    }


}
