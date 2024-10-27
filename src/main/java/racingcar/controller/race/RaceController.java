package racingcar.controller.race;

import racingcar.model.RacingCar;

import java.util.List;

public interface RaceController {
    void readyForRace();
    void advanceCars();
    boolean isFinished();
    void announceWinner();
    void broadcastRace();
    List<RacingCar> getRacingCars();
}
