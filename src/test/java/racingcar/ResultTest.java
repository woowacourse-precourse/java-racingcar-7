package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    private Result result;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        result = new Result();
        cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));
    }

    @Test
    void 우승자_결정_테스트() {
        cars.get(0).advance();
        cars.get(1).advance();
        cars.get(1).advance();
        cars.get(2).advance();

        result.isWinner(cars);

        List<Car> winners = result.winners();
        assertEquals(1, winners.size());
        assertEquals("woni", winners.get(0).carName());
    }

    @Test
    void 공동_우승자_결정_테스트() {
        cars.get(0).advance();
        cars.get(1).advance();
        cars.get(2).advance();

        result.isWinner(cars);

        List<Car> winners = result.winners();
        assertEquals(3, winners.size());
        assertTrue(winners.stream().anyMatch(car -> car.carName().equals("pobi")));
        assertTrue(winners.stream().anyMatch(car -> car.carName().equals("woni")));
        assertTrue(winners.stream().anyMatch(car -> car.carName().equals("jun")));
    }
}
