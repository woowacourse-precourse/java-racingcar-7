package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceAnalyzerTest {

    @Test
    void findWinners() {
        //given
        CarRecord car1 = new CarRecord("pobi");
        car1.addMoveCount(5);

        CarRecord car2 = new CarRecord("woni");
        car2.addMoveCount(4);

        List<CarRecord> carRecords = Arrays.asList(car1, car2);
        RaceAnalyzer raceAnalyzer = new RaceAnalyzer();

        //when
        List<String> winners = raceAnalyzer.findWinners(carRecords, 1);
        //then
        assertThat(winners).containsExactly("pobi");
    }
}