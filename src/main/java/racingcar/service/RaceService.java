package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Race;

public class RaceService {

    public Race doRace(String raceCarNames, String moveCount) {
        Cars cars = new Cars(raceCarNames);
        Race race = new Race(moveCount,cars);
        race.doRace();
        return race;
    }
}
