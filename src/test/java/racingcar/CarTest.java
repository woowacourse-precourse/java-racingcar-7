package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1", "5,1", "9,1"})
    @DisplayName("자동차는 4 이상의 숫자에서만 전진")
    void moveCar(int randomNumber, int expectedPosition) {
        Car car = new Car("pobi");
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

}