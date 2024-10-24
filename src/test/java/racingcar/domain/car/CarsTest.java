package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("특정한 자동차만 전진 하는지 검증 한다.")
    public void 특정_자동차만_전진_기능_테스트() {
        // given
        Car car1 = new Car("povi");
        Car car2 = new Car("min");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Cars players = new Cars(carList);

        // when
        players.accelerateSpecificCar(car1);

        // then
        assertEquals(1, car1.getCarInfo().get("povi")); // car1의 위치가 1로 증가했는지 확인
    }

}