package racingcar;

import racingcar.Controller.RacingGame;
import racingcar.service.CarNames;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            // 사용자에게 자동차 이름 입력을 요청하는 메시지 출력
            OutputView.printEnterCarNames();

            // 사용자로부터 자동차 이름을 입력받고, 유효성을 검증한 후 반환
            String inputNames = InputView.readCarNames();

            // 입력된 자동차 이름을 기반으로 Car 객체들을 생성하고 관리하는 CarNames 객체 생성
            CarNames carNames = new CarNames(inputNames);

            // 사용자에게 이동 횟수 입력을 요청하는 메시지 출력
            OutputView.printEnterMoveCount();

            // 사용자로부터 이동 횟수를 입력받고, 유효성을 검증한 후 반환
            int moveCount = InputView.readMoveCount();

            // 경주 게임을 실행하기 위한 RacingGame 객체 생성
            RacingGame game = new RacingGame(carNames.getCars(), new RandomNumberGenerator());

            // 주어진 횟수만큼 경주 실행
            game.run(moveCount);

            // 경주 결과를 사용자에게 출력
            OutputView.printGameResult(game.getHistory());

            // 최종 우승자를 결정하고 사용자에게 출력
            OutputView.printWinners(Winner.getWinners(game.getCars()));

        } catch (IllegalArgumentException e) {
            // 입력 과정에서 발생한 오류를 탐지하여 에러 메시지를 사용자에게 출력
            OutputView.printError(e.getMessage());
            throw e;
        }
    }
}
