package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.dto.RoundResultDto;

public class RaceService {

    public List<RoundResultDto> playRace(Cars cars, int tryCount) {
        List<RoundResultDto> roundResults = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAllCars();
            RoundResultDto roundResult = new RoundResultDto(cars);

            roundResults.add(roundResult);
        }

        return roundResults;
    }

}
