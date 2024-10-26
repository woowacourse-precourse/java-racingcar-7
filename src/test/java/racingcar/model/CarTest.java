package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.randomnumber.RandomNumberGenerator;
import racingcar.util.randomnumber.StubRandomNumberGenerator;

class CarTest {

    @DisplayName("이름을 가진 Car를 생성할 수 있다.")
    @Test
    void createCarByName() {
        //given
        String carName = "pobi";

        //when
        Car car = Car.of(carName, new RandomNumberGenerator());

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("Car가 생성될 때 position은 0 이다.")
    @Test
    void createCarSetPositionIsZero() {
        //given
        String carName = "woni";

        //when
        Car car = Car.of(carName, new RandomNumberGenerator());

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("CarName의 크기가 5를 초과하면 예외를 발생한다.")
    @Test
    void carNameLengthExceedThenFive() {
        //given
        String carName = "javaji";

        //when //then
        assertThatThrownBy(() -> Car.of(carName, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("CarName의 크기가 5를 초괴하지 않으면 예외를 발생하지 않는다.")
    @Test
    void carNameLengthLessThenFive() {
        //given
        String carName = "pobii";

        //when //then
        assertThatCode(() -> Car.of(carName, new RandomNumberGenerator()))
                .doesNotThrowAnyException();
    }

    @DisplayName("랜덤값의 크기가 4이상이라면 전진할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"})
    void isMove(int randomNumber, int expectedPosition) {
        //given
        Car car = Car.of("pobi", new StubRandomNumberGenerator(randomNumber));

        //when
        car.isMove();

        //then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}