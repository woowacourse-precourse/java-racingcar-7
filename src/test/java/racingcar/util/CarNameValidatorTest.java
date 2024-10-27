package racingcar.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

@DisplayName("사용자 입력 자동차 이름 목록에 대한 유효성 검사")
class CarNameValidatorTest {

    @Test
    public void 정상_입력시_예외_미발생() {
        // given
        List<String> carNames = List.of("one", "two", "three", "four", "fi ve");

        // when, then
        Assertions
                .assertThatNoException()
                .isThrownBy(() -> CarNameValidator.validateCarNames(carNames));
    }

    @Test
    public void 자동차_이름_목록_비어있을시_예외_발생() {
        // given
        List<String> carNames = List.of();

        // when, then
        Assertions
                .assertThatThrownBy(() -> CarNameValidator.validateCarNames(carNames))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @Test
    public void 자동차_이름_길이_초과시_예외_발생() {
        // given
        List<String> carNames = List.of("one", "two", "thr ee", "four", "five");

        // when, then
        Assertions
                .assertThatThrownBy(() -> CarNameValidator.validateCarNames(carNames))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
    }

    @Test
    public void 자동차_이름_비어있을시_예외_발생() {
        // given
        List<String> carNames = List.of("one", "two", "", "four", "five");

        // when, then
        Assertions
                .assertThatThrownBy(() -> CarNameValidator.validateCarNames(carNames))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @Test
    public void 자동차_이름_중복시_예외_발생() {
        // given
        List<String> carNames = List.of("one", "two", "one", "four", "five");

        // when, then
        Assertions
                .assertThatThrownBy(() -> CarNameValidator.validateCarNames(carNames))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
    }
}