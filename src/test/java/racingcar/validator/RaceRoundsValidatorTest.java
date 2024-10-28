package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RaceRoundsValidatorTest {

    private final RaceRoundsValidator raceRoundsValidator = new RaceRoundsValidator();

    @ParameterizedTest
    @ValueSource(strings = {"5"})
    void 자연수_문자열(String input) {
        int raceRounds = raceRoundsValidator.validateRoundsInput(input);
        assertThat(raceRounds).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"      5   "})
    void 양끝_공백_자연수_문자열(String input) {
        int raceRounds = raceRoundsValidator.validateRoundsInput(input);
        assertThat(raceRounds).isEqualTo(5);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 예외_테스트_빈_입력_문자열(String input) {
        assertThatThrownBy(() -> raceRoundsValidator.validateRoundsInput(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-5"})
    void 예외_테스트_음수(String input) {
        assertThatThrownBy(() -> raceRoundsValidator.validateRoundsInput(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A"})
    void 예외_테스트_정수_아닌_값(String input) {
        assertThatThrownBy(() -> raceRoundsValidator.validateRoundsInput(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1    5"})
    void 예외_테스트_중간_공백(String input) {
        assertThatThrownBy(() -> raceRoundsValidator.validateRoundsInput(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

}