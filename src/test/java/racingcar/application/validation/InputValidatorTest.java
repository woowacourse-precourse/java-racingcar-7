package racingcar.application.validation;

import static racingcar.infrastructure.exception.ErrorCode.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void 입력의_끝에_구분자가_있다면_예외를_발생한다() {
        // given
        String carNames = "a,";

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ENDS_WITH_DELIMITER.getMessage());
    }

    @Test
    void 자동차_이름이_비어있다면_예외를_발생한다() {
        // given
        String carNames = "";

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_EMPTY.getMessage());
    }

    @Test
    void 자동차_이름이_중복되었다면_예외를_발생한다() {
        // given
        String carNames = "a,a";

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(DUPLICATED_CAR_NAMES.getMessage());
    }

    @Test
    void 시도_횟수가_비어있다면_예외를_발생한다() {
        // given
        String round = "";

        // when % then
        Assertions.assertThatThrownBy(() -> inputValidator.validateRound(round))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_EMPTY.getMessage());
    }
    @Test
    void 시도_횟수가_1_미만일시_예외를_발생한다() {
        // given
        String round = "0";

        // when % then
        Assertions.assertThatThrownBy(() -> inputValidator.validateRound(round))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_LESS_THAN_ONE.getMessage());
    }

    @Test
    void 시도_횟수가_숫자가_아니라면_예외를_발생한다() {
        // given
        String round = "a";

        // when % then
        Assertions.assertThatThrownBy(() -> inputValidator.validateRound(round))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_NOT_NUMBER.getMessage());
    }
}
