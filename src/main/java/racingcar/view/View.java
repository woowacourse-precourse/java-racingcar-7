package racingcar.view;

import racingcar.domain.race.dto.RaceResultDto;
import racingcar.domain.race.dto.WinnersDto;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    private View() {
        this.inputView = InputView.createInputView();
        this.outputView = OutputView.createOutputView();
    }

    public static View create() {
        return new View();
    }

    public String inputCarNames() {
        outputView.printMessage(Output.INPUT_CARS);
        return inputView.userInput();
    }

    public String inputRaceCount() {
        outputView.printMessage(Output.INPUT_COUNT);
        return inputView.userInput();
    }

    public void outputRaceResultAndWinners(RaceResultDto raceResult, WinnersDto winners) {
        outputView.printResult(raceResult);
        outputView.printWinner(winners);
    }
}
