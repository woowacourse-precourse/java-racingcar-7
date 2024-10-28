package racingcar;

import racingcar.controller.*;
import racingcar.view.*;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args)  {
        // TODO: 프로그램 구현

        List<String> carNames = InputView.getCarNames();
        InputController.checkNameLimit(carNames);
        int tryNum = InputView.getTryNum();
        Map<String, Integer> carProgress = OutputController.initializeCarProgress(carNames);
        OutputController.raceByOrder(carNames, carProgress, tryNum);
        OutputController.findWinner(carNames, carProgress);





    }

}
