package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceFormatter;

public class RaceService {

    public Race doRace(String raceCarNames, String moveCount) {
        Cars cars = new Cars(raceCarNames);
        Race race = new Race(moveCount,cars);
        race.doRace();
        return race;
    }

    public String getRaceResult(Race race){
        String raceHistory = race.getRaceHistory();
        List<String> winners = race.getRaceWinners();
        String raceResult = RaceFormatter.formatRaceResult(winners);
        return raceHistory + System.lineSeparator() + raceResult;
    }
}
