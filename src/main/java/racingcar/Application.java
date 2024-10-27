package racingcar;

import java.util.List;
import racingcar.controller.RaceController;
import racingcar.request.RaceCreateRequest;
import racingcar.response.RoundResponse;
import racingcar.response.WinnerResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RaceController controller = new RaceController();

        List<String> names = InputView.getNames();
        int tryCount = InputView.getTryCount();

        RaceCreateRequest request = new RaceCreateRequest(names, tryCount);
        controller.createRace(request);

        OutputView.printStart();
        while (true) {
            RoundResponse roundResult = controller.playRound();
            OutputView.printRoundResult(roundResult);

            if (roundResult.gameEnd()) {
                WinnerResponse winners = controller.getWinner();
                OutputView.printWinners(winners);
                break;
            }
        }
    }
}
