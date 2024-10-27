package racingcar.car.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.message.ExceptionMessage;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static racingcar.message.ExceptionMessage.*;

public class CarFactoryTest {

    @DisplayName("쉼표로 구분된 이름 문자열을 입력받아 각 이름에 대한 Car 객체 Set을 생성한다.")
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

    @DisplayName("같은 이름이 문자열에 포함되어 있으면 예외가 발생한다")
    @Test
    void duplicatedNameTest(){
        // given
        final String input = "pobi,pobi,jun";

        // when, then
        assertThatThrownBy( () -> CarFactory.createCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_CAR_NAME.getMessage());
    }
}
