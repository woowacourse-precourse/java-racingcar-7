package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void beforeEach() {
        raceService = new RaceService();
    }

    @Test
    @DisplayName("자동차 이름으로 Car 객체 리스트를 생성하는 테스트")
    void createCars() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");

        // when
        List<Car> cars = raceService.createCars(carNames);

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getCarName()).isEqualTo("pobi");
        assertThat(cars.get(1).getCarName()).isEqualTo("woni");
        assertThat(cars.get(2).getCarName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("자동차 이동 조건에 따른 거리 증가 테스트")
    void raceOnce() {
        // given
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        List<Car> cars = Arrays.asList(pobiCar, woniCar);

        // when
        raceService.raceOnce(cars);

        // then
        assertThat(pobiCar.getCurrentDistance()).isBetween(0, 1);
        assertThat(woniCar.getCurrentDistance()).isBetween(0, 1);
    }

    @Test
    @DisplayName("단일 우승자 이름 리스트를 반환하는 테스트")
    void determineWinners_singleWinner() {
        // given
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        pobiCar.increaseDistance();
        woniCar.increaseDistance();
        woniCar.increaseDistance();
        List<Car> cars = Arrays.asList(pobiCar, woniCar);

        // when
        List<String> winnerNames = raceService.determineWinners(cars);

        // then
        assertThat(winnerNames).containsExactly("woni");
    }
}