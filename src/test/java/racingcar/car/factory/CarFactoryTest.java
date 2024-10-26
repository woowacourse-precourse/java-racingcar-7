package racingcar.car.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class CarFactoryTest {

    @DisplayName("쉼표로 구분된 이름 문자열을 입력받아 각 이름에 대한 Car 객체 리스트를 생성한다.")
    @Test
    void createCarSetFromNames() {
        // given
        String input = "pobi,woni,jun";

        // when
        Set<Car> cars = CarFactory.createCars(input);

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars).extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }
}
