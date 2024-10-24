package racingcar.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.service.ExtractName;
import racingcar.service.InputValidator;
import racingcar.service.StopAndGo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private final ExtractName extractName;
    private final InputValidator inputValidator;
    private final StopAndGo stopAndGo;
    private final InputView inputView;
    private final OutputView outputView;

    public CarController() {
        this.extractName = new ExtractName();
        this.inputValidator = new InputValidator();
        this.inputView = new InputView();
        this.stopAndGo = new StopAndGo();
        this.outputView = new OutputView();
    }

    public void run() {
        String[] carNames = extractName.extractName(inputView.getInputName()) ;
        if (!inputValidator.validator(carNames)) {
            throw new IllegalArgumentException();
        }
        int tryTimes = inputView.getInputTimes();

        Map<String, boolean[]> carReportCards = new LinkedHashMap<>();
        for (String carName : carNames){
            boolean[] reportCard = stopAndGo.stopAndGo(tryTimes);
            carReportCards.put(carName, reportCard);
        }

        outputView.printReportCards(carReportCards,tryTimes);
        List<String> winners = outputView.calculateWinners(carReportCards);
        outputView.printWinners(winners);

    }
}
