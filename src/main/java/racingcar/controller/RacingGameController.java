package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private RacingGame racingGame;

    public void start() {
        String carNames = inputView.inputCarNames(); // 자동차 이름을 입력받음
        String[] carNameArray = carNames.split(","); // 입력된 이름을 쉼표로 분리
        InputValidator.validateCarNames(carNameArray); // 입력 검증

        int trialCount = inputView.inputTrialCount();
        InputValidator.validateTrialCount(trialCount); // 시도 횟수 검증

        racingGame = new RacingGame(carNameArray, trialCount); // RacingGame 초기화
        playGame(); // 게임 진행
        printWinners(); // 우승자 출력
    }

    private void playGame() {
        while (racingGame.hasMoreTrials()) {
            racingGame.playRound();
            outputView.printRoundResult(racingGame.getCars());
        }
    }

    private void printWinners() {
        outputView.printWinners(racingGame.getWinners());
    }
}
