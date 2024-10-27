package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import racingcar.service.RacingCarService;
import racingcar.validator.CarNamesValidator;
import racingcar.validator.TryNumberValidator;
import racingcar.viewer.RacingCarViewer;

public class RacingCarController {

    private final RacingCarViewer racingCarViewer = new RacingCarViewer();
    private final RacingCarService racingCarService = new RacingCarService();
    private final CarNamesValidator carNamesValidator = new CarNamesValidator();
    private final TryNumberValidator tryNumberValidator = new TryNumberValidator();

    public void startRacing() {

        List<String> splitCarNames = getValidatedCarNames();
        int tryNumber = getValidatedTryNumber();

        Map<String, String> racingResult = racingCarService.initializeCarPositions(splitCarNames);

        repeatRacingResult(tryNumber, splitCarNames, racingResult);

        String maxMove = racingCarService.findMaxMove(racingResult);
        List<String> winners = racingCarService.getListRacingWinners(racingResult, maxMove);

        racingCarViewer.showWinners(winners);
    }

    private List<String> getValidatedCarNames() {
        racingCarViewer.promptCarNamesInput();

        String carNames = Console.readLine();
        carNamesValidator.validateCarNamesInput(carNames);

        List<String> splitCarNames = racingCarService.splitCarNames(carNames);
        carNamesValidator.validateCarNamesList(splitCarNames);

        return splitCarNames;
    }

    private int getValidatedTryNumber() {
        racingCarViewer.promptTryNumber();

        String tryNumber = Console.readLine();
        tryNumberValidator.validateTryNumber(tryNumber);

        return Integer.parseInt(tryNumber);
    }

    private void repeatRacingResult(int tryNumber, List<String> splitCarNames, Map<String, String> racingResult) {

        racingCarViewer.showRepeatRacingResult();

        for (int i = 0; i < tryNumber; i++) {
            List<String> canMoveCarList = racingCarService.getListCanMoveCarNames(splitCarNames);
            racingResult = racingCarService.updateCarPositions(racingResult, canMoveCarList);
            racingCarViewer.showFinalRacingResult(racingResult);
        }
    }
}
