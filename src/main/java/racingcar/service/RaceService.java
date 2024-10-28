package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.dto.RoundResultDto;
import racingcar.wrapper.RaceCount;

public class RaceService {

    public List<RoundResultDto> playRace(Cars cars, RaceCount raceCount) {
        List<RoundResultDto> roundResults = new ArrayList<>();
        int round = 0;

         while (!isEndRace(round++, raceCount)) {
            cars.moveAll();
            RoundResultDto roundResult = new RoundResultDto(cars);

            roundResults.add(roundResult);
        }

        return roundResults;
    }

    private boolean isEndRace(int round, RaceCount raceCount) {
        return round == raceCount.getRaceCount();
    }

}
