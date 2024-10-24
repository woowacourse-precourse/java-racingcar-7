package race;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    @Test
    void 자동차_등록() {
        //given
        Race race = new Race(List.of("pobi", "woni"));
        //when
        Map<String, Integer> allProgress = race.getAllProgress();
        //then
        Map<String, Integer> expectedProgress = new HashMap<>();
        expectedProgress.put("pobi", 0);
        expectedProgress.put("woni", 0);
        assertEquals(expectedProgress, allProgress);
    }

    @Test
    void 등록_안된_자동차_진행() {
        //given
        Race race = new Race(List.of());
        //when
        race.updateProgress("pobi");
        //then
        Map<String, Integer> allProgress = race.getAllProgress();
        Map<String, Integer> expectedProgress = new HashMap<>();
        assertEquals(expectedProgress, allProgress);
    }

    @Test
    void 자동차_진행상황_업데이트() {
        //given
        Race race = new Race(List.of("pobi", "woni"));
        //when
        race.updateProgress("pobi");
        race.updateProgress("woni");
        race.updateProgress("woni");
        //then
        Map<String, Integer> output = race.getAllProgress();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("pobi", 1);
        expected.put("woni", 2);
        assertEquals(expected, output);
    }

}