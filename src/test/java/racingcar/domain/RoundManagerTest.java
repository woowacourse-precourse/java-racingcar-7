package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoundManagerTest {
    private RoundManager roundManager;

    @BeforeEach
    void setUp() {
        roundManager = new RoundManager();
    }

    // 테스트: 라운드 결과 기록 기능 검증
    @Test
    void testRecordRoundResult() {
        List<String> roundResult = new ArrayList<>();
        roundResult.add("pobi : --");
        roundResult.add("crong : ---");
        roundManager.recordRoundResult(roundResult);
        List<List<String>> allRoundResults = roundManager.getAllRoundResults();
        assertEquals(1, allRoundResults.size());
    }

    // 테스트: 전체 라운드 결과 조회 기능 검증
    @Test
    void testGetAllRoundResults() {
        List<String> roundResult1 = new ArrayList<>();
        roundResult1.add("pobi : --");
        List<String> roundResult2 = new ArrayList<>();
        roundResult2.add("crong : ---");
        roundManager.recordRoundResult(roundResult1);
        roundManager.recordRoundResult(roundResult2);
        List<List<String>> allRoundResults = roundManager.getAllRoundResults();
        assertEquals(2, allRoundResults.size());
    }

    // 테스트: 최신 라운드 결과 조회 기능 검증
    @Test
    void testGetLatestRoundResults() {
        List<String> roundResult = new ArrayList<>();
        roundResult.add("pobi : --");
        roundManager.recordRoundResult(roundResult);
        List<String> latestRoundResults = roundManager.getLatestRoundResults();
        assertEquals(1, latestRoundResults.size());
        assertTrue(latestRoundResults.get(0).startsWith("pobi"));
    }
}
