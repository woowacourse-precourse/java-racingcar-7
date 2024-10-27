package racingcar.vo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFactoryTest {

    private final CarFactory carFactory = new CarFactory();

    @Test
    void createCars_자동차_생성_성공() {
        // given
        String[] carNames = {"pobi", "woni", "ken"};

        // when
        List<Car> cars = carFactory.createCars(carNames);

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars).extracting(Car::getName).containsExactly("pobi", "woni", "ken");
    }

    @Test
    void createCars_자동차이름_중복되면_예외를던진다() {
        // given
        String[] carNames = {"pobi", "woni", "pobi"};

        // when & then
        assertThatThrownBy(() -> carFactory.createCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 중복되었습니다.");
    }

    @Test
    void createCars_자동차이름이_하나일때_자동차생성_성공() {
        // given
        String[] carNames = {"pobi"};

        // when
        List<Car> cars = carFactory.createCars(carNames);

        // then
        assertThat(cars).hasSize(1);
        assertThat(cars).extracting(Car::getName).containsExactly("pobi");
    }

}
