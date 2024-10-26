package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("사용자 입력 테스트")
class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi, woni, jun", "pobi , woni , jun"})
    @DisplayName("입력한 자동차 이름이 쉼표(,)로만 구분되는지")
    void carNamesSplitByComma(String input) {
        assertDoesNotThrow(() -> {
           InputValidator.validateCarNames(input);
        });
    } // carNamesSplitByComma

    @ParameterizedTest
    @ValueSource(strings = {"pobi;woni;jun", "pobi,woni;jun", "pobi; woni; jun"})
    @DisplayName("입력한 자동차 이름이 쉼표(,)로만 구분되지 않는다면 예외가 발생하는지")
    void carNamesSplitException(String input) {
        assertThatThrownBy(() -> {
           InputValidator.validateCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_MUST_BE_SPLIT_BY_COMMA);
    } // carNamesSplitException

    @ParameterizedTest
    @ValueSource(strings = {"1", "9"})
    @DisplayName("입력한 시도 횟수가 1~9 사이 숫자인지")
    void raceCountIsNumber(String input) {
        assertDoesNotThrow(() -> {
            InputValidator.validateRaceCount(input);
        });
    } // raceCountIsNumber

    @ParameterizedTest
    @ValueSource(strings = {"네번", "백번", "one", "0", "-1", "10"})
    @DisplayName("입력한 시도 횟수가 1~9 사이가 아니거나 숫자가 아닐 때 예외가 발생하는지")
    void raceCountException(String input) {
        assertThatThrownBy(() -> {
            InputValidator.validateRaceCount(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PREFIX + ErrorMessage.RACE_COUNT_ONLY_CAN_NUMBER);
    } // raceCountException
} // class