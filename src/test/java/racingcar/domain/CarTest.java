package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car1");
    }

    @DisplayName("자동차의 이름을 정상적으로 반환한다")
    @Test
    void 자동차_이름_반환() {
        //given
        Car testCar = car;
        //when
        String expectedName = "car1";
        //then
        Assertions.assertThat(testCar.getName()).isEqualTo(expectedName);
    }

    @DisplayName("자동차의 현재 위치를 정상적으로 반환한다")
    @Test
    void 자동차_위치_반환() {
        //given
        Car testCar = car;
        //when
        int expectedPosition = 0;
        //then
        Assertions.assertThat(testCar.getCurrentPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("랜덤 숫자가 4 이상이면 자동차가 1만큼 이동한다")
    @Test
    void 랜덤_숫자_4이상_이동() {
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

    @DisplayName("랜덤 숫자가 4 미만이면 자동차가 이동하지 않는다")
    @Test
    void 랜덤_숫자_4미만_정지() {
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
