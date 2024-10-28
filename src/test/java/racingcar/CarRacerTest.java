package racingcar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.model.CarRacer;

class CarRacerTest {

    @Test
    void moveCars() {
        // given
        CarRacer carRacer = new CarRacer(new String[]{"pobi", "crong", "honux"});

        // when
        carRacer.startRace(3);

        // then

        assertTrue(Arrays.stream(carRacer.getCarPositions()).allMatch(position -> position >= 0));
        assertTrue(Arrays.stream(carRacer.getCarPositions()).allMatch(position -> position <= 3));
    }
}