package racingcar.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputParserTest {

    private static InputParser inputParser;

    @BeforeAll
    static void setup() {
        inputParser = new InputParser();
    }

    @DisplayName("입력 문자열을 구분자로 잘 분리하여 리스트로 반환한다")
    @ParameterizedTest
    @MethodSource("validParseData")
    void parseValidInput(String input, List<String> expected) {
        List<String> result = inputParser.convertToCarNamesList(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("잘못된 형식의 숫자를 입력할 경우 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidNumberData")
    void validateInvalidNumberFormat(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputParser.convertToInt(input))
                .withMessage(ErrorMessage.MUST_BE_NUMERIC.getMessage());
    }

    static Stream<Arguments> validParseData() {
        return Stream.of(
                Arguments.of("car1,car2,car3", List.of("car1", "car2", "car3")),
                Arguments.of("car1, car2 , car3 ", List.of("car1", "car2", "car3")),
                Arguments.of("carA,carB", List.of("carA", "carB"))
        );
    }

    static Stream<Arguments> invalidNumberData() {
        return Stream.of(
                Arguments.of("abc"),
                Arguments.of("1.5"),
                Arguments.of(" ")
        );
    }
}
