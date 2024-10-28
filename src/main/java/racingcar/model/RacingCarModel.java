package racingcar.model;
import  camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarModel {

    private boolean lengthValidator (String car) {
        if (car.length() <= 5) {
                return true;
        }
        throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
    }
    private boolean isForwarding () {
        return (Randoms.pickNumberInRange(0, 9) > 3);
    }

    public String[] SplitCarName(String carNames) {
        return carNames.split(",");
    }

    public Map<String, Integer> setCarStatus(String[] carNames) {
        Map<String, Integer> carStatus = new HashMap<>();
        for (String carName: carNames) {
            if (lengthValidator(carName)) {
                carStatus.put(carName, 0);
            }
        }
        return carStatus;
    }

    public void setProgress(Map<String, Integer> raceStatus) {
        for(String car : raceStatus.keySet()) {
            if (isForwarding()) {
                raceStatus.put(car, raceStatus.get(car) + 1);
            }
        }
    }

    public List<String> findWinners(Map<String, Integer> raceStatus) {
        int maxValue = Integer.MIN_VALUE;
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : raceStatus.entrySet()) {
            int value = entry.getValue();

            if (value > maxValue) {
                maxValue = value;
                winners.clear();
                winners.add(entry.getKey());
            } else if(value == maxValue) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }
}
