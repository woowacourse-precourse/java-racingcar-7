package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

public class GameServiceTest {

    private GameService gameService;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));
        gameService = new GameService(5, carList);
    }

    @Test
    void 생성된_GameService는_정상적으로_게임_횟수를_반환해야_한다() {
        assertEquals(5, gameService.getPlayCount());
    }

    @Test
    void carProcess는_모든_자동차의_이동_횟수를_갱신해야_한다() {
        List<Car> processedCars = gameService.carProcess();

        for (Car car : processedCars) {
            assertTrue(car.getMoveCount() >= 0);
        }
    }

    @Test
    void increaseMove는_랜덤_값에_따라_이동_횟수를_증가시켜야_한다() {
        Car car = new Car("TestCar");

        int initialMoveCount = car.getMoveCount();
        gameService.increaseMove(car, 4);
        assertEquals(initialMoveCount + 1, car.getMoveCount());

        initialMoveCount = car.getMoveCount();
        gameService.increaseMove(car, 3);
        assertEquals(initialMoveCount, car.getMoveCount());
    }

    @Test
    void getMaxDistance는_가장_멀리_간_자동차의_이동_거리를_반환해야_한다() {
        carList.get(0).move();
        carList.get(0).move();
        carList.get(1).move();

        assertEquals(2, gameService.getMaxDistance());
    }

    @Test
    void determineWinners는_가장_멀리_이동한_자동차를_우승자로_설정해야_한다() {
        carList.get(0).move();
        carList.get(0).move();
        carList.get(1).move();

        List<Car> winners = gameService.determineWinners();

        assertEquals(1, winners.size());
        assertEquals("Car1", winners.get(0).getName());
    }

    @Test
    void 복수의_자동차가_동일한_최대_거리를_이동한_경우_모두가_우승자가_되어야_한다() {
        carList.get(0).move();
        carList.get(0).move();
        carList.get(1).move();
        carList.get(1).move();

        List<Car> winners = gameService.determineWinners();

        assertEquals(2, winners.size());
        assertEquals("Car1", winners.get(0).getName());
        assertEquals("Car2", winners.get(1).getName());
    }
}