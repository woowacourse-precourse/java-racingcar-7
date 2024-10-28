package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartGameTest {
    private RaceService raceService;
    private OutputView outputView;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
        raceService = new RaceService();
    }

    @Test
    @DisplayName("게임 라운드 실행 테스트")
    void startGame() {
        // Given
        List<Car> cars = Arrays.asList(new Car("Car1"), new Car("Car2"), new Car("Car3"));
        int attemptCount = 3;

        // When
        raceService.startGame(attemptCount, cars);

        // Then
        assertThat(cars).extracting("distance").isNotEmpty(); // 자동차의 거리가 비어있지 않은지 확인
    }
}
