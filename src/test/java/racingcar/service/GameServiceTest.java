package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.constant.RegisterCarNumberConstant.PRIME_CAR_DISTANCE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.TheCarDoesntStartException;
import racingcar.model.Car;
import racingcar.model.Cars;

class GameServiceTest {

    private GameService gameService;
    private static final String BMW = "BMW";
    private static final String AUDI = "Audi";

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }

    @Nested
    @DisplayName("이동 메소드 테스트")
    class MovingMethodTests {

        @Test
        void 이동_기능_테스트() {
            assertRandomNumberInRangeTest(() ->
                    assertTrue(gameService.isMoving()),5, 9);
        }

        @Test
        void 정지_기능_테스트() {
            assertRandomNumberInRangeTest(() ->
                    assertFalse(gameService.isMoving()),0, 1);
        }
    }

    @Nested
    @DisplayName("자동차 경주 결과 메소드 테스트")
    class RaceResultMethodTests {

        @Test
        void 공동_1등_테스트() {
            List<Car> addCars = List.of(new Car(BMW, 1), new Car(AUDI, 1));
            Cars cars = new Cars(addCars);

            assertSimpleTest(() ->
                    assertEquals(cars.carsToName(), gameService.winners(cars))
            );
        }

        @Test
        void 단일_1등_테스트() {
            List<Car> addCars = List.of(new Car(BMW, 1), new Car(AUDI, PRIME_CAR_DISTANCE.getValue()));
            Cars cars = new Cars(addCars);

            List<Car> addWinnerCars = List.of(new Car(BMW, 1));
            Cars expectedWinner = new Cars(addWinnerCars);

            assertSimpleTest(() ->
                    assertEquals(expectedWinner.carsToName(), gameService.winners(cars))
            );
        }

        @Test
        void 출발_안한_경우_테스트() {
            List<Car> addCars = new ArrayList<>();
            addCars.add(new Car(BMW, PRIME_CAR_DISTANCE.getValue()));
            addCars.add(new Car(AUDI, PRIME_CAR_DISTANCE.getValue()));
            Cars cars = new Cars(addCars);

            assertSimpleTest(() ->
                    assertThrows(TheCarDoesntStartException.class, () -> gameService.winners(cars))
            );
        }
    }
}