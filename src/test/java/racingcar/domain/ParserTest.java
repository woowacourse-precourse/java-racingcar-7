package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.View.constant.ErrorMessage.BLANK_VALUE;
import static racingcar.View.constant.ErrorMessage.INVALID_INTEGER;
import static racingcar.View.constant.ErrorMessage.OVER_VALUE;
import static racingcar.View.constant.ErrorMessage.TOO_LONG_VALUE;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {
    private final Parser parser = new Parser();

    @Test
    void 쉼표를_기준으로_파싱() {
        String input = "자동차1, 자동차2, 자동차3";
        List<String> expected = List.of("자동차1", "자동차2", "자동차3");
        assertEquals(expected, parser.parse(input));
    }

    @Test
    void 다섯글자_넘을경우_예외처리() {
        String input = "자동차1,다섯글자넘어가는자동차, 자동차3";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse(input)
        );
        assertEquals(TOO_LONG_VALUE.getMessage(), exception.getMessage());
    }

    @Test
    void 빈_문자열_예외처리() {
        String input = "자동차1,, 자동차3";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse(input)
        );
        assertEquals(BLANK_VALUE.getMessage(), exception.getMessage());
    }
    @Test
    void 쉼표가_마지막에_있을경우_예외처리() {
        String input = "자동차1, 자동차3,";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse(input)
        );
        assertEquals(BLANK_VALUE.getMessage(), exception.getMessage());
    }

    @Test
    void 입력이_숫자가_아닌경우_예외처리() {
        String input = "a";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parseInt(input)
        );
        assertEquals(INVALID_INTEGER.getMessage(), exception.getMessage());
    }

    @Test
    void 입력이_정수를_벗어날_경우_예외처리() {
        String input = String.valueOf(Long.MAX_VALUE);
        System.out.println(input);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parseInt(input)
        );
        assertEquals(OVER_VALUE.getMessage(), exception.getMessage());
    }
}