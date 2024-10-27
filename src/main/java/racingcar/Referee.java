package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Referee {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private RacingField racingField;

    public void startGame() {
        prepareGame();
        proceedGame();
        announceWinners();
    }

    private void prepareGame() {
        List<String> carNames = inputView.inputCarName();
        List<Car> entry = new ArrayList<>();
        for (String carName : carNames) {
            entry.add(new Car(new RandomEngine() ,carName));
        }
        racingField = new RacingField(new Cars(entry));
    }

    private void proceedGame() {
        final int turn = inputView.inputRacingTurn();
        for (int i = 0; i < turn; i++) {
            racingField.activeRound();
            outputView.printRacing(racingField.getCarPositions());
        }
    }
}
