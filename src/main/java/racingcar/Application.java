package racingcar;

import racingcar.controller.RacingGame;
import racingcar.service.CarNames;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            // 자동차 이름
            OutputView.printEnterCarNames();
            String inputNames = InputView.readCarNames();
            CarNames carNames = new CarNames(inputNames);

            // 이동 횟수
            OutputView.printEnterMoveCount();
            int moveCount = InputView.readMoveCount();

            // 게임 생성 및 실행
            RacingGame game = new RacingGame(carNames.getCars(), new RandomNumberGenerator());
            game.run(moveCount);

            // 결과
            OutputView.printGameResult(game.getHistory());
            OutputView.printWinners(Winner.getWinners(game.getCars()));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            throw e;
        }
    }
}
