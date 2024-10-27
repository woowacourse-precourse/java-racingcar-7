package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @Test
    void 입력받은_이름을_가진_자동차_객체를_생성한다() {

        // given
        List<String> 자동차_이름_리스트 = List.of("car1", "car2", "car3", "car4");
        CarFactory carFactory = new CarFactory(자동차_이름_리스트);

        // when
        List<Car> cars = carFactory.operateCarFactory();

        // then
        List<String> 자동차_객체의_이름 = cars.stream()
                .map(Car::getName)
                .toList();
        assertEquals(자동차_이름_리스트, 자동차_객체의_이름);
    }
}
