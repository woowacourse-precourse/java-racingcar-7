package racingcar.controller;

import racingcar.service.RacingCarService;

/*
* 자동차 경주를 시작하는 클래스
 */
public class RacingCarController {

    public void startRacing() {
        RacingCarService racingCarService = new RacingCarService();
        racingCarService.moveRacingCarAndPrintResult();
    }

}
