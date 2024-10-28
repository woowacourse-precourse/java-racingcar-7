package racingcar.model;
import  camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarModel {

    public String[] SplitCarName(String carNames) {
        return carNames.split(",");
    }

    public Map<String, Integer> setCarStatus(String[] carNames) {
        Map<String, Integer> carStatus = new HashMap<>();
        for (String carName : carNames) {
            carStatus.put(carName, 0);
        }
        return carStatus;
    }

    private boolean isForwarding() {
        return (Randoms.pickNumberInRange(0, 9) > 3);
    }

    private void setProgress(Map<String, Integer> raceStatus) {
        for (String car : raceStatus.keySet()) {
            if (isForwarding()) {
                raceStatus.put(car, raceStatus.get(car) + 1);
            }
        }
    }

}

