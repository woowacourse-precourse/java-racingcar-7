package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.WinnerDto;

public class CarsServiceTest {

    private CarsService carsService;
    private String carNames;

    @BeforeEach
    void setUp() {
        carsService = new CarsService();
        carNames = "pobi,woni,jun";
    }

    @Test
    void 자동차_생성_테스트() {
        Cars cars = carsService.createCars(carNames);
        List<Car> carsList = cars.getCars();

        assertThat(carsList.size()).isEqualTo(3);
    }

    @Test
    void 우승자_이름_테스트() {
        Cars cars = carsService.createCars(carNames);
        WinnerDto winners = carsService.getWinnerNames(cars);

        assertThat(winners.names())
                .contains("pobi", "woni", "jun");
    }

}
