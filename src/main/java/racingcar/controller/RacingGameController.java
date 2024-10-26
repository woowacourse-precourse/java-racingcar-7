package racingcar.controller;

import racingcar.domain.car.CarGroup;
import racingcar.domain.game.GameRound;
import racingcar.factory.GameSetup;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RacingGameService racingGameService;
    private final OutputView outputView;
    private final InputView inputView;

    public RacingGameController(RacingGameService racingGameService, InputView inputView, OutputView outputView) {
        this.racingGameService = racingGameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 사용자에게 자동차의 이름을 입력 받음
        CarGroup carGroup = GameSetup.createCars((inputView.requestCarNames()));

        // 사용자에게 라운드 횟수를 입력 받음
        GameRound gameRound = GameSetup.setRound(inputView.requestNumberOfGames());

        // 각 라운드 출력
        outputView.printRoundResult(racingGameService.playRound(gameRound, carGroup));

        // 게임 결과 출력
        outputView.printWinnerList(racingGameService.getWinner(carGroup));
    }
}
