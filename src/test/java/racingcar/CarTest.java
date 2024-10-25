package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MovementDecider;
import racingcar.domain.RandomMovementDecider;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car1");
    }

    @DisplayName("자동차의 name 값 정상 반환")
    @Test
    void getName() {
        //given
        Car testCar = car;
        //when
        String expectedName = "car1";
        //then
        Assertions.assertThat(testCar.getName()).isEqualTo(expectedName);
    }

    @DisplayName("자동차의 현재 위치 값 정상 반환")
    @Test
    void getCurrentPosition() {
        //given
        Car testCar = car;
        //when
        int expectedPosition = 0;
        //then
        Assertions.assertThat(testCar.getCurrentPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("Random number 4이상 시 1만큼 이동")
    @Test
    void moveOrStop_moveable() {
        //given
        assertRandomNumberInRangeTest(() -> {
                    //given
                    Car testCar = car;
                    MovementDecider movementDecider = new RandomMovementDecider();
                    //when
                    car.moveOrStop(movementDecider);
                    //then
                    Assertions.assertThat(testCar.getCurrentPosition()).isEqualTo(1);
                }
                , 4);
    }

    @DisplayName("Random number 4미만 시 이동하지 않음")
    @Test
    void moveOrStop_not_moveable() {
        //given
        assertRandomNumberInRangeTest(() -> {
                    //given
                    Car testCar = car;
                    MovementDecider movementDecider = new RandomMovementDecider();
                    //when
                    car.moveOrStop(movementDecider);
                    //then
                    Assertions.assertThat(testCar.getCurrentPosition()).isEqualTo(0);
                }
                , 3);
    }
}