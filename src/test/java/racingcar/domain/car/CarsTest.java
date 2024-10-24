package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차의 이름이 중복되면 예외가 발생한다.")
    public void 자동차_이름_중복_검증_기능() {
        //given
        Car car1 = new Car("povi");
        Car car2 = new Car("povi");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        //when then
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}