package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;
    private final InputValidator inputValidator;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
        this.inputValidator = new InputValidator();
    }

    public void run() {
        String[] carNames = getCarNames();
        String trialCountInput = getTrialCount();

        validateInput(carNames, trialCountInput);
        inputView.close();

        int trialCount = Integer.parseInt(trialCountInput);

        RaceResultDTO raceResultDto = startRace(carNames, trialCount);

        printRaceResults(raceResultDto);
    }

    private String[] getCarNames() {
        outputView.printCarNameInputMessage();
        String carNamesInput = inputView.readLine();
        return splitCarNames(carNamesInput);
    }

    private String[] splitCarNames(String input) {
        return input.split(",");
    }

    private String getTrialCount() {
        outputView.printTrialCountInputMessage();
        return inputView.readLine();
    }

    private void validateInput(String[] carNameInput, String trialCountInput) {
        inputValidator.validateCarName(carNameInput);
        inputValidator.validateTrialCount(trialCountInput);
    }

    private RaceResultDTO startRace(String[] carNames, int trialCount) {
        return racingService.startRace(carNames, trialCount);
    }

    private void printRaceResults(RaceResultDTO raceResultDto) {
        outputView.printRaceProcedure(raceResultDto.raceProcedure());
        outputView.printWinner(raceResultDto.winner());
    }
}