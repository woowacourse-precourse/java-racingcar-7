package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(List.of("pobi", "woni", "jun"));
    }

    @Test
    @DisplayName("자동차 리스트 생성 테스트")
    void testInitialIze() {
        assertEquals(3, racingGame.getCars().size());
    }

    @Test
    @DisplayName("자동차 이동 검증 테스트")
    void testGetMaxMoveCount() {
        racingGame.move();
        int maxMoveCount = racingGame.getMaxMoveCount();
        assertTrue(maxMoveCount >= 0);
    }

    @Test
    @DisplayName("우승자 추출 테스트")
    void testGetWinners() {
        racingGame.move();
        int maxMoveCount = racingGame.getMaxMoveCount();
        List<String> winners = racingGame.getWinners(maxMoveCount);
        assertFalse(winners.isEmpty());
    }
}
