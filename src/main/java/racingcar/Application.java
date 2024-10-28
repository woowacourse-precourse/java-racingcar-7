package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Game;
import racingcar.domain.GameInitializer;
import racingcar.domain.RoundInformation;
import racingcar.domain.Winners;
import racingcar.ui.InputCarNames;
import racingcar.ui.InputController;
import racingcar.ui.InputGameRoundCount;
import racingcar.ui.OutputController;
import racingcar.ui.ProgressedResult;
import racingcar.ui.UiInitializer;
import racingcar.ui.WinnerResults;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final UiInitializer uiInitializer = new UiInitializer();
        final InputController inputController = uiInitializer.initInputController();
        final OutputController outputController = uiInitializer.initOutputController();

        outputController.printNameInputInformation();
        final InputCarNames inputCarNames = inputController.getInputCarNames();
        outputController.printRoundInputInformation();
        final InputGameRoundCount inputRoundCount = inputController.getInputRoundCount();

        final GameInitializer gameInitializer = new GameInitializer(inputCarNames.getCarNames());
        final Game game = gameInitializer.initGame();

        game.run(inputRoundCount.getRound());

        final List<RoundInformation> roundInformations = game.getAllRoundInformation();
        for (final RoundInformation roundInformation : roundInformations) {
            outputController.printProgressedInfo(roundInformation.getProgressedInformations().stream().map(information -> new ProgressedResult(information)).collect(
                    Collectors.toList()));
        }

        final Winners winners = game.getWinners();
        final WinnerResults winnerResults = new WinnerResults(winners
                .getWinners().stream().map(winner -> winner.getCarName())
                .collect(Collectors.toList()));
        outputController.printWinners(winnerResults);
    }
}
