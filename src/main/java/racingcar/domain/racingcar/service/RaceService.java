package racingcar.domain.racingcar.service;

import java.util.List;
import racingcar.domain.racingcar.domain.Race;
import racingcar.domain.racingcar.dto.RaceResult;
import racingcar.domain.racingcar.dto.RaceStatus;

public interface RaceService {

    Race createRace(List<String> carNames, int totalRounds);

    void moveAllCars(Race race);

    void runFullRace(Race race);

    RaceResult summarizeRace(Race race);

    RaceStatus getCurrentStatus(Race race);

}
