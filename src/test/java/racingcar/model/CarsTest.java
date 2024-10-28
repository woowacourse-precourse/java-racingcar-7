package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.exception.ErrorMessage.CAR_NAME_DUPLICATION_ERROR;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 경주할_자동차의_이름이_중복되는_경우_예외_처리한다() {
        // given
        List<Car> racingCars = List.of(
                new Car("car1"),
                new Car("car2"),
                new Car("car1")
        );

        // when & then
        assertThatThrownBy(() -> Cars.from(racingCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATION_ERROR);
    }
}