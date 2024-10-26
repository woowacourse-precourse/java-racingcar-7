package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.race.Race;
import racingcar.domain.race.RaceResult;
import racingcar.dto.RaceRequestDTO;
import racingcar.dto.RaceResultDTO;
import racingcar.service.factory.CarFactory;

public class RacingService {

    private final RaceEngine raceEngine;
    private final CarFactory carFactory;

    public RacingService(RaceEngine raceEngine) {
        this.carFactory = new CarFactory();
        this.raceEngine = raceEngine;
    }

    public RaceResultDTO runAllRaces(RaceRequestDTO raceRequestDTO) {
        List<String> names = raceRequestDTO.getNames();
        Race race = new Race(carFactory.getCarList(names));
        List<Race> races = new ArrayList<>(List.of(race));

        for (long l = 0; l < raceRequestDTO.getTimes(); l++) {
            races.add(raceEngine.performRace(races.getLast()));
        }
        RaceResult raceResult = new RaceResult(races);
        return new RaceResultDTO(raceResult.getRaces(), raceResult.getRaceWinnerList());
    }
}
