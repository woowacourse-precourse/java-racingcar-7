package racingcar;

import racingcar.controller.*;
import racingcar.view.*;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args)  {
        // TODO: 프로그램 구현

        // 차 이름 입력받기
        List<String> carNames = InputView.getCarNames();
        //System.out.println(carNames);

        // 이름이 5자 이하인지 확인
        InputController.checkNameLimit(carNames);

        // 시도 횟수 입력받기
        int tryNum = InputView.getTryNum();

        Map<String, Integer> carProgress = OutputController.initializeCarProgress(carNames);

        OutputController.raceByOrder(carNames, carProgress, tryNum);







    }

}
