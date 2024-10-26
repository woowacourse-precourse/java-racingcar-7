package racingcar.service;

import racingcar.controller.RaceController;

public interface RaceControllerFactory {
    RaceController createRaceController();
}
