package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("기준값이 4이상이면 차량의 위치가 +1 된다.")
    void carMoveTest() {
        // given
        Car car = new Car("pobi");
        // when
        car.move(4);
        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("기준값이 4미만이면 차량의 위치는 이동하지 않는다.")
    void carNotMoveTest() {
        // given
        Car car = new Car("pobi");
        // when
        car.move(3);
        // then
        assertThat(car.getPosition()).isZero();
    }
}