package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {
    private CarNameValidator carNameValidator;

    @BeforeEach
    void setup() {
        carNameValidator = new CarNameValidator();
    }

    @DisplayName("자동차 이름이 5자 이하면 통과한다")
    @ParameterizedTest
    @ValueSource(strings = {"car1", "car2", "car3", "car4", "kim", "pobi"})
    void validateCarNameLength_success(String input) {
        assertDoesNotThrow(() -> carNameValidator.validateCarNameLength(input));
    }

    @DisplayName("자동차 이름이 5자 이상이면 예외가 발생한다")
    @Test
    void validateCarNameLength_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validateCarNameLength("kimhyunsoo"));
    }

    @DisplayName("문장의 마지막이 콤마(,)로 끝나면 예외가 발생한다")
    @Test
    void validateEnd_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validateEnd("kim,pobi,"));
    }

    @DisplayName("자동차 이름들의 구분자는 콤마(,)다.")
    @ParameterizedTest
    @ValueSource(strings = {"zzz4,zz3,zzz1", "kim,pobi,ori-3", "kim, hyun, soo"})
    void validateDelimiter_throwsException(String input) {
        assertDoesNotThrow(() -> carNameValidator.validateDelimiter(input));
    }

    @DisplayName("자동차 이름들의 구분자가 콤마가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"zz3;zz2;zz1", "kim hyun soo", "pobi 3412; 332"})
    void validateDelimiter_success(String input) {
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validateDelimiter(input));
    }

    @DisplayName("자동차 이름이 빈칸이거나 공백일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void validateNotBlank_throwsException(String input) {
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validateNotBlank(input));
    }

    @DisplayName("자동차 이름에 공백이 있을 경우 예외가 발생한다.")
    @Test
    void validateNoSpace_throwsException() {
        assertThatThrownBy(() -> carNameValidator.validateNoSpace("pobi kim"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 검증 통합테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,june,kim", "ori-4,kimm,aax2"})
    void validateCarNames_success(String input) {
        assertDoesNotThrow(() -> carNameValidator.validateCarNames(input));
    }

    @DisplayName("자동차 이름 검증 통합테스트 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, june, kim", "aa,,d3,4", "", " ", "ooooo3,dd3,jje", "zzz34,kk32,", "kim, hyye, ek2"})
    void validateCarNames_throwsException(String input) {
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validateCarNames(input));
    }
}