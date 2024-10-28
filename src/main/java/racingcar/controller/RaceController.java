package racingcar.controller;

import java.util.List;
import racingcar.dto.RoundResult;
import racingcar.service.RaceService;
import racingcar.util.Converter;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController(InputView inputView, OutputView outputView, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceService = raceService;
    }

    public void race() {
        String carNamesInput = inputView.inputCarNames();
        String tryCountInput = inputView.inputTryCount();

        List<String> carNameList = Parser.parse(carNamesInput);
        Validator.validateInput(carNameList, tryCountInput);
        int tryCount = Converter.convert(tryCountInput);

        List<RoundResult> roundResults = raceService.raceStart(tryCount, carNameList);
        outputView.printRaceResult(roundResults);
    }

    public void selectWinner() {
        List<String> winners = raceService.getWinners();
        outputView.printWinner(winners);
    }
}
