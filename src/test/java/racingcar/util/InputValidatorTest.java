package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.util.InputValidator.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 정상_문자열_입력시_예외가_발생하지_않는다() {
        // given
        String input = "pobi";

        // when & then
        assertDoesNotThrow(() -> validateNotBlank(input));
    }

    @Test
    void 빈_문자열_입력시_예외가_발생한다() {
        // given
        String input = "";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validateNotBlank(input));
    }

    @Test
    void 공백_존재하는_문자열_입력시_예외가_발생한다() {
        // given
        String input = "  ";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validateNotBlank(input));
    }

    @Test
    void 중복이_존재_안하면_예외가_발생하지_않는다() {
        // given
        List<String> list = List.of("pobi", "jason", "yeontaek");

        // when & then
        assertDoesNotThrow(() -> validateNoDuplicates(list));
    }

    @Test
    void 중복이_존재하면_예외가_발생한다() {
        // given
        List<String> list = List.of("pobi", "jason", "pobi");

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validateNoDuplicates(list));
    }
}