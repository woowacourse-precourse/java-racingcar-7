package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("성공 : 자동차 이름이 쉼표로 구분되어 정상적으로 분리된다")
    @Test
    void 자동차_이름_분리_성공_테스트() {
        String[] names = InputValidator.validateCarNames("pobi,woni,jun");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("예외 : 자동차 이름에 공백만 입력되거나 빈 문자열일 때 예외를 발생시킨다")
    @Test
    void 자동차_이름_분리_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(" "));
    }

    @DisplayName("성공 : 자동차 이름이 5자 이하일 경우 정상적으로 검증된다")
    @Test
    void 자동차_이름_길이_성공_테스트() {
        String[] names = InputValidator.validateCarNames("pobi,woni,jun");
        assertThat(names).contains("pobi", "woni", "jun");
    }

    @DisplayName("예외 : 자동차 이름이 5자를 초과하면 예외를 발생시킨다")
    @Test
    void 자동차_이름_길이_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames("자동차이름길이초과"));
    }

    @DisplayName("성공 : 시도 횟수가 양수일 경우 정상적으로 검증된다")
    @Test
    void 유효한_시도_횟수_테스트() {
        int tryCount = InputValidator.validateTryCount("5");
        assertThat(tryCount).isEqualTo(5);
    }

    @DisplayName("예외 : 시도 횟수가 음수일 경우 예외를 발생시킨다")
    @Test
    void 음수_시도_횟수_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryCount("-1"));
    }

    @DisplayName("예외 : 시도 횟수가 숫자가 아닌 형식일 경우 예외를 발생시킨다")
    @Test
    void 잘못된_숫자_형식_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryCount("abc"));
    }

    @DisplayName("예외 : 시도 횟수가 0일 경우 예외를 발생시킨다")
    @Test
    void 시도_횟수_영_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryCount("0"));
    }

    @DisplayName("예외 : 시도 횟수가 공백일 경우 예외를 발생시킨다")
    @Test
    void 시도_횟수_공백_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryCount(" "));
    }
}
