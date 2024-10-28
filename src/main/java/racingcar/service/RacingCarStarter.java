package racingcar.service;

import racingcar.handler.InputHandler;

import java.util.Map;

public class RacingCarStarter {

    public void start() {
        Map<String, String> carRacingInfo = InputHandler.consoleInput();
    }
}
