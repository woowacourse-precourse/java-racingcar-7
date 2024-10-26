package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.RoundResult;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundResultTest {

    @Test
    void 라운드_기록을_반환하다() {
        Map<String, Integer> positions = new HashMap<>();
        positions.put("pobi", 0);
        positions.put("woni", 1);
        String expected = "pobi : \n" + "woni : -\n";

        RoundResult roundResult = new RoundResult(positions);

        assertEquals(expected, roundResult.toString());
    }
}
