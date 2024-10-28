package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindMaxDistanceTest {
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }

    @Test
    @DisplayName("서로 다른 거리를 이동한 자동차들 중 최대 이동 거리")
    void findMaxDistance_WithDifferentDistances_ShouldReturnHighestDistance() {
        // given
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("Car A");
        car1.moveForward();
        car1.moveForward();

        Car car2 = new Car("Car B");
        car2.moveForward();

        Car car3 = new Car("Car C");
        car3.moveForward();
        car3.moveForward();
        car3.moveForward();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // when
        int maxDistance = gameService.findMaxDistance(cars);

        // then
        assertEquals(3, maxDistance);
    }

    @Test
    @DisplayName("모든 자동차가 동일한 거리를 이동했을 때 해당 거리를 반환")
    void findMaxDistance_WithSameDistances_ShouldReturnCommonDistance() {
        // given
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("Car A");
        car1.moveForward();
        car1.moveForward();
        car1.moveForward();

        Car car2 = new Car("Car B");
        car2.moveForward();
        car2.moveForward();
        car2.moveForward();

        Car car3 = new Car("Car C");
        car3.moveForward();
        car3.moveForward();
        car3.moveForward();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // when
        int maxDistance = gameService.findMaxDistance(cars);

        // then
        assertEquals(3, maxDistance);
    }
}