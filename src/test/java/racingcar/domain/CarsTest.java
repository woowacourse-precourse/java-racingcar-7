package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0", "0,1", "2,2", "2,3", "4,3", "100,101"})
    void 정상적으로_승자를_판단하는가(int position1, int position2) {
        Cars cars = new Cars();
        Car car1 = new Car("pobi", position1);
        Car car2 = new Car("woni", position2);
        cars.add(car1);
        cars.add(car2);
        if (position1 == position2) {
            assertThat(cars.getWinners().get(0)).isEqualTo(car1);
            assertThat(cars.getWinners().get(1)).isEqualTo(car2);
            return;
        }
        if (position1 > position2) {
            assertThat(cars.getWinners().get(0)).isEqualTo(car1);
            assertThat(cars.getWinners().size()).isEqualTo(1);
            return;
        }
        assertThat(cars.getWinners().get(0)).isEqualTo(car2);
        assertThat(cars.getWinners().size()).isEqualTo(1);
    }
}
