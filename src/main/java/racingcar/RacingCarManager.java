package racingcar;

import java.util.List;

public class RacingCarManager implements RacingManager<RacingCar> {

    private final CarRaceParticipants carRaceParticipants;

    public RacingCarManager(CarRaceParticipants carRaceParticipants) {
        this.carRaceParticipants = carRaceParticipants;
    }

    @Override
    public void registerAll(List<RacingCar> racers) {
        carRaceParticipants.addAll(racers);
    }
}
