package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.validation.ErrorMessage.NOT_PERMIT_SAME_CAR;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarManagerTest {

    @DisplayName("자동차의 이름이 중복되는 경우, 예외를 발생한다")
    @Test
    void exist_same_car_name_then_throw_exception() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            //given
            Car car1 = new Car("pobi");
            Car car2 = new Car("bibim");
            Car car3 = new Car("pobi");
            List<Car> cars = List.of(car1, car2, car3);
            //when, then
            CarManager carManager = new CarManager(cars);
        });
        assertThat(exception.getMessage()).isEqualTo(NOT_PERMIT_SAME_CAR.getMessage());
    }

    @DisplayName("중복된 이름의 자동차가 없는 경우, 성공적으로 CarManager 객체가 만들어진다")
    @Test
    void not_exist_same_car_name_then_pass() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("bibim");
        Car car3 = new Car("kevin");
        List<Car> cars = List.of(car1, car2, car3);
        //when, then
        CarManager carManager = new CarManager(cars);
    }
}
