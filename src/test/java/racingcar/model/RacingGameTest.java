package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    private TestableRacingGame game;
    private static final int ATTEMPTS = 5;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("car1", "car2", "car3");

        // 테스트 전용 TestableRacingGame 생성
        game = new TestableRacingGame(carNames, ATTEMPTS);
    }

    @Test
    @DisplayName("라운드 플레이 - 모든 라운드 종료 후 위치 확인")
    void playAllRoundsAndCheckFinalPosition() {
        // 시도 횟수만큼 모든 라운드를 플레이
        for (int i = 0; i < ATTEMPTS; i++) {
            game.playRound();
        }

        // 모든 자동차의 최종 위치가 시도 횟수와 동일한지 확인
        game.getCars().forEach(car -> assertEquals(ATTEMPTS, car.getPosition(),
                car.getName() + "의 최종 위치는 시도 횟수와 같아야 합니다."));
    }
}
