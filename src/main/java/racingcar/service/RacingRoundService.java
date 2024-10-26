package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Map;

public class RacingRoundService {

    public void racingRound(Map<String, Integer> racingCars) {
        for (String carName : racingCars.keySet()) {
            //수정하기
            if (canGo()) {
                int carState = racingCars.get(carName);
                racingCars.put(carName, carState + 1);
            }
        }
    }

    private boolean canGo() {
        int randomDecisionNumber = pickNumberInRange(0,9);
        return randomDecisionNumber > 3;
    }

}
