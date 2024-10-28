package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 저장 및 조회 테스트")
    void carBasicTest() {
        //given
        Car car = new Car("Car");

        //when

        //then
        assertThat(car.getCarName()).isEqualTo("Car");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이동case 테스트")
    void carGoTest() {
        //given
        Car car = new Car("Car");

        //when
        car.go(() -> true);

        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이동 안하는case 테스트")
    void carDoesNotGoTest() {
        //given
        Car car = new Car("Car");

        //when
        car.go(() -> false);

        //then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}