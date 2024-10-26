package racingcar.controller;

import racingcar.service.RacingCarService;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService){
        this.racingCarService = racingCarService;
    }

    public void startRacing(){
        racingCarService.inputRacingCarName();
        racingCarService.inputRacingAttemptsCount();
        racingCarService.passCarNameStringToModel();
        int racingAttemptCount = racingCarService.getRacingAttemptsCount();
        for (int i=0; i < racingAttemptCount; i++){
            racingCarService.startRacing();
        }
        racingCarService.printWinnerResult();
    }

}
