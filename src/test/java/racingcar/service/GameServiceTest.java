package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

public class GameServiceTest {
    private final GameService gameService = new GameService();

    @Test
    @DisplayName("Cars객체 생성 테스트")
    void createCarsTest() {
        String input = "car1,car2";
        Cars cars = gameService.createCars(input);
        assertThat(cars.getCars().size()).isEqualTo(2);
    }
}
