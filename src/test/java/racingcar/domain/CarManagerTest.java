package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.RandomNumberGeneratorImpl;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarManagerTest {
    private CarManager carManager;
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGeneratorImpl();
        carManager = new CarManager(randomNumberGenerator);
    }

    // 테스트: 자동차 초기화 기능 검증
    @Test
    void testInitializeCars() {
        String carNames = "pobi,crong,honux";
        carManager.initializeCars(carNames);
        List<String> currentRoundResults = carManager.getCurrentRoundResults();
        assertEquals(3, currentRoundResults.size());
        assertTrue(currentRoundResults.get(0).startsWith("pobi"));
    }

    // 테스트: 라운드 진행 시 자동차 이동 결과 검증
    @Test
    void testPlayRound() {
        String carNames = "pobi,crong,honux";
        carManager.initializeCars(carNames);
        carManager.playRound();
        List<String> currentRoundResults = carManager.getCurrentRoundResults();
        assertEquals(3, currentRoundResults.size());
    }

    // 테스트: 우승자 선정 기능 검증
    @Test
    void testGetWinners() {
        String carNames = "pobi,crong,honux";
        carManager.initializeCars(carNames);
        carManager.playRound();
        List<String> winners = carManager.getWinners();
        assertFalse(winners.isEmpty());
    }
}