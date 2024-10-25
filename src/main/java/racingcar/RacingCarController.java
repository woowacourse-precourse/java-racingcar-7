package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.raceDto.RacingRequest;
import racingcar.raceDto.RacingResponse;

public class RacingCarController {

    RacingCarView racingCarView = new RacingCarView();
    RacingCarModel racingCarModel = new RacingCarModel();

    RacingCarController(RacingCarView racingCarView, RacingCarModel racingCarModel) {
        this.racingCarView = racingCarView;
        this.racingCarModel = racingCarModel;
    }

    public void run() {
        RacingRequest racingRequest = racingCarView.readInput();
        RacingResponse racingResponse = racingCarModel.startRace(racingRequest);
        racingCarView.printResult();
    }
}
