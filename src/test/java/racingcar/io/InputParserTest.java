package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    private final InputParser parser = new InputParser();

    @Test
    @DisplayName("자동차 이름을 올바르게 파싱한다.")
    void 자동차_이름_파싱() {
        // given
        String input = "kim, glenn, park";

        // when
        List<String> carNames = parser.parseCarNames(input);

        // then
        assertEquals(List.of("kim", "glenn", "park"), carNames);
    }

    @Test
    @DisplayName("유효한 숫자를 정상적으로 파싱한다.")
    void 숫자_정상_파싱() {
        // given
        String validInput = "5";

        // when
        int result = parser.parseInt(validInput);

        // then
        assertEquals(5, result);
    }

    @Test
    @DisplayName("유효하지 않은 숫자를 파싱 시 예외 처리.")
    void 숫자_비정상_파싱() {
        // given
        String invalidInput = "a";

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parseInt(invalidInput)
        );

        // then
        String errorMessage = "유효한 숫자를 입력해주세요.";
        assertEquals(errorMessage, exception.getMessage());
    }

}