package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @Test
    void testExtractName() {
        List<String> carNames = race.extractName("pobi,woni,jun");
        assertEquals(3, carNames.size());
        assertEquals("pobi", carNames.get(0));
        assertEquals("woni", carNames.get(1));
        assertEquals("jun", carNames.get(2));
    }

    @Test
    void testInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            race.extractName("abcdefg,pobi,woni"); // 'abcdefg'는 5자 초과
        });
        assertTrue(exception.getMessage().contains("이름은 5자 이하여야 합니다"));
    }

    @Test
    void testWinnerDetection() {
        race.makeCarsList(List.of("pobi", "woni", "jun"));
        // pobi가 가장 많이 전진했다고 가정
        race.cars.get(0).incCurrentPos();
        race.cars.get(0).incCurrentPos();

        race.cars.get(1).incCurrentPos();
        race.cars.get(2).incCurrentPos();

        List<String> winners = race.findWinner();
        assertEquals(1, winners.size());
        assertEquals("pobi", winners.get(0));
    }

    @Test
    void testMultipleWinners() {
        race.makeCarsList(List.of("pobi", "woni", "jun"));
        // pobi, woni가 같은 거리를 이동했다고 가정
        race.cars.get(0).incCurrentPos();
        race.cars.get(1).incCurrentPos();

        List<String> winners = race.findWinner();
        assertEquals(2, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
    }
}