package racingcar.application.service;

import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;
import racingcar.application.port.input.ManageRaceUsecase;
import racingcar.domain.acceleration.Acceleration;
import racingcar.domain.acceleration.RandomAcceleration;
import racingcar.domain.race.Race;
import racingcar.domain.race.service.RaceHelper;
import racingcar.domain.race.vo.RaceResult;
import racingcar.domain.race.vo.Round;
import racingcar.domain.race.vo.Winners;

public class ManageRaceCommand implements ManageRaceUsecase {

    private final RaceHelper raceHelper;
    private final Acceleration acceleration;

    public ManageRaceCommand(RaceHelper raceHelper, Acceleration acceleration) {
        this.raceHelper = raceHelper;
        this.acceleration = acceleration;
    }

    @Override
    public RaceResponse run(final RaceRequest raceRequest) {
        Race race = Race.of(raceRequest.carNames(), acceleration);
        Round round = raceRequest.round();

        RaceResult raceResult = race.runRace(round);
        Winners winners = raceHelper.findWinners(race);

        return new RaceResponse(raceResult, winners);
    }
}
