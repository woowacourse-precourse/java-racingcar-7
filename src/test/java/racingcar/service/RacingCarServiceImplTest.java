package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarServiceImplTest {

    @Test
    @DisplayName("올바른_자동차_이름_테스트1")
    void 올바른_자동차_이름_테스트1() {
        Car car = new Car("woowa");

        assertThat(car)
                .extracting(Car::getName, Car::getMoveCount)
                .containsExactly("woowa", 0);
    }

    @Test
    @DisplayName("올바른_자동차_이름_테스트2")
    void 올바른_자동차_이름_테스트2() {
        Car car = new Car("w   a");

        assertThat(car)
                .extracting(Car::getName, Car::getMoveCount)
                .containsExactly("w   a", 0);
    }

    @Test
    @DisplayName("올바른_자동차_이름_테스트3")
    void 올바른_자동차_이름_테스트3() {
        Car car = new Car("w    ");

        assertThat(car)
                .extracting(Car::getName, Car::getMoveCount)
                .containsExactly("w    ", 0);
    }

    @Test
    @DisplayName("자동차_이름_NULL_테스트")
    void 자동차_이름_NULL_테스트() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차_이름_공백_테스트1")
    void 자동차_이름_공백_테스트1() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차_이름_공백_테스트2")
    void 자동차_이름_공백_테스트2() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차_이름_길이_테스트1")
    void 자동차_이름_길이_테스트1() {
        assertThatThrownBy(() -> new Car("woowacourse"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차_이름_길이_테스트2")
    void 자동차_이름_길이_테스트2() {
        assertThatThrownBy(() -> new Car("woowa   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자_4미만_자동차_이동_테스트")
    void 숫자_4미만_자동차_이동_테스트() {
        Car car = new Car("woowa");

        car.move(3);
        assertThat(car)
                .extracting(Car::getName, Car::getMoveCount)
                .containsExactly("woowa", 0);
    }

    @Test
    @DisplayName("숫자_4미만_자동차_이동_출력_테스트")
    void 숫자_4미만_자동차_이동_출력_테스트() {
        Car car = new Car("woowa");

        car.move(2);
        assertThat(car.toString()).isEqualTo("woowa : ");
    }

    @Test
    @DisplayName("숫자_4이상_자동차_이동_테스트")
    void 숫자_4이상_자동차_이동_테스트() {
        Car car = new Car("woowa");

        car.move(4);
        car.move(0);
        assertThat(car)
                .extracting(Car::getName, Car::getMoveCount)
                .containsExactly("woowa", 1);
    }

    @Test
    @DisplayName("숫자_4이상_자동차_이동_출력_테스트")
    void 숫자_4이상_자동차_이동_출력_테스트() {
        Car car = new Car("woowa");

        car.move(5);
        car.move(9);
        assertThat(car.toString()).isEqualTo("woowa : --");
    }
}