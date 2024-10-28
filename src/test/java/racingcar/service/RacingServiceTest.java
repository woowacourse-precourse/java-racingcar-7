package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.Winners;

public class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    public void setUp() {
        racingService = new RacingService();
    }

    @Test
    public void 자동차_이름_리스트_Cars_객체_생성() {
        List<String> carNames = List.of("car1", "car2", "car3");

        Cars cars = racingService.enterCars(carNames);

        assertEquals(3, cars.getCars().size());
        assertEquals("car1", cars.getCars().get(0).getName());
        assertEquals("car2", cars.getCars().get(1).getName());
        assertEquals("car3", cars.getCars().get(2).getName());
    }

    @Test
    public void 경주_진행후_Winners_객체_반환_확인() {
        List<String> carNames = List.of("car1", "car2", "car3");
        Cars cars = racingService.enterCars(carNames);
        Race race = Race.of(5);

        Winners winners = racingService.startRace(cars, race);

        List<Car> winnerCars = cars.getWinners();
        int maxDistance = winnerCars.get(0).getDistance();
        winnerCars.forEach(winner -> assertEquals(maxDistance, winner.getDistance()));

        assertTrue(winnerCars.size() > 0);
    }
}
