package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차의 이름이 5보다 크다면 예외가 발생한다.")
    void carNameLengthTest() {
        // given // when // then
        assertThatThrownBy(() -> new Car("pobi12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차 이름은 5자 이하입니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 비어있다면 예외가 발생한다.")
    void carNameEmptyTest() {
        // given // when // then
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차 이름을 입력해주세요.");
    }
}