package racingcar.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.constants.ErrorMessageConstants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCountValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 이동_횟수_입력값이_null_또는_빈_문자열인_경우_예외_테스트(String moveCountInput) {
        assertThatThrownBy(() -> MoveCountValidator.validateMoveCount(moveCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.ERROR_EMPTY_MOVE_COUNT);
    }
}
