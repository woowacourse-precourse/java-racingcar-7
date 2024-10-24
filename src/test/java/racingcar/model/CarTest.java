package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.randomnumber.RandomNumberGenerator;
import racingcar.util.randomnumber.StubRandomNumberGenerator;

class CarTest {

    @DisplayName("이름을 가진 Car를 생성할 수 있다.")
    @Test
    void createCarByName() {
        //given
        String carName = "pobi";

        //when
        Car car = Car.from(carName, new RandomNumberGenerator());

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("Car가 생성될 때 position은 0 이다.")
    @Test
    void createCarSetPositionIsZero() {
        //given
        String carName = "woni";

        //when
        Car car = Car.from(carName, new RandomNumberGenerator());

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("CarName의 크기가 5를 초과하면 예외를 발생한다.")
    @Test
    void carNameLengthExceedThenFive() {
        //given
        String carName = "javaji";

        //when //then
        assertThatThrownBy(() -> Car.from(carName, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤값이 4보다 크다면 전진한다.")
    @Test
    void moveForward() {
        //given
        int randomNumber = 4;
        Car car = Car.from("pobi", new StubRandomNumberGenerator(randomNumber));

        //when
        car.isMove();

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤값이 4보다 작다면 전진하지 않는다.")
    @Test
    void notMoveForward() {
        //given
        int randomNumber = 3;
        Car car = Car.from("pobi", new StubRandomNumberGenerator(randomNumber));

        //when
        car.isMove();

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}