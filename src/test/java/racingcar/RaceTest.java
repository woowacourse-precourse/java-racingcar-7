package racingcar;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;

import java.util.HashMap;
import java.util.List;
import racingcar.model.RacingCar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race(List.of("pobi", "woni", "jun"));
    }

    @Test
    @DisplayName("경기 결과가 올바르게 출력되는지 테스트한다.")
    void testRaceResults() {
        HashMap<String, Integer> raceResults = race.retrieveRaceResults();
        assertFalse(raceResults.isEmpty());
    }

    @Test
    @DisplayName("우승자를 올바르게 찾는지 테스트한다.")
    void testFindWinners() {
        List<Integer> moveCountList = new ArrayList<>(List.of(2,5,5));

        TestableRace testableRace = new TestableRace(List.of("pobi", "woni", "jun"), moveCountList);
        List<String> winners = testableRace.findWinners();
        assertEquals(List.of("woni", "jun"), winners);
    }

    private static class TestableRace extends Race {
        public TestableRace(List<String> racingCarsName, List<Integer> moveCountList){
            super(racingCarsName);

            racingCarList = new ArrayList<>(); // 초기화
            int index = 0;
            for (String racingCarName: racingCarsName){
                racingCarList.add(new TestableRacingCar(racingCarName, moveCountList.get(index)));
                index ++;
            }
        }
    }

    private static class TestableRacingCar extends RacingCar {

        public TestableRacingCar(String carName, int fixedMoveCount) {
            super(carName);
            moveCount = fixedMoveCount;
        }
    }
}
