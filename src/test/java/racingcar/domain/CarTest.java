package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("0-3 사이 숫자가 두번 들어오면 움직이지 않는다.")
    void successfullyDoNotMove() {
        //given
        String carName = "song";
        int expected = 0;

        //when
        Car car = new Car(carName);
        car.moveForward(() -> 0);
        car.moveForward(() -> 1);
        int actual = car.getPosition();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("0-3 사이 숫자가 한번, 4-9 사이 숫자가 한번 들어오면 한번 움직인다.")
    void successfullyOneMove() {
        //given
        String carName = "song";
        int expected = 1;

        //when
        Car car = new Car(carName);
        car.moveForward(() -> 0);
        car.moveForward(() -> 9);
        int actual = car.getPosition();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4-9 사이 숫자가 두번 들어오면 두번 움직인다.")
    void successfullyTwoMove() {
        //given
        String carName = "song";
        int expected = 2;

        //when
        Car car = new Car(carName);
        car.moveForward(() -> 4);
        car.moveForward(() -> 9);
        int actual = car.getPosition();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
