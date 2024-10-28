package racingcar.application.service;

import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;
import racingcar.application.port.input.ManageRaceUsecase;
import racingcar.domain.acceleration.RandomAcceleration;
import racingcar.domain.race.Race;
import racingcar.domain.race.service.RaceHelper;
import racingcar.domain.race.vo.Round;

public class ManageRaceCommand implements ManageRaceUsecase {

    private final RaceHelper raceHelper;

    public ManageRaceCommand(RaceHelper raceHelper) {
        this.raceHelper = raceHelper;
    }

    @Override
    public RaceResponse run(final RaceRequest raceRequest) {
        Race race = Race.of(raceRequest.carNames(), new RandomAcceleration());
        Round round = raceRequest.round();

        String raceResult = race.runRace(round);
        String winners = raceHelper.findWinners(race);

        return new RaceResponse(raceResult, winners);
    }
}
