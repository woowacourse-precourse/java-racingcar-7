package racingcar.service;

import racingcar.controller.RacingCarController;
import racingcar.dto.request.RacingCarRequest;
import racingcar.dto.response.RacingCarResponse;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

import java.util.List;
import java.util.Map;

public class RacingCarStarter {
    private static final RacingCarController racingCarController = new RacingCarController();

    public void start() {
        Map<String, String> carRacingInfo = InputHandler.consoleInput();
        RacingCarResponse racingCarResponse = racingCarController.runRace(RacingCarRequest.fromMap(carRacingInfo));

        List<Map<String, String>> moveRecords = racingCarResponse.moveRecords();
        OutputHandler.moveRecordsOutput(moveRecords);

        String winners = racingCarResponse.winner();
        OutputHandler.winnerOutput(winners);
    }
}
