package racingcar;

import racingcar.raceDto.RacingRequest;
import racingcar.raceDto.RacingResponse;

public class RacingCarController {

    RacingCarView racingCarView;
    RacingCarModel racingCarModel;

    RacingCarController(RacingCarView racingCarView, RacingCarModel racingCarModel) {
        this.racingCarView = racingCarView;
        this.racingCarModel = racingCarModel;
    }

    public void run() {
        RacingRequest racingRequest = racingCarView.readInput();
        RacingResponse racingResponse = racingCarModel.startRace(racingRequest);
        racingCarView.printResult(racingResponse);
    }
}
