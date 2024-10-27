package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.global.constant.InvalidInputExceptionMessage.*;

import racingcar.global.validator.InputValidator;
import racingcar.global.validator.InputValidator.ValidationMode;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputValidatorTest {
    @Test
    void 자동차_이름의_길이가_최대_글자수를_초과한_경우() {
        ValidationMode carName = ValidationMode.CAR_NAME;
        String input = "a".repeat(carName.getMax() + 1) + ",pobi";
        int minLength = carName.getMin();
        int maxLength = carName.getMax();

        assertThatThrownBy(() -> InputValidator.validate(carName, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(carNameLength(minLength, maxLength));
    }

    @Test
    void 자동차_이름의_길이가_최소_글자수_미만인_경우() {
        ValidationMode carName = ValidationMode.CAR_NAME;
        String input = Stream.of("a".repeat(carName.getMin() - 1),
                        "a".repeat(carName.getMin() - 1))
                .collect(Collectors.joining(","));
        int minLength = carName.getMin();
        int maxLength = carName.getMax();

        assertThatThrownBy(() -> InputValidator.validate(carName, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(carNameLength(minLength, maxLength));
    }

    @Test
    void 자동차_이름을_입력하지_않은_경우() {
        ValidationMode carCount = ValidationMode.CAR_COUNT;
        String input = "";

        assertThatThrownBy(() -> InputValidator.validate(carCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(emptyCarName());
    }

    @Test
    void 자동차의_수가_최소_등록해야_히는_자동차수_미만인_경우() {
        ValidationMode carCount = ValidationMode.CAR_COUNT;
        String input = "1";
        int minCount = carCount.getMin();
        int maxCount = carCount.getMax();

        assertThatThrownBy(() -> InputValidator.validate(carCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(carCount(minCount, maxCount));
    }

    @Test
    void 자동차의_수가_최대로_등록_가능한_자동차수를_초과한_경우() {
        ValidationMode carCount = ValidationMode.CAR_COUNT;
        String input = IntStream.range(1, carCount.getMax() + 2)
                .mapToObj(i -> "car" + i)
                .collect(Collectors.joining(","));
        int minCount = carCount.getMin();
        int maxCount = carCount.getMax();

        assertThatThrownBy(() -> InputValidator.validate(carCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(carCount(minCount, maxCount));
    }

    @Test
    void 실행_횟수를_음수로_입력한_경우() {
        ValidationMode gameCount = ValidationMode.GAME_ROUND;
        String input = "-1";

        assertThatThrownBy(() -> InputValidator.validate(gameCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(gameRoundNotNaturalNumber());
    }

    @Test
    void 실행_횟수를_문자로_입력한_경우() {
        ValidationMode gameCount = ValidationMode.GAME_ROUND;
        String input = "다섯번";

        assertThatThrownBy(() -> InputValidator.validate(gameCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(gameRoundNotNaturalNumber());
    }

    @Test
    void 실행_횟수를_소수로_입력한_경우() {
        ValidationMode gameCount = ValidationMode.GAME_ROUND;
        String input = "1.4";

        assertThatThrownBy(() -> InputValidator.validate(gameCount, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(gameRoundNotNaturalNumber());
    }

    @Test
    void 실행_횟수가_최소로_등록해야_하는_수_미만인_경우() {
        ValidationMode gameRound = ValidationMode.GAME_ROUND;
        String input = String.valueOf(gameRound.getMin() - 1);
        int minRound = gameRound.getMin();
        int maxRound = gameRound.getMax();

        assertThatThrownBy(() -> InputValidator.validate(gameRound, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(gameRoundRange(minRound, maxRound));
    }

    @Test
    void 실행_횟수가_최대로_등록_가능한_수를_초과한_경우() {
        ValidationMode gameRound = ValidationMode.GAME_ROUND;
        String input = String.valueOf(gameRound.getMax() + 1);
        int minRound = gameRound.getMin();
        int maxRound = gameRound.getMax();

        assertThatThrownBy(() -> InputValidator.validate(gameRound, input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(gameRoundRange(minRound, maxRound));
    }
}
