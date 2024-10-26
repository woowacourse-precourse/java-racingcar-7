package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.vo.Name;
import racingcar.vo.Round;

public class RacingController {
    private final InputView inputView;
    private final StringSplitter stringSplitter;
    private final NumberParser numberParser;

    public RacingController(
            InputView inputView,
            StringSplitter stringSplitter,
            NumberParser numberParser
    ) {
        this.inputView = inputView;
        this.stringSplitter = stringSplitter;
        this.numberParser = numberParser;
    }

    public void run() {
        String userInput = inputView.getCarNames();
        List<String> splitString = stringSplitter.split(userInput);
        List<Name> names = splitString.stream().map(Name::from).toList();

        userInput = inputView.getTotalRace();
        Integer parsedNumber = numberParser.parse(userInput);
        Round round = Round.from(parsedNumber);
    }
}
