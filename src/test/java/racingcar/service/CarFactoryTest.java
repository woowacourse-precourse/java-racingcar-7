package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarFactoryTest {

    @Test
    @DisplayName("createCars() 테스트")
    void createCars() {
        List<Car> cars = CarFactory.createCars("pobi,woni,jun");

        assertThat(cars).hasSize(3);
        assertThat(cars).extracting(Car::getName).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("쉼표 기준으로 자동차 이름을 분리하는 테스트")
    void shouldParseCarNamesFromCommaSeparatedString() {
        List<Car> cars = CarFactory.createCars("po.bi,jun");

        assertThat(cars).hasSize(2);
        assertThat(cars).extracting(Car::getName).containsExactly("po.bi", "jun");
    }

    @Test
    @DisplayName("변환시 자동차이름의 길이가 5를 초과할 경우 예외 발생")
    void CarNameLengthToLongByException() {
        assertThatThrownBy(() -> CarFactory.createCars("pobi.woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_TOO_LONG);
    }
}