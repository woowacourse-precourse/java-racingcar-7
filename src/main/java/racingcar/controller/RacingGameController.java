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

    public void startGame() {
        initCarName();
        initTryCount();
    }

    public String findWinner() {
        final Winner winner = new Winner();
        return winner.getList(RacingCarList.get(), winner.maxPosition(RacingCarList.get()));
    }

    private void endGame() {
        outputView.printInitResult();
        outputView.printRoundResult();
        outputView.printEndResult(findWinner());
    }

    public void run() {
        startGame();
        endGame();
        inputView.close();
    }

    // currentPosition 에 move() 더하는 방식 - 이동했으면 +1 안했으면 +0
}
