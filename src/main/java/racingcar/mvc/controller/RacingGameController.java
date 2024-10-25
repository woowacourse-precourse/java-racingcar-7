package racingcar.mvc.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import racingcar.mvc.model.observer.Car;
import racingcar.mvc.model.observer.CarObserver;
import racingcar.mvc.model.subject.GameRoundSubject;
import racingcar.mvc.model.subject.Subject;
import racingcar.mvc.validation.input.AttemptNumberValidator;
import racingcar.mvc.validation.input.CarNameValidator;
import racingcar.mvc.view.InputView;
import racingcar.mvc.view.OutputView;

public class RacingGameController {
    private InputView inputView;
    private OutputView outputView;
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

    public void run() {
        List<String> names = getCarNames();

        BigInteger attempts = getAttempt();

        Subject gameRoundSubject = getRoundSubject(new GameRoundSubject(), names);

        proceedRound(attempts, gameRoundSubject);

        showFinalWinner(gameRoundSubject);
    }

    private void showFinalWinner(Subject gameRoundSubject) {
        outputView.showFinalWinnerMsg();

        String winnerMsg = getWinner(gameRoundSubject);

        System.out.println(winnerMsg);
    }

    private String getWinner(Subject gameRoundSubject) {
        StringBuilder winnerMsg = new StringBuilder();

        List<CarObserver> winnerObservers = gameRoundSubject.findWinnerObservers();

        for (int i = 0; i < winnerObservers.size(); i++) {
            Car car = (Car) winnerObservers.get(i);
            winnerMsg.append(car.getName());

            if (i < winnerObservers.size() - 1) {
                winnerMsg.append(", ");
            }
        }

//        for (CarObserver winnerObserver : winnerObservers) {
//            Car car = (Car) winnerObserver;
//            winnerMsg.append(car.getName());
//
//            if (winnerObservers.size() - 1 != winnerObservers.indexOf(winnerObserver)) {
//                winnerMsg.append(", ");
//            }
//        }

        return winnerMsg.toString();
    }

    private void proceedRound(BigInteger attempts, Subject gameRoundSubject) {
        outputView.showExecutionResultMsg();

        for (BigInteger i = BigInteger.ONE; i.compareTo(attempts) <= 0; i = i.add(BigInteger.ONE)) {
            gameRoundSubject.notifyObservers();
            System.out.println();
        }
    }

    private Subject getRoundSubject(Subject gamesubject, List<String> names) {
        Subject gameRoundSubject = gamesubject;

        return enrollCars(names, gameRoundSubject);
    }

    private Subject enrollCars(List<String> names, Subject gameRoundSubject) {
        for (String name : names) {
            gameRoundSubject.registerObserver(new Car(name));
        }
        return gameRoundSubject;
    }

    private List<String> getCarNames() {
        inputView.showInitMsg();

        String nameString = inputView.getUserInput();
        nameString = nameString.trim();

        CarNameValidator.isValid(nameString);

        List<String> names = new ArrayList<>();

        for (String name : nameString.split(",")) {
            names.add(name);
        }

        return names;
    }

    private BigInteger getAttempt() {
        inputView.showReceiveNumberMsg();
        String attemptString = inputView.getUserInput();

        AttemptNumberValidator.isValid(attemptString);

        return new BigInteger(attemptString);
    }
}
