package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Car.createDefaultCar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.FakeGenerator;

class CarTest {

    @DisplayName("자동차 이름 유효성 검사 - 이름이 5자 초과이거나 빈 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "123456", ""})
    void carTest1(String carName) {
        // when&then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            createDefaultCar(carName);
        });
    }

    @DisplayName("자동차가 MINIMUM_MOVE_VALUE 이상일 때만 전진하는지 테스트")
    @Test
    void carTest2() {
        //given
        Car car1 = createDefaultCar("aa");
        Car car2 = createDefaultCar("bb");
        Car car3 = createDefaultCar("cc");
        Car car4 = createDefaultCar("dd");
        //when
        car1.move(new FakeGenerator(100));
        car2.move(new FakeGenerator(1));
        car3.move(new FakeGenerator(10));
        car4.move(new FakeGenerator(1));
        //then
        Assertions.assertAll(
                () -> assertThat(car1.getPosition()).isEqualTo(1),
                () -> assertThat(car2.getPosition()).isEqualTo(0),
                () -> assertThat(car3.getPosition()).isEqualTo(1),
                () -> assertThat(car4.getPosition()).isEqualTo(0)
        );
    }
}
