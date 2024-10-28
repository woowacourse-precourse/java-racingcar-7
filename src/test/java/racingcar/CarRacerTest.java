package racingcar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.CarRacer;

class CarRacerTest {

    @Test
    void moveCars() {
        // given
        CarRacer carRacer = new CarRacer(List.of("pobi", "crong", "honux"));

        // when
        carRacer.startRace(3);

        // then
        assertTrue(carRacer.getCarPositions().values().stream().allMatch(position -> position >= 0));
        assertTrue(carRacer.getCarPositions().values().stream().allMatch(position -> position <= 3));
    }
}