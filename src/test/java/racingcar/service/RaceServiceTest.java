package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarGenerator;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.Map;

public class RaceServiceTest {


    @Test
    void 레이스_진행() {
        List<String> carNames = List.of("carA", "carB", "carC");
        Cars cars = CarGenerator.generateCars(carNames, () -> 4);
        List<Car> carList = cars.getCars();

        RaceService raceService = new RaceService(cars, 5);

        List<Map<Car, Integer>> raceResults = raceService.createRaceLogs();
        Map<Car, Integer> round1 = raceResults.get(0);
        Map<Car, Integer> round2 = raceResults.get(1);

        Car carA = carList.get(0);
        Assertions.assertThat(round1.get(carA)).isEqualTo(1);
        Assertions.assertThat(round2.get(carA)).isEqualTo(2);
    }
}
