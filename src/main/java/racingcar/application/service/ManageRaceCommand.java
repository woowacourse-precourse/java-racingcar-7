package racingcar.application.service;

import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;
import racingcar.application.port.input.ManageRaceUsecase;
import racingcar.domain.acceleration.RandomAcceleration;
import racingcar.domain.race.Race;
import racingcar.domain.race.service.RaceHelper;

public class ManageRaceCommand implements ManageRaceUsecase {

    private final RaceHelper raceHelper;

    public ManageRaceCommand(RaceHelper raceHelper) {
        this.raceHelper = raceHelper;
    }

    @Override
    public RaceResponse run(final RaceRequest raceRequest) {
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
