package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class generateDistanceStatus {  // 클래스명도 테스트 대상 클래스명 + Test로 변경

    @Test
    @DisplayName("자동차가 전진시 거리가 1 증가")
    void moveForward_ShouldIncreaseDistanceByOne() {
        // given
        Car car = new Car("Car A");

        // when
        car.moveForward();

        // then
        assertEquals(1, car.distance);
    }

    @Test
    @DisplayName("이동거리가 2인 자동차의 전진상태를 문자열로 변환")
    void generateStatus_WithDistanceTwo_ShouldReturnCorrectFormat() {
        // given
        Car car = new Car("Car A");
        car.moveForward();
        car.moveForward();

        // when
        String status = car.generateDistanceStatus();

        // then
        assertEquals("Car A : --\n", status);
    }

    @Test
    @DisplayName("이동거리가 0인 자동차의 전진상태 문자열로 변환한다")
    void generateStatus_WithZeroDistance_ShouldReturnNoProgress() {
        // given
        Car car = new Car("Car A");

        // when
        String status = car.generateDistanceStatus();

        // then
        assertEquals("Car A : \n", status);
    }
}