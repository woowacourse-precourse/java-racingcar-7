package racingcar.view;

import java.util.List;
import racingcar.model.RacingCarSnapShot;
import racingcar.view.io.InputHandler;
import racingcar.view.io.OutputHandler;

public class RacingCarView {
    public InputHandler inputHandler = new InputHandler();
    public OutputHandler outputHandler = new OutputHandler();

    public List<String> getRacingCarNames() {
        outputHandler.showCarNameInputComment();
        return inputHandler.getCarNamesFromUser();
    }

    public int getAttemptCount() {
        outputHandler.showAttemptCountInputComment();
        return inputHandler.getAttemptCount();
    }

    public void showRaceResultComment() {
        outputHandler.showRaceResultComment();
    }

    public void showRaceResult(List<RacingCarSnapShot> snapShots) {
        outputHandler.showRaceResult(snapShots);
    }

    public void showWinners(List<String> winners) {
        outputHandler.showWinners(winners);
    }

}
