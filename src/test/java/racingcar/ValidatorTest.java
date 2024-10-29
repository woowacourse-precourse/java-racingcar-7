package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @Test
    void 자동차이름이_null_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(null));
    }

    @Test
    void 자동차이름에_null포함_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateCarNames(Arrays.asList("pobi", null, "woni"))
        );
    }

    @Test
    void 자동차이름_빈값_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(List.of("pobi", "", "woni")));
    }

    @Test
    void 자동차이름_다섯글자_초과_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(List.of("pobi", "longname", "woni")));
    }

    @Test
    void 시도횟수_음수_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAttemptCount("-1"));
    }

    @Test
    void 시도횟수_0일때_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAttemptCount("0"));
    }

    @Test
    void 시도횟수_정수가_아닐때_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAttemptCount("abc"));
    }

    @Test
    void 시도횟수_양수인_경우_통과() {
        Validator.validateAttemptCount("3");
    }

    @Test
    void 자동차이름이_유효한_경우_통과() {
        Validator.validateCarNames(List.of("pobi", "java", "woni"));
    }
}
