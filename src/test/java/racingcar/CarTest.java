package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Car;
import racingcar.domain.model.value.Distance;

class CarTest {


    @DisplayName("자동차가 전진하면 자동차의 거리가 1 증가한다")
    @Test
    void carFunctionTest() {

        // given
        Car car = Car.create("khan");

        // when
        car.go(() -> true);

        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(new Distance(1));
    }


    @DisplayName("자동차 이름에 알파뱃이 아닌 다른 문자가 들어가면 예외를 발생시킨다")
    @Test
    void nameFormExceptionTest() {

        Assertions.assertThatThrownBy(() -> Car.create("a1"))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> Car.create("a a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5글자를 초과하면 예외를 발생시킨다")
    @Test
    void nameLengthExceptionTest() {

        Assertions.assertThatThrownBy(() -> Car.create("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
