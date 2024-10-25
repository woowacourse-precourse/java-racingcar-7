package racingcar.simulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimulatorTest {

    Simulator simulator;

    @BeforeEach
    void setUp() {
        int numberOfAttempts = 10;
        List<String> namesOfCars = List.of("pobi", "woni", "seho", "jun");
        simulator = new Simulator(numberOfAttempts, namesOfCars);
    }

    @Test
    void 최소_한명의_우승자를_출력하는지_테스트() {
        simulator.simulate();
    }

}