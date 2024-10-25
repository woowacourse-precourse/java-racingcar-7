package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.TheCarDoesntStartException;
import racingcar.model.Car;

class GameServiceTest {

    private GameService gameService;

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
            List<Car> cars = new ArrayList<>();
            Car bmw = new Car("BMW");
            bmw.move();
            Car audi = new Car("Audi");
            audi.move();
            cars.add(bmw);
            cars.add(audi);
            assertSimpleTest(() ->
                    assertEquals(cars, gameService.winners(cars))
            );
        }

        @Test
        void 단일_1등_테스트() {
            List<Car> cars = new ArrayList<>();
            Car bmw = new Car("BMW");
            bmw.move();
            Car audi = new Car("Audi");
            cars.add(bmw);
            cars.add(audi);

            List<Car> winner = new ArrayList<>();
            winner.add(bmw);
            assertSimpleTest(() ->
                    assertEquals(winner, gameService.winners(cars))
            );
        }

        @Test
        void 출발_안한_경우_테스트() {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("BMW"));
            cars.add(new Car("Audi"));
            assertSimpleTest(() ->
                    assertThrows(TheCarDoesntStartException.class, () -> gameService.winners(cars))
            );
        }
    }
}