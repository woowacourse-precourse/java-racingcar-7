package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameServiceTest {
    private RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameService();
    }

    @Test
    void 라운드별_자동차_위치_업데이트_테스트() {
        String carNamesInput = "pobi,woni,jun";
        List<Car> cars = racingGameService.createCars(carNamesInput);

        cars.get(0).decideToMove(4);
        cars.get(1).decideToMove(5);
        cars.get(2).decideToMove(3);

        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isZero();
    }

    @Test
    void 모든_자동차_정지_테스트() {
        String carNamesInput = "pobi,woni,jun";
        List<Car> cars = racingGameService.createCars(carNamesInput);

        cars.forEach(car -> car.decideToMove(3));
        cars.forEach(car -> assertThat(car.getPosition()).isZero());
    }

    @Test
    void 모든_자동차_전진_테스트() {
        String carNamesInput = "pobi,woni,jun";
        List<Car> cars = racingGameService.createCars(carNamesInput);

        cars.forEach(car -> car.decideToMove(4));
        cars.forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
    }
}
