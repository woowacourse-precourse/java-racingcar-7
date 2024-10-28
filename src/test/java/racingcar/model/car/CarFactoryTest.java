package racingcar.model.car;

import org.junit.jupiter.api.Test;
import racingcar.config.AppConfig;
import racingcar.model.movement.Movement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.Error.NOT_EMPTY_CAR_LIST;

class CarFactoryTest {
    private AppConfig appConfig = new AppConfig();

    @Test
    void 자동차를_생산하면_이름이_올바르게_저장된다() {
        //given
        CarFactory carFactory = appConfig.carFactory();
        Movement movement = appConfig.movement();

        String carName1 = "name1";
        String carName2 = "name2";
        String carName3 = "name3";

        //when
        List<Car> cars
                = carFactory.produceCars(List.of(carName1, carName2, carName3));

        //then
        assertThat(cars)
                .isEqualTo(
                        List.of(Car.of(carName1, movement),
                                Car.of(carName2, movement),
                                Car.of(carName3, movement))
                );
    }

    @Test
    void 빈_리스트를_받으면_예외를_던진다() {
        CarFactory carFactory = appConfig.carFactory();
        assertThatThrownBy(() -> carFactory.produceCars(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_EMPTY_CAR_LIST.getMessage());
    }
}