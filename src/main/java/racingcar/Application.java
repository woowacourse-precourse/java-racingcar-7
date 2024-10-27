package racingcar;


import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;
import racingcar.model.domain.GameResult;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

//애플리케이션을 Spring에서 컨트롤러 앞단으로 취급
public class Application {
    public static void main(String[] args) {
        try {
            String carNames = inputCarNames();
            int roundCount = inputGameCount();

            GameResult responseDto = GameController.playRacingGame(roundCount, carNames);
            OutputView.printResult(responseDto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Console.close();
        }
    }

    private static String inputCarNames() {
        OutputView.printInputName();
        String carNames = InputView.inputNames();
        //@valid와 같은 역할
        Validator.validateCarNames(carNames);
        return carNames;
    }

    private static int inputGameCount() {
        OutputView.printInputCount();
        int gameCnt = InputView.inputGameCnt();
        Validator.validateGameCount(gameCnt);
        return gameCnt;
    }
}
