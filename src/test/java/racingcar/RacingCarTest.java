package racingcar;

import car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    private RacingCar racingCar = new RacingCar();

    @DisplayName("List<String>에서 List<Car>로 변환")
    @Test
    void 자동차_문자열_리스트에서_객체_리스트로_변환() {
        // given
        List<String> separatedCarNameList = List.of("pobi", "woni", "jun");

        // when
        List<Car> carList = racingCar.getCarList(separatedCarNameList);

        // then
        assertThat(carList).hasSize(3)
                .extracting("name")
                .contains("pobi", "woni", "jun");
    }

    @Test
    void 자동차_전진_테스트() {
        // given
        Car car = Car.of("poni");
        int randomResult = 4;

        // when
        racingCar.carMove(car, randomResult);

        // then
        assertThat(car).extracting("name", "position")
                .contains("poni", 1);
    }

    @Test
    void 자동차_멈춤_테스트() {
        // given
        Car car = Car.of("poni");
        int randomResult = 2;

        // when
        racingCar.carMove(car, randomResult);

        // then
        assertThat(car).extracting("name", "position")
                .contains("poni", 0);
    }
}