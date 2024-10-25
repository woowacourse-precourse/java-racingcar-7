package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.race.*;
import racingcar.util.RandomGenerator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceCarTest {

    @Test
    public void 최종_승리자_동점자_반환_고정값_사용() {
        RacePreparation preparation = new RacePreparation("test1,test2", "2");
        RandomGenerator fixedRandomGenerator = new FixedRandomGenerator(Arrays.asList(5, 5, 5, 5));
        RacePrinter racePrinter = new RacePrinter();
        Movement movement = new Movement(fixedRandomGenerator);

        RaceCar race = new RaceCar(preparation, racePrinter, movement);
        RaceResult result = race.startRacingGame();
        List<String> winners = result.getWinner();

        assertEquals(2, winners.size());
        assertTrue(winners.contains("test1"));
        assertTrue(winners.contains("test2"));
    }

    static class FixedRandomGenerator implements RandomGenerator {
        private List<Integer> fixedValues;
        private int index = 0;

        public FixedRandomGenerator(List<Integer> fixedValues) {
            this.fixedValues = fixedValues;
        }

        @Override
        public int pickNumberInRange(int start, int end) {
            return fixedValues.get(index++);
        }
    }

}