package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

class ValidationServiceTest {

    @Test
    void 자동차_이름_입력값이_존재하지_않을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateCarNames(List.of()))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.EMPTY_INPUT.getMessage())
        );
    }

    @Test
    void 자동차_이름이_하나일_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateCarNames(List.of("pobi")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INSUFFICIENT_CAR_NAMES.getMessage())
        );
    }

    @Test
    void 자동차_이름이_5자를_초과할_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateCarNames(List.of("pobiiii", "woni")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage())
        );
    }

    @Test
    void 자동차_이름을_중복되게_적을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateCarNames(List.of("pobi", "pobi")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.DUPLICATE_CAR_NAME.getMessage())
        );
    }

    @Test
    void 자동차_이름을_대소문자만_다르고_중복되게_적을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateCarNames(List.of("pobi", "POBI")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.DUPLICATE_CAR_NAME.getMessage())
        );
    }

    @Test
    void 자동차_이름을_입력하지_않고_쉼표를_적었는지() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateCarNames(List.of("a", "", "b")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.MISSING_CAR_NAME.getMessage())
        );
    }

    @Test
    void 자동차_이름을_입력하고_쉼표로_끝냈는지() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateCarNames(List.of("a", "b", "")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.MISSING_CAR_NAME.getMessage())
        );
    }

    @Test
    void 시도_횟수_입력값이_존재하지_않을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateAttempts(""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.EMPTY_INPUT.getMessage())
        );
    }

    @Test
    void 시도_횟수를_입력할_때_정수가_아닐_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateAttempts("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NON_NUMERIC_ATTEMPTS.getMessage())
        );
    }

    @Test
    void 시도_횟수를_입력할_때_0인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateAttempts("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_ATTEMPTS.getMessage())
        );
    }

    @Test
    void 시도_횟수를_입력할_때_음수인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ValidationService.validateAttempts("-5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_ATTEMPTS.getMessage())
        );
    }
}