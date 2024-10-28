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

}
