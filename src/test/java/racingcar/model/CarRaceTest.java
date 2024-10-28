package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    private CarRace carRace = new CarRace();

    @BeforeEach
    void setUp() {
        carRace = new CarRace();
    }

    @Test
    void initialize_test() {
        List<String> names = List.of("pobi", "woni", "jun");

        carRace.initialize(names);

        assertEquals(3, carRace.getCars().size());
        assertEquals("pobi", carRace.getCars().get(0).getName());
        assertEquals("woni", carRace.getCars().get(1).getName());
        assertEquals("jun", carRace.getCars().get(2).getName());
    }

    @Test
    void advanceCars_test() {
        List<String> names = List.of("pobi", "woni");
        carRace.initialize(names);

        carRace.advanceCars(Arrays.asList(true, false));

        assertEquals(1, carRace.getCars().get(0).getMove());
        assertEquals(0, carRace.getCars().get(1).getMove());
    }

    @Test
    void findWinners_test() {
        List<String> names = List.of("pobi", "woni", "jun");
        carRace.initialize(names);
        carRace.advanceCars(Arrays.asList(true, true, false));

        List<Car> winners = carRace.findWinners();

        assertEquals("pobi", winners.get(0).getName());
        assertEquals("woni", winners.get(1).getName());
    }
}