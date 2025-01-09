package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Car.createDefaultCar;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.FakeGenerator;
import util.RandomGenerator;

class CarTest {

    @DisplayName("자동차 이름 유효성 검사 - 이름이 5자 초과이거나 빈 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "123456", ""})
    void carTest1(String carName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            createDefaultCar(carName, new RandomGenerator());
        });
    }

    @DisplayName("자동차가 MINIMUM_MOVE_VALUE 이상일 때만 전진하는지 테스트")
    @Test
    void carTest2() {
        Car car1 = createDefaultCar("aa", new FakeGenerator(100));
        Car car2 = createDefaultCar("bb", new FakeGenerator(1));
        Car car3 = createDefaultCar("cc", new FakeGenerator(10));
        Car car4 = createDefaultCar("dd", new FakeGenerator(1));

        car1.move();
        car2.move();
        car3.move();
        car4.move();

        Assertions.assertAll(
                () -> assertThat(car1.getPosition()).isEqualTo(1),
                () -> assertThat(car2.getPosition()).isEqualTo(0),
                () -> assertThat(car3.getPosition()).isEqualTo(1),
                () -> assertThat(car4.getPosition()).isEqualTo(0)
        );

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(car1.getPosition()).isEqualTo(1);
        softAssertions.assertThat(car2.getPosition()).isEqualTo(0);
        softAssertions.assertThat(car3.getPosition()).isEqualTo(1);
        softAssertions.assertThat(car4.getPosition()).isEqualTo(0);
        softAssertions.assertAll();
    }
}