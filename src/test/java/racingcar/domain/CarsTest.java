package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 이름이 중복이 있으면 예외를 던진다.")
    void carsFromTest() {
        // given
        List<String> carList = List.of("pobi", "pobi", "jun");
        // when// then
        assertThatThrownBy(() -> Cars.from(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("생성된 값이 4이상이면 자동차들 전진한다.")
    void carsMoveTest() {
        // given
        TestNumberGenerator numberGenerator = new TestNumberGenerator();
        List<String> carList = List.of("pobi", "woni", "jun");
        Cars cars = Cars.from(carList);

        // when
        cars.move(numberGenerator);

        // then
        assertThat(cars.getCarList())
                .extracting(Car::getPosition)
                .containsExactly(1, 1, 1);
    }

    @Test
    @DisplayName("차량의 위치를 비교하여 우승자 목록을 반환한다.")
    void getWinnersTest() {
        // given
        List<String> carList = List.of("pobi", "woni", "jun");
        Cars cars = Cars.from(carList);
        List<Car> list = cars.getCarList();
        // when
        Car pobi = list.get(0);
        Car woni = list.get(1);
        pobi.move(4);
        woni.move(4);
        // then
        assertThat(cars.getWinners()).containsExactly("pobi", "woni");
    }

    static class TestNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 4;
        }
    }
}