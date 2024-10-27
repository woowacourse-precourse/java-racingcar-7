package racingcar.domain.racingcar.service;

import java.util.List;
import racingcar.domain.racingcar.domain.Race;

public interface RaceService {

    static RaceService getInstance() {
        return RaceServiceImpl.getInstance();
    }

    Race createRace(List<String> carNames, int rounds);

    void moveAllCars(Race race);

    List<String> getWinnerNames(Race race);

    List<String> getRaceStatus(Race race);

}
