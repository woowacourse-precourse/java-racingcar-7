package racingcar.mvc.controller;

import java.math.BigInteger;
import java.util.List;
import racingcar.mvc.controller.racingGameManager.RacingGameManager;
import racingcar.mvc.model.observer.Racer;
import racingcar.mvc.model.subject.RacingGameRound;
import racingcar.mvc.validation.input.AttemptNumberValidator;
import racingcar.mvc.validation.input.CarNameValidator;
import racingcar.mvc.view.InputView;
import racingcar.mvc.view.OutputView;

public class RacingGameController {
    private InputView inputView;
    private OutputView outputView;
    private RacingGameManager racingGameManager;
    private static RacingGameController racingGameController;

    private RacingGameController() {
    }

    public static RacingGameController getInstance() {
        if (racingGameController == null) {
            return new RacingGameController();
        }

        return racingGameController;
    }

    public void setInputView(InputView inputView) {
        this.inputView = inputView;
    }

    public void setOutputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void setRacingGameManager(RacingGameManager racingGameManager) {
        this.racingGameManager = racingGameManager;
    }

    public void run() {
        List<Racer> racers = getCarNames();

        BigInteger attempts = getAttempt();

        racingGameManager.setGameRound(new RacingGameRound(), racers);

        startRounds(attempts);

        showFinalWinner();
    }

    private List<Racer> getCarNames() {
        inputView.showInitMsg();
        String nameString = trimInput();

        CarNameValidator.isValid(nameString);

        return racingGameManager.createRacers(nameString);
    }

    private String trimInput() {
        String nameString = inputView.getUserInput();
        nameString = nameString.trim();

        return nameString;
    }

    private BigInteger getAttempt() {
        inputView.showReceiveNumberMsg();
        String attemptString = inputView.getUserInput();

        AttemptNumberValidator.isValid(attemptString);

        return new BigInteger(attemptString);
    }

    private void startRounds(BigInteger attempts) {
        outputView.showExecutionResultMsg();

        for (BigInteger i = BigInteger.ONE; i.compareTo(attempts) <= 0; i = i.add(BigInteger.ONE)) {
            List<Racer> racers = racingGameManager.goRound();

            outputView.showRacersStatus(racers);
        }
    }

    private void showFinalWinner() {
        List<Racer> winners = racingGameManager.getWinners();

        String winnerDisplay = winnersDisplayFormat(winners);

        outputView.showFinalWinnerMsg(winnerDisplay);
    }

    //리스트 인덱스 생각해보자
    private String winnersDisplayFormat(List<Racer> winners) {
        StringBuilder winnersDisplay = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            Racer winner = winners.get(i);

            winnersDisplay.append(winner.getName());

            delimiterSetting(i, winners.size(), winnersDisplay, CarNameValidator.NAME_DELIMITER);
        }

        return winnersDisplay.toString();
    }

    //리스트 인덱스 생각해보자
    private void delimiterSetting(int currentIndex, int listSize, StringBuilder winnersDisplay, String delimiter) {
        if (currentIndex < listSize - 1) {
            winnersDisplay.append(delimiter).append(" ");
        }
    }
}
