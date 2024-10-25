package racingcar.controller;

import racingcar.model.GameTryCount;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;
import racingcar.model.RacingCarName;
import racingcar.model.RacingCarMove;
import racingcar.model.RandomNumber;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initCarName() {
        String inputCarName = inputView.inputCarName();
        RacingCarName.validateDuplicateNames(inputView.splitCarName(inputCarName));
        RacingCarName racingCarName = new RacingCarName(inputView.splitCarName(inputCarName));
        RacingCarList racingCarList = new RacingCarList();

        for (String name : racingCarName.getList()) {
            racingCarList.add(new RacingCar(name));
        }
    }

    public void initTryCount() {
        String inputTryCount = inputView.inputTryCount();
        new GameTryCount(inputView.convertStringToInt(inputTryCount));
    }

    public void printRoundResult() {
        final RacingCarMove racingCarMove = new RacingCarMove();
        final RandomNumber randomNumber = new RandomNumber();

        for (int i = 0; i < GameTryCount.get(); i++) {
            printCarPosition(racingCarMove, randomNumber);
            System.out.println();
        }
    }

    public void startGame() {
        initCarName();
        initTryCount();
    }

    private void printCarPosition(RacingCarMove racingCarMove, RandomNumber randomNumber) {
        for (RacingCar car : RacingCarList.get()) {
            car.move(racingCarMove, randomNumber);
            outputView.printRoundResult(car);
        }
    }

    private void endGame() {
        final Winner winner = new Winner();
        outputView.printInitResult();
        printRoundResult();

        String winners = winner.getList(RacingCarList.get(), winner.maxPosition(RacingCarList.get()));
        outputView.printEndResult(winners);
    }

    public void run() {
        startGame();
        endGame();
        inputView.close();
    }

    // currentPosition 에 move() 더하는 방식 - 이동했으면 +1 안했으면 +0
}
