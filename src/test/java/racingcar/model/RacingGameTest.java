package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String[] carNames = {"pobi", "woni", "jun"};
        int tryCount = 5;

        racingGame = new RacingGame(carNames, tryCount);
    }

    @DisplayName("자동차가 올바르게 생성되었는지 확인")
    @Test
    void testCarCreation() {
        // 자동차 리스트의 크기 확인
        assertThat(racingGame.getCars()).hasSize(3);
    }

    @DisplayName("경주 후 우승자 결정")
    @Test
    void testGetWinners() {
        // 경주 시작
        racingGame.start();

        // 우승자가 비어있지 않은지 확인
        String winners = racingGame.getWinners();
        assertThat(winners).isNotEmpty();
    }

    @DisplayName("자동차가 이동하는지 확인")
    @Test
    void testCarMovement() {
        // 초기 상태에서 첫 번째 자동차의 위치 확인
        int initialPosition = racingGame.getCars().get(0).getPosition();

        // 경주 시작
        racingGame.start();

        // 첫 번째 자동차의 위치가 초기 위치보다 증가했는지 확인
        assertThat(racingGame.getCars().get(0).getPosition()).isGreaterThan(initialPosition);
    }
}
