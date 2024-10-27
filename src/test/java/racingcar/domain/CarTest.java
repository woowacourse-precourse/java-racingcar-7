package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "입력:{0} -> 위치:{1}")
    @CsvSource(value = {"4,1", "3,0"})
    @DisplayName("기준값이 4이상이면 차량의 위치가 +1 되고, 3이하이면 멈춘다.")
    void carMoveTest(int value, int position) {
        // given
        Car car = new Car("pobi");
        // when
        car.move(value);
        // then
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("차량에 위치가 같다면 ture가 반환된다.")
    void isSamePositionTrueTest() {
        // given
        Car car = new Car("pobi");
        car.move(0);
        // when
        boolean result = car.isSamePosition(new Car("woni"));
        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("차량에 위치가 다르다면 False가 반환된다.")
    void isSamePositionFalseTest() {
        // given
        Car car = new Car("pobi");
        car.move(4);
        // when
        boolean result = car.isSamePosition(new Car("woni"));
        // then
        assertThat(result).isFalse();
    }
}