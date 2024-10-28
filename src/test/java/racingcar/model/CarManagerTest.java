package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {

    private CarManager carManager = new CarManager();

    @BeforeEach
    void setUp() {
        carManager = new CarManager();
    }

    @Test
    void initialize_test() {
        List<String> names = List.of("pobi", "woni", "jun");

        carManager.initialize(names);

        assertEquals(3, carManager.getCars().size());
        assertEquals("pobi", carManager.getCars().get(0).getName());
        assertEquals("woni", carManager.getCars().get(1).getName());
        assertEquals("jun", carManager.getCars().get(2).getName());
    }

    @Test
    void advanceCars_test() {
        List<String> names = List.of("pobi", "woni");
        carManager.initialize(names);

        carManager.advanceCars(Arrays.asList(true, false));

        assertEquals(1, carManager.getCars().get(0).getMove());
        assertEquals(0, carManager.getCars().get(1).getMove());
    }

    @Test
    void findWinners_test() {
        List<String> names = List.of("pobi", "woni", "jun");
        carManager.initialize(names);
        carManager.advanceCars(Arrays.asList(true, true, false));

        List<Car> winners = carManager.findWinners();

        assertEquals("pobi", winners.get(0).getName());
        assertEquals("woni", winners.get(1).getName());
    }
}