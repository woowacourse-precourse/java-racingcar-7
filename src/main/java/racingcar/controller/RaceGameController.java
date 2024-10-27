package racingcar.controller;

import java.util.Set;
import racingcar.util.parser.InputStringParser;
import racingcar.util.parser.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringParser stringParser;

    public RaceGameController(
        final InputView inputView,
        final OutputView outputView,
        final StringParser stringParser
    ){
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringParser = stringParser;
    }

    public void run() {
        String racerNames = requestInputStringRacerName();
        Set<String> parsedRacerNames = stringParser.extractTokens(racerNames);
    }

    private String requestInputStringRacerName() {
        outputView.printAskInputRacerName();
        return inputView.read();
    }
}
