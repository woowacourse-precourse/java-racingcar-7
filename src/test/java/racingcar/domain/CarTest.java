package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("Car 객체를 성공적으로 생성한다.")
    void successfullyCreateCar() {
        //given
        String carName = "song";

        //when then
        assertDoesNotThrow(() -> new Car(carName));
    }

    @Nested
    @DisplayName("position에게 2번 움직임을 요청했을 때")
    class whenPositionMoveForward {

        @Test
        @DisplayName("2번 모두 안움직이는 경우")
        void successfullyNoMoveCarToString() {
            //given
            String carName = "song";
            String expected = "song : \n";

            //when
            Car car = new Car(carName);
            car.moveForward(0);
            car.moveForward(1);
            String actual = car.toString();

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("1번 움직이고, 1번 안움직이는 경우")
        void successfullyOneMoveCarToString() {
            //given
            String carName = "song";
            String expected = "song : -\n";

            //when
            Car car = new Car(carName);
            car.moveForward(0);
            car.moveForward(9);
            String actual = car.toString();

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("2번 움직이는 경우")
        void successfullyTwoMoveCarToString() {
            //given
            String carName = "song";
            String expected = "song : --\n";

            //when
            Car car = new Car(carName);
            car.moveForward(4);
            car.moveForward(9);
            String actual = car.toString();

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }
}