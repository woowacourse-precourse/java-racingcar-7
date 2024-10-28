package racingcar;

import static racingcar.infrastructure.exception.ErrorCode.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.validation.InputValidator;

@DisplayName("InputValidator 클래스 테스트")
public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();
    @Test
    void 쉼표가_연속적으로_입력된_경우_예외를_발생한다() {
        // given
        String carNames = "a,,b";

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CONSECUTIVE_COMMA.getMessage());
    }

    @Test
    void 자동차_이름이_1자_이상_5자_이하라면_예외를_발생하지_않는다() {
        // given
        String carNames = "a,b,c";

        // when & then
        Assertions.assertThatCode(() -> inputValidator.validateCarNames(carNames))
            .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수가_비어있다면_예외를_발생한다() {
        // given
        String rounds = "";

        // when % then
        Assertions.assertThatThrownBy(() -> inputValidator.validateRound(rounds))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_EMPTY.getMessage());
    }
    @Test
    void 시도_횟수가_1_미만일시_예외를_발생한다() {
        // given
        String rounds = "0";

        // when % then
        Assertions.assertThatThrownBy(() -> inputValidator.validateRound(rounds))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_LESS_THAN_ONE.getMessage());
    }

    @Test
    void 시도_횟수가_숫자가_아니라면_예외를_발생한다() {
        // given
        String rounds = "a";

        // when % then
        Assertions.assertThatThrownBy(() -> inputValidator.validateRound(rounds))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_NOT_NUMBER.getMessage());
    }
}
