package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exception.CarPositionOutOfRangeException;
import racingcar.common.exception.IllegalCarNameException;

class CarTest {

    @Test
    @DisplayName("자동차가 이름으로 동등성이 비교되는 테스트")
    void car_Test1() {
        Car genesis1 = new Car("honda");
        Car genesis2 = new Car("honda");
        assertThat(genesis1.equals(genesis2)).isEqualTo(true);
        assertThat(genesis1.hashCode() == genesis2.hashCode()).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차의 이름이 5글자가 넘어 예외를 발생하는 테스트")
    void carNameTest() {
        assertThatThrownBy(() -> new Car("genesis"))
                .isInstanceOf(IllegalCarNameException.class);
    }

    @Test
    @DisplayName("자동차가 전진하는 테스트")
    void car_Test2() {
        Car car = new Car("honda");
        car.forward();
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 위치가 int 범위를 벗어날 때까지 전진하면 에러를 발생하는 테스트")
    void car_Test3() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car("broke");
        Field carPositionField = Car.class.getDeclaredField("carPosition");
        carPositionField.setAccessible(true);
        carPositionField.setInt(car, Integer.MAX_VALUE - 1);
        assertThatThrownBy(car::forward)
                .isInstanceOf(CarPositionOutOfRangeException.class);
    }
}
