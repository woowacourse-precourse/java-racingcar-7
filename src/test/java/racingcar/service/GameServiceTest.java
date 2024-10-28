package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    void setUp() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("carA", 3));
        cars.add(new Car("carB", 5));
        cars.add(new Car("carC", 5));
        gameService = new GameService(cars);
    }

    @Test
    @DisplayName("최대 위치를 가진 자동차 여러대를 반환한다.")
    void getWinners() {
        ArrayList<Car> winners = gameService.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("name")
                .containsExactlyInAnyOrder("carB", "carC");
    }
}