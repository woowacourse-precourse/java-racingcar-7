package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingSimulationTest {

    @Test
    void simulateRace() {
        //given
        RacingSimulation racingSimulation = new RacingSimulation();
        List<String> carNames = Arrays.asList("pobi","woni");
        int tryCount = 3;

        //when
        List<CarRecord> raceResult = racingSimulation.simulateRace(carNames, tryCount);

        //then
        assertThat(raceResult).hasSize(2);
    }
}