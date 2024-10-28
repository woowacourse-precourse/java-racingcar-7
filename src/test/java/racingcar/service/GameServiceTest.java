package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.GameData;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class GameServiceTest {

    private final CarService carService = new CarService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private GameService createGameService() {
        return new GameService(carService, inputView, outputView);
    }

    @Test
    @DisplayName("게임 데이터가 올바르게 생성되어야 한다.")
    void getGameData_shouldReturnGameData() throws IOException {
        // Given
        String[] carNames = {"pobi", "woni", "jun"};
        int attempts = 5;

        // When
        GameData gameData = new GameData(carService.createCars(String.join(",", carNames)), attempts);

        // Then
        assertThat(gameData.getCars()).hasSize(3);
        assertThat(gameData.getAttempts()).isEqualTo(attempts);
        assertThat(gameData.getCars()).extracting(Car::getName).containsExactly(carNames);
    }

    @Test
    @DisplayName("게임 데이터 생성 중 예외가 발생해야 한다.")
    void getGameData_shouldThrowIOException() {
        // Given
        String[] carNames = {"pobi", "woni", "jun"};
        String invalidAttempts = "notANumber";

        // When & Then
        assertThatThrownBy(() -> {
            int attempts = Integer.parseInt(invalidAttempts); // 예외 발생
            new GameData(carService.createCars(String.join(",", carNames)), attempts);
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("게임 플레이 중 자동차의 위치가 업데이트 되어야 한다.")
    void playGame_shouldUpdateCarPositions() throws IOException {
        // Given
        String[] carNames = {"pobi", "woni"};
        int attempts = 3;
        GameData gameData = new GameData(carService.createCars(String.join(",", carNames)), attempts);
        GameService gameService = createGameService();

        // When
        gameService.playGame(gameData);

        // Then
        assertThat(gameData.getCars()).anyMatch(car -> car.getPosition() > 0);
    }
}
