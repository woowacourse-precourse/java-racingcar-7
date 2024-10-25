package racingcar.application.service;

import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;
import racingcar.application.usecase.RaceExecutionUseCase;
import racingcar.domain.acceleration.RandomAcceleration;
import racingcar.domain.race.Race;
import racingcar.domain.race.service.RaceHelper;

public class RaceExecutionCommand implements RaceExecutionUseCase {

    private final RaceHelper raceHelper;

    public RaceExecutionCommand(RaceHelper raceService) {
        this.raceHelper = raceService;
    }

    @Override
    public RaceResponse runRace(final RaceRequest raceRequest) {
        Race race = Race.of(raceRequest.carNames(), new RandomAcceleration());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < raceRequest.round(); i++) {
            race.lap();
            result.append(race.getResult()).append("\n\n");
        }

        return new RaceResponse(result.toString(), determineWinners(race));
    }

    @Override
    public String determineWinners(Race race) {
        return raceHelper.findWinners(race).stream()
            .map(car -> car.getName())
            .reduce((a, b) -> a + ", " + b)
            .orElse("");
    }
}
