package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Cars;

public class GameServiceTest {
    private GameService gameService;


    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }

    @Test
    @DisplayName("Cars객체 생성 테스트")
    void createCarsTest() {
        String input = "car1,car2";
        Cars cars = gameService.createCars(input);
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {",car1", "car2,,car3"})
    @DisplayName("Cars객체 생성 예외 테스트")
    void createCars_InvalidInput_ThrowsException(String input) {
        assertThatThrownBy(() -> gameService.createCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
