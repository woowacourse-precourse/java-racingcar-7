package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputController {
    // 자동차의 초기 전진 상태를 0으로 설정하는 메서드
    public static Map<String, Integer> initializeCarProgress(List<String> carNames){
        Map<String, Integer> carProgress = new HashMap<>();
        for (String carName : carNames){
            carProgress.put(carName, 0);
        }
        return carProgress;
    }
    public static void raceCar (List<String> carNames, Map<String, Integer> carProgress){
        for (String carName: carNames){
            if (Randoms.pickNumberInRange(0,9)>=4){
                carProgress.put(carName, carProgress.get(carName)+1);
            }
        }
    }
    public static void raceByOrder(List<String> carNames, Map<String, Integer> carProgress, int tryNum){
        for (int i = 0; i < tryNum; i++) {
            raceCar(carNames, carProgress);
            OutputView.printRacingProcess(carNames, carProgress);
            System.out.println();
        }
    }


}
