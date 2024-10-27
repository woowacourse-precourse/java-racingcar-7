package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.enums.ErrorMessage;
import racingcar.validation.TurnCountValidator;

public class TurnCountValidatorTest {

  @Test
  void validateTurnCount_0_이하_예외_테스트() {
    assertThatThrownBy(() -> TurnCountValidator.validateTurnCount("0"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_INT_NUMBER.getMessage());
  }

  @Test
  void validateTurnCount_음수_예외_테스트() {
    assertThatThrownBy(() -> TurnCountValidator.validateTurnCount("-1"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_INT_NUMBER.getMessage());
  }

  @Test
  void validateTurnCount_유효한_숫자_정상_테스트() {
    assertThat(TurnCountValidator.validateTurnCount("9")).isEqualTo(9);
  }

  @Test
  void validateTurnCount_숫자가_아닌_값_예외_테스트() {
    assertThatThrownBy(() -> TurnCountValidator.validateTurnCount("!"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_TURN_NUMBER.getMessage());
  }
}
