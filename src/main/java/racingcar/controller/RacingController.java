package racingcar.controller;

import racingcar.model.OriginInput;

public class RacingController {
    public void run() {
        /*
        입력, 레이싱, 최종 우승 자동차 출력 수행
        */
        OriginInput originInput = new OriginInput();

        originInput.inputCarNames();
        originInput.inputRaceRounds();
    }
}