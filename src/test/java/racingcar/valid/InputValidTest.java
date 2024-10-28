package racingcar.valid;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.global.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputValidTest {

    @Nested
    class 자동차_이름_올바른_입력 {

        @Test
        void 올바른_입력() {
            String input = "aing,ehig,ewq";

            List<String> result = InputValidator.validCarNames(input);

            assertEquals(result, Arrays.asList("aing", "ehig", "ewq"));
        }

        @Test
        void 공백이_있는_경우() {
            String input = "aing   ,   ehig   ,ewq    ";

            List<String> result = InputValidator.validCarNames(input);

            assertEquals(result, Arrays.asList("aing", "ehig", "ewq"));
        }
    }

    @Nested
    class 자동차_이름_잘못된_입력 {

        @Test
        void 이름_5자_초과() {
            String input = "123456";

            assertThatThrownBy(() -> InputValidator.validCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 알파벳_숫자_이외의_문자() {
            String input = "[hi]";

            assertThatThrownBy(() -> InputValidator.validCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 빈_문자열() {
            String input = "";

            assertThatThrownBy(() -> InputValidator.validCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 반복_횟수_올바른_입력 {

        @Test
        void 올바른_입력() {
            String input = "1";

            int result = InputValidator.validRepeatNum(input);

            assertEquals(result, 1);
        }
    }

    @Nested
    class 반복_횟수_잘못된_입력 {

        @Test
        void 숫자가_아님() {
            String input = "g";

            assertThatThrownBy(() -> InputValidator.validRepeatNum(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}
