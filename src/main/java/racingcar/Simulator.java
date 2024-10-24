package racingcar;

import java.util.List;

public interface Simulator {
    SimulationResult<?> simulate(List<Car> config, int trial);
}
