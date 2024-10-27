package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class WinnerServiceTest {

    private WinnerService winnerService;
    private List<Car> cars;

    @BeforeEach
    void init() {
        winnerService = new WinnerService();
        cars = getCars();
    }

    @Test
    @DisplayName("우승자한 자동자 이름을 조회")
    void calculateWinners() {
        String winner = winnerService.calculateWinners(cars);
        assertThat(winner).isEqualTo("pobi");
    }

    @Test
    @DisplayName("전진한 최대 거리 조회")
    void findMaxLength() {
        int maxLength = cars.stream()
                .mapToInt(car -> car.getResult().length())
                .max()
                .orElse(0);

        assertThat(maxLength).isEqualTo(3);
    }

    private List<Car> getCars() {
        return Arrays.asList(
                createCarWithResults("pobi", 3),
                createCarWithResults("woni", 2)
        );
    }

    private Car createCarWithResults(String name, int resultCount) {
        Car car = new Car(name);
        for (int i = 0; i < resultCount; i++) {
            car.addResult();
        }
        return car;
    }
}