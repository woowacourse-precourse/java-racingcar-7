package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingModelTest {

    private RacingModel model;

    @BeforeEach
    void setUp() {
        model = new RacingModel();
    }

    @Test
    void 우승자_한명_결정_테스트() {
        // Given: 자동차 이름 초기화
        String[] carNames = {"pobi", "woni"};
        model.initializeCars(carNames);

        // When: 특정 자동차만 전진
        model.getCarStates().get(0).move(); // pobi가 한 칸 전진
        model.raceOneRound();

        // Then: pobi가 유일한 우승자인지 확인
        String winner = model.getWinners();
        assertEquals("pobi", winner);
    }

    @Test
    void 우승자_두명_이상_결정_테스트() {
        // Given: 자동차 이름 초기화
        String[] carNames = {"pobi", "woni", "jun"};
        model.initializeCars(carNames);

        // When: pobi와 woni가 동일하게 전진
        model.getCarStates().get(0).move();
        model.getCarStates().get(1).move();
        model.raceOneRound();

        // Then: pobi와 woni가 공동 우승자인지 확인
        String winners = model.getWinners();
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
    }


}