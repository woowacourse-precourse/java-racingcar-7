package racingcar.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UtilsTest {
    @DisplayName("사용자 입력이 비어있을 시 예외 확인")
    @Test
    void checkEmptyInputError(){
        assertThatThrownBy(() -> Utils.checkTryNumberInteger(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("사용자 입력이 null값일 때 예외 확인")
    @Test
    void checkNullInputError(){
        assertThatThrownBy(() -> Utils.checkTryNumberInteger(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @DisplayName("사용자 입력 값 존재 시 정상동작 확인")
    @ValueSource(strings = {"1", "10", "100", "pop,ppp,po", "popopopo"})
    void checkUserInput(String test){
        assertDoesNotThrow(() -> Utils.checkEmptyInput(test));
    }
    @ParameterizedTest
    @DisplayName("정수값 이외 값 입력시 예외 확인")
    @ValueSource(strings = {"d", "_", ""})
    void checkNonIntegerTryNumberError(String test){
        assertThatThrownBy(() -> Utils.checkTryNumberInteger(test))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @DisplayName("정수값 입력시 정상동작 확인")
    @ValueSource(strings = {"1", "10", "100"})
    void checkIntegerTryNumber(String test){
        assertDoesNotThrow(() -> Utils.checkTryNumberInteger(test));
    }

    @ParameterizedTest
    @DisplayName("시도횟수 범위 이외 값 입력시 예외 확인")
    @ValueSource(ints = {-1, 0, 101})
    void checkOverBoundaryTryNumberError(int test){
        assertThatThrownBy(() -> Utils.checkTryNumberRange(test))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @DisplayName("시도횟수 범위 내 값 입력시 정상동작 확인")
    @ValueSource(ints = {1, 10, 100})
    void checkInBoundaryTryNumber(int test){
        assertDoesNotThrow(() -> Utils.checkTryNumberRange(test));
    }
}
