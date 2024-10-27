package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

public class RacingGameControllerTest {
    @Test
    @DisplayName("자동차 이름 리스트로 Cars 객체를 생성해야 한다")
    void testCreateCars() {
        List<String> carNames = Arrays.asList("pobi", "woni");
        Cars cars = RacingGameController.createCars(carNames);

        List<Car> carList = cars.getCarList();
        assertEquals(2, carList.size());
        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
    }

    @Test
    @DisplayName("단일 우승자가 정상적으로 반환되어야 함")
    void testGetWinner_SingleWinner() {
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi", 3),
                new Car("woni", 4),
                new Car("nana", 5)
        ));

        List<Car> winners = cars.getWinners();
        assertEquals(1, winners.size());
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("nana")));
    }

    @Test
    @DisplayName("동점자가 발생하면 모두 반환되어야 함")
    void testGetWinners() {
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi", 3),
                new Car("woni", 5),
                new Car("nana", 5)
        ));

        List<Car> winners = cars.getWinners();
        assertEquals(2, winners.size());
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("woni")));
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("nana")));
    }
}