package racingcar;


import racingcar.controller.GameController;
import racingcar.model.domain.GameResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

//애플리케이션을 Spring에서 컨트롤러 앞단으로 취급
public class Application {
    public static void main(String[] args) {
        OutputView.printInputName();
        String carNames = InputView.inputNames();
        OutputView.printInputCount();
        int gameCnt = InputView.inputGameCnt();

        GameResult response = GameController.playRacingGame(gameCnt, carNames);

        OutputView.printResult(response);
    }
}
