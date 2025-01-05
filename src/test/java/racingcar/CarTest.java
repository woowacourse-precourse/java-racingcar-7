package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차 이름 유효성 검사 - 이름이 5자 초과이거나 빈 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "123456", ""})
    void carTest1(String carName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car(carName);
        });
    }

    @DisplayName("자동차가 MINIMUM_MOVE_VALUE 이상일 때만 전진하는지 테스트")
    @Test
    void carTest2() {
        Car car1 = new Car("aa");
        Car car2 = new Car("bb");
        Car car3 = new Car("cc");
        Car car4 = new Car("dd");

        car1.move(1);
        car2.move(3);
        car3.move(Car.MINIMUM_MOVE_VALUE);
        car4.move(Car.MINIMUM_MOVE_VALUE + 1);

        assertThat(car1.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);
        assertThat(car3.getPosition()).isEqualTo(1);
        assertThat(car4.getPosition()).isEqualTo(1);
    }


}