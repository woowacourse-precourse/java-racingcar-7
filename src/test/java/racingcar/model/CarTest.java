package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Car 객체 테스트")
class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"jjang", "12345", "자동차"})
    @DisplayName("자동차 객체 생성")
    void createCar(String input) {
        assertThat(new Car(input)).isInstanceOf(Car.class);
    } // createCar

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "123456", "jjangi"})
    @DisplayName("자동차 객체 생성 실패")
    void createCarException(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(IllegalArgumentException.class);
    } // createCarException

    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"}, delimiter = ',')
    @DisplayName("전달된 값이 4 이상일 때만 자동차가 이동하는지")
    void moveCar(int power, int expectedPosition) {
        Car car = new Car("pobi");
        car.move(power);

        assertThat(car).extracting("position").isEqualTo(expectedPosition);
    } // moveCar
} // class