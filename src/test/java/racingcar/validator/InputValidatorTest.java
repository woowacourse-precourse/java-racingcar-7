package racingcar.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.global.constant.InvalidInputExceptionMessage.*;
import racingcar.global.validator.InputValidator;
import racingcar.global.validator.InputValidator.ValidationMode;

public class InputValidatorTest {
    @Test
    void 자동차_이름의_길이가_최대_글자수를_초과한_경우() {
        ValidationMode carName = ValidationMode.CAR_NAME;
        String input;

        carName.max = 4;
        input = "hello,world";

        assertThatThrownBy(() -> InputValidator.validate(carName, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_CAR_NAME_LENGTH_MESSAGE);
    }

    @Test
    void 자동차_이름의_길이가_최소_글자수_미만인_경우() {
        ValidationMode carName = ValidationMode.CAR_NAME;
        String input;

        carName.min = 2;
        input = "k,i,m";

        assertThatThrownBy(() -> InputValidator.validate(carName, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_CAR_NAME_LENGTH_MESSAGE);
    }

    @Test
    void 자동차_이름을_입력하지_않은_경우() {
        ValidationMode carCount = ValidationMode.CAR_COUNT;
        String input;

        input = "";

        assertThatThrownBy(() -> InputValidator.validate(carCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(EMPTY_CAR_NAME_MESSAGE);
    }

    @Test
    void 자동차의_수가_최소_등록해야_히는_자동차수_미만인_경우() {
        ValidationMode carCount = ValidationMode.CAR_COUNT;
        String input;

        carCount.min = 2;
        input = "1";

        assertThatThrownBy(() -> InputValidator.validate(carCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_CAR_COUNT_MESSAGE);
    }

    @Test
    void 자동차의_수가_최대로_등록_가능한_자동차수를_초과한_경우() {
        ValidationMode carCount = ValidationMode.CAR_COUNT;
        String input;

        carCount.max = 3;
        input = "1,2,3,4";

        assertThatThrownBy(() -> InputValidator.validate(carCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_CAR_COUNT_MESSAGE);
    }

    @Test
    void 실행_횟수를_음수로_입력한_경우() {
        ValidationMode gameCount = ValidationMode.GAME_ROUND;
        String input;

        input = "-1";

        assertThatThrownBy(() -> InputValidator.validate(gameCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_GAME_ROUND_MESSAGE);
    }

    @Test
    void 실행_횟수를_문자로_입력한_경우() {
        ValidationMode gameCount = ValidationMode.GAME_ROUND;
        String input;

        input = "다섯번";

        assertThatThrownBy(() -> InputValidator.validate(gameCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_GAME_ROUND_MESSAGE);
    }

    @Test
    void 실행_횟수를_소수로_입력한_경우() {
        ValidationMode gameCount = ValidationMode.GAME_ROUND;
        String input;

        input = "1.4";

        assertThatThrownBy(() -> InputValidator.validate(gameCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_GAME_ROUND_MESSAGE);
    }

    @Test
    void 실행_횟수가_최소로_등록해야_하는_수_미만인_경우() {
        ValidationMode gameCount = ValidationMode.GAME_ROUND;
        String input;

        gameCount.min = 5;
        input = "4";

        assertThatThrownBy(() -> InputValidator.validate(gameCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_GAME_ROUND_MESSAGE);
    }

    @Test
    void 실행_횟수가_최대로_등록_가능한_수를_초과한_경우() {
        ValidationMode gameCount = ValidationMode.GAME_ROUND;
        String input;

        gameCount.max = 100;
        input = "101";

        assertThatThrownBy(() -> InputValidator.validate(gameCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_GAME_ROUND_MESSAGE);
    }
}
