package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RaceResultService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceResultServiceTest {

    private RaceResultService raceResultService;
    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        raceResultService = new RaceResultService();
        cars = new ArrayList<>();
    }

    @Test
    public void testDetermineWinners_singleWinner() {
        Car car1 = new Car("Car1");
        car1.move();
        car1.move();

        Car car2 = new Car("Car2");
        car2.move();

        Car car3 = new Car("Car3");
        car3.move();
        car3.move();
        car3.move();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<String> winners = raceResultService.determineWinners(cars);

        assertEquals(1, winners.size(), "우승자는 한 명이어야 합니다.");
        assertEquals("Car3", winners.get(0), "우승자는 Car3이어야 합니다.");
    }

    @Test
    public void testDetermineWinners_multipleWinners() {
        Car car1 = new Car("Car1");
        car1.move();
        car1.move();

        Car car2 = new Car("Car2");
        car2.move();
        car2.move();

        Car car3 = new Car("Car3");
        car3.move();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<String> winners = raceResultService.determineWinners(cars);

        assertEquals(2, winners.size(), "우승자는 두 명이어야 합니다.");
        assertEquals(List.of("Car1", "Car2"), winners, "우승자는 Car1과 Car2이어야 합니다.");
    }

    @Test
    public void testDetermineWinners_noWinners() {
        List<String> winners = raceResultService.determineWinners(cars);

        assertEquals(0, winners.size(), "우승자가 없을 때 리스트는 비어 있어야 합니다.");
    }
}
