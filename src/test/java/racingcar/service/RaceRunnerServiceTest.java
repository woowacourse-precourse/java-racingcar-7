package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RaceHistory;

class RaceRunnerServiceTest {

    private RaceRunnerService raceRunnerService;

    @BeforeEach
    void init() {
        raceRunnerService = new RaceRunnerService();
    }

    @Test
    @DisplayName("자동차 경주시 횟수별 기록 저장")
    void test() {
        List<Car> cars = List.of(new Car("tobi"), new Car("abc"));
        RaceHistory raceHistory = raceRunnerService.runRaces(cars, 5);

        assertThat(raceHistory.getRounds()).hasSize(5);
        assertThat(cars.stream().anyMatch(car -> !car.getResult().isEmpty())).isTrue();
    }

    @Test
    @DisplayName("전진 가능할 경우 결과를 저장")
    void shouldAddResultWhenCarsMove() {
        boolean[] shouldMoves = {true, false, true, false}; // 1,3번째 경주일 경우만 이동
        List<Car> cars = List.of(new Car("tobi"), new Car("abc"));

        addResults(cars, shouldMoves);

        assertThat(cars).extracting(Car::getResult).containsExactly("--", "--");
        assertThat(cars).extracting(car -> car.getResult().length()).containsExactly(2, 2);
    }

    private void addResults(List<Car> cars, boolean[] shouldMoves) {
        for (boolean shouldMove : shouldMoves) {
            moveCars(cars, shouldMove);
        }
    }

    private void moveCars(List<Car> cars, boolean shouldMove) {
        for (Car car : cars) {
            if (shouldMove) {
                car.addResult();
            }
        }
    }

}