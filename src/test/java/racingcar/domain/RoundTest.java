package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    private Round round;
    @BeforeEach
    public void set(){
        round = new Round();
    }

    @Test
    public void 차_넣기(){
        round.addCarLocation("pobi", 5);
        Map<String, Integer> carLocation = round.getCarLocation();
        assertTrue(carLocation.containsKey("pobi"));
        assertEquals(5, carLocation.get("pobi"));
    }

    @Test
    public void 차_두대_넣기() {
        round.addCarLocation("pobi", 5);
        round.addCarLocation("jun", 3);
        Map<String, Integer> carLocation = round.getCarLocation();
        assertEquals(5, carLocation.get("pobi"));
        assertEquals(3, carLocation.get("jun"));
    }
}