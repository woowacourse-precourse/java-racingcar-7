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
        List<String> carNames = raceRequestDTO.getNames();
        long raceTimes = raceRequestDTO.getTimes();
        List<Race> races = new ArrayList<>();

        Race race = new Race(carFactory.getCarList(carNames));
        for (long l = 0; l < raceTimes; l++) {
            race = raceEngine.performRace(race);
            races.add(race);
        }

        RaceResult raceResult = new RaceResult(races);
        return new RaceResultDTO(raceResult);
    }
}
