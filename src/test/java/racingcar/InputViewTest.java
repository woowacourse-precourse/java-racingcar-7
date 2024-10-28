package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameException;
import racingcar.exception.MoveCountException;
import racingcar.validator.CarNameValidator;
import racingcar.validator.MoveCountValidator;

public class InputViewTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름_비어있거나_널인경우_테스트(String input) {
        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(CarNameException.class)
                .hasMessage(CarNameValidator.CAR_NAME_EMPTY_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi.woni", "pobi;woni"})
    void 자동차_이름_쉼표기준이아닌경우_테스트(String input) {
        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(CarNameException.class)
                .hasMessage(CarNameValidator.CAR_NAME_DELIMITER_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {",pobi", "pobi사랑,123456", "p,obi woni", "pobi1234 ,  woni"})
    void 자동차_이름_길이_테스트(String input) {
        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(CarNameException.class)
                .hasMessage(CarNameValidator.CAR_NAME_LENGTH_ERROR);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이동횟수_비어있거나_널인경우_테스트(String input) {
        assertThatThrownBy(() -> MoveCountValidator.validate(input))
                .isInstanceOf(MoveCountException.class)
                .hasMessage(MoveCountValidator.ATTEMPTS_EMPTY_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void 이동횟수_0인경우_테스트(String input) {
        assertThatThrownBy(() -> MoveCountValidator.validate(input))
                .isInstanceOf(MoveCountException.class)
                .hasMessage(MoveCountValidator.ATTEMPTS_ZERO_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10", "0-3"})
    void 이동횟수_음수인경우_테스트(String input) {
        assertThatThrownBy(() -> MoveCountValidator.validate(input))
                .isInstanceOf(MoveCountException.class)
                .hasMessage(MoveCountValidator.ATTEMPTS_NEGATIVE_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "8a", "*&"})
    void 이동횟수_숫자가아닌경우_테스트(String input) {
        assertThatThrownBy(() -> MoveCountValidator.validate(input))
                .isInstanceOf(MoveCountException.class)
                .hasMessage(MoveCountValidator.ATTEMPTS_NUMBER_ERROR);
    }
}
