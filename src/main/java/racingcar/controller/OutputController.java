package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputController {
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
        OutputView.printRacingProcessHeader();
        for (int i = 0; i < tryNum; i++) {
            raceCar(carNames, carProgress);
            OutputView.printRacingProcess(carNames, carProgress);

        }
    }

    public static StringBuilder findWinner(List<String> carNames, Map<String, Integer> carProgress){
        int maxProgress = 0;
        StringBuilder winners = new StringBuilder();

        for (String carName : carNames) {
            maxProgress = Math.max(maxProgress, carProgress.get(carName));
        }

        for (String carName : carNames) {
            if (carProgress.get(carName) != maxProgress) {
                continue;
            }
            if (!winners.isEmpty()) {
                winners.append(",");
            }
            winners.append(carName);
        }
        OutputView.printWinner(winners);
        return winners;
    }


}
