package racingcar.model.util;

import racingcar.model.simulator.SimulationResult;

public interface Simulator<I,O> {
    SimulationResult<O> simulate(I config, int trial);
}
