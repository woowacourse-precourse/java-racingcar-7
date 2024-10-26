package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("자동차 초기 위치는 0이어야 한다")
    void 초기위치는_0이다() {
        assertEquals(0, car.getPosition(), "자동차의 초기 위치는 0이어야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 올바르게 설정되어야 한다")
    void 자동차이름이_올바르게_설정된다() {
        assertEquals("pobi", car.getCarName(), "자동차 이름이 올바르게 설정되어야 합니다.");
    }


    @Test
    @DisplayName("4 이상의 숫자에 대해 isSatisfy 메서드는 true를 반환해야 한다")
    void isSatisfy는_4이상일때_true를_반환한다() {
        assertFalse(Car.isSatisfy(3), "isSatisfy 메서드는 4 이상의 숫자에 대해 true를 반환해야 합니다.");
        assertTrue(Car.isSatisfy(5), "isSatisfy 메서드는 4 이상의 숫자에 대해 true를 반환해야 합니다.");
    }
    @Test
    void 이동_테스트() {
        Car car = new Car("pobi");

        assertRandomNumberInRangeTest(
                () -> {
                    car.movePosition();
                    assertThat(car.getPosition()).isEqualTo(0); // MOVING_FORWARD일 때 이동
                },
                STOP
        );

        assertRandomNumberInRangeTest(
                () -> {
                    car.movePosition();
                    assertThat(car.getPosition()).isEqualTo(1); // STOP일 때 이동하지 않음
                },
                MOVING_FORWARD
        );
    }

}