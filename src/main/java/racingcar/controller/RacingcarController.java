package racingcar.controller;

import static racingcar.exception.InvalidInputException.validateCarNames;
import static racingcar.util.Parsing.*;

import java.util.List;
import java.util.Map;
import racingcar.exception.ExceptionMessage;
import racingcar.exception.InvalidInputException;
import racingcar.model.Racingcar;
import racingcar.model.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final RacingcarService racingcarService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingcarController() {
        this.racingcarService = new RacingcarService();
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    public void run() {
        Racingcar racingcar = new Racingcar(inputView.getCarName());
        int attemptCount = 0;
        try {
            attemptCount = Integer.parseInt(inputView.getAttemptCount());
            InvalidInputException.validateAttemptCount(attemptCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_ONLY_POSITIVE_INTEGER.getMessage());
        }

        String[] carNames = splitCarName(racingcar.getCarName());
        validateCarNames(carNames);

        Map<String, String> player = convertStringArrToMap(carNames);
        racingcarService.startRace(player, attemptCount);
        List<String> winner = racingcarService.pickWinner(player, racingcarService.getMaxDashLength(player));
        outputView.winner(joinWinner(winner));
    }
}
