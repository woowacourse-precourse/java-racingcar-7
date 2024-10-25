package racingcar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CarRacerTest {

    @Test
    void moveCars() {
        // given
        CarRacer carRacer = new CarRacer(new String[]{"pobi", "crong", "honux"});

        // when
        carRacer.moveCars(3);

        // then
        for (int i = 0; i < carRacer.getCarPositions().length; i++) {
            System.out.println(carRacer.getCarNames()[i] + " : " + carRacer.getCarPositions()[i]);
        }
        assertTrue(Arrays.stream(carRacer.getCarPositions()).allMatch(position -> position >= 0));
        assertTrue(Arrays.stream(carRacer.getCarPositions()).allMatch(position -> position <= 3));
    }

    @Test
    void getWinners() {

        // given
        CarRacer carRacer = new CarRacer(new String[]{"pobi", "crong", "honux"});

        // when
        carRacer.moveCars(3);

        // then
        for (int i = 0; i < carRacer.getCarPositions().length; i++) {
            System.out.println(carRacer.getCarNames()[i] + " : " + carRacer.getCarPositions()[i]);
        }
        System.out.println(carRacer.getWinners());
    }
}