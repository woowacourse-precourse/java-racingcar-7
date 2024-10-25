package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.view.OutputView;

public class RacingCarService {
    private final int LOW_NUM = 0;
    private final int HIGH_NUM = 9;
    private final int STAND_NUM = 4;
    private LinkedHashMap<String, Integer>resultMap;

    public RacingCarService(Map<String, Integer> carList, Integer tryCount) {
        OutputView.resultMessage();
        while (tryCount--> 0) {
            moveCar(carList);
            OutputView.carStatus(carList);
        }
        resultMap = new LinkedHashMap<>(carList);
    }

    private void moveCar(Map<String, Integer> carList) {
        for (Map.Entry<String, Integer> car : carList.entrySet()){
            if (createRandomNumber() >= STAND_NUM){
                String carName = car.getKey();
                carList.put(carName, car.getValue()+1);
            }
        }
    }


    private int createRandomNumber() {
        return Randoms.pickNumberInRange(LOW_NUM, HIGH_NUM);
    }

    public String winner() {
        int score = LOW_NUM;
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> car : resultMap.entrySet()) {
            int carScore = car.getValue();
            if (carScore == score) {
                winners.add(car.getKey());
            }
            if (score < carScore) {
                score = carScore;
                winners.clear();
                winners.add(car.getKey());
            }
        }
        return String.join(", ", winners);
    }
}
