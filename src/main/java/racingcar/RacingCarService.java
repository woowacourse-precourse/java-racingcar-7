package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class RacingCarService {

    public void process(Map<String, Integer> carInfo) {
        for (String carName : carInfo.keySet()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                carInfo.put(carName, carInfo.get(carName) + 1);
            }
        }
    }

}
