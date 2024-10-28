package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.Car.*;

class CarTest {

    Car car, anotherCar;

    @BeforeEach
    void beforeEach() {
        List<Car> cars = createInstances("Jihyun, Jihye");
        car = cars.get(0);
        anotherCar = cars.get(1);
    }

    @Test
    @DisplayName("기준 숫자 이상이면 전진")
    void executeMove() {
        car.execute(WINNING_BOUNDARY);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("기준 숫자 미만이면 정지")
    void executeStay() {
        car.execute(WINNING_BOUNDARY-1);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 한 대의 현재 상태 문자열 반환 검증")
    void testToString() {
        car.execute(WINNING_BOUNDARY);
        car.execute(WINNING_BOUNDARY);
        assertThat(car.toString()).isEqualTo("Jihyun : --");
    }

    @Test
    @DisplayName("이동 거리가 더 긴 Car가 우선순위 높음")
    void compareDistance() {
        car.execute(WINNING_BOUNDARY);
        car.execute(WINNING_BOUNDARY);
        anotherCar.execute(WINNING_BOUNDARY);
        anotherCar.execute(WINNING_BOUNDARY-1);
        assertThat(car.getDistance()).isEqualTo(2); // car은 이동 거리가 2
        assertThat(anotherCar.getDistance()).isEqualTo(1); // anotherCar은 이동 거리가 1
        assertThat(car.compareTo(anotherCar)).isNegative();
    }

    @Test
    @DisplayName("이동 거리가 같으면 Car 이름 사전식 비교")
    void compareName() {
        car.execute(WINNING_BOUNDARY);
        anotherCar.execute(WINNING_BOUNDARY);
        assertThat(car.getDistance()).isEqualTo(1); // car은 이동 거리가 1
        assertThat(anotherCar.getDistance()).isEqualTo(1); // anotherCar은 이동 거리가 1
        assertThat(car.compareTo(anotherCar)).isPositive(); // Jihye가 Jihyun보다 우선순위 높음
    }
}