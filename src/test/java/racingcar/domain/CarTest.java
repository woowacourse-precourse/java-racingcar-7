package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void carNameShouldNotExceedFiveCharacters() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름은 빈 값이나 공백만으로 구성될 수 없다.")
    void carNameShouldNotBeEmpty() {
        assertThatThrownBy(() -> new Car("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상이면 자동차는 전진한다.")
    void carShouldMoveWhenRandomNumberIsFourOrMore() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 숫자가 4 미만이면 자동차는 멈춘다.")
    void carShouldNotMoveWhenRandomNumberIsLessThanFour() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isZero();
    }
}