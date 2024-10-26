package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 객체 테스트")
class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"}, delimiter = ',')
    @DisplayName("전달된 값이 4 이상일 때만 자동차가 이동하는지")
    void moveCar(int power, int position) {
        Car car = new Car("pobi");
        car.move(power);

        assertThat(car.getPosition()).isEqualTo(position);
    } // moveCar
} // class