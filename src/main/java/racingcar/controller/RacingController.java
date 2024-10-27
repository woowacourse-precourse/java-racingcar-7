package racingcar.controller;

import java.util.HashMap;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;
    private static final String INPUT_CAR_NAMES = "inputCarNames";
    private static final String INPUT_RACE_ATTEMPT = "inputRaceAttempt";

    public RacingController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public HashMap<String, String> input() {
        HashMap<String, String> inputInformation = new HashMap<>();

        String inputCarNames = inputView.inputCarNames();
        String inputRaceAttempt = inputView.inputRaceAttempt();
        inputInformation.put(INPUT_CAR_NAMES, inputCarNames);
        inputInformation.put(INPUT_RACE_ATTEMPT, inputRaceAttempt); // 수정된 부분

        return inputInformation;
    }

    public void init(HashMap<String, String> inputInformation) {
        racingCarService.initRacingCars(inputInformation.get(INPUT_CAR_NAMES));
        racingCarService.initRacingAttempt(inputInformation.get(INPUT_RACE_ATTEMPT));
    }

    public String racing() {
        racingCarService.racing();
        return racingCarService.getWinnersMessage();
    }

    public void output(String winnersMessage) {
        outputView.outputWinnersMessage(winnersMessage);
    }

}
