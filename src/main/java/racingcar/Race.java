package racingcar;

import static racingcar.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Race {
    private final Map<String, StringBuilder> result;

    public Race() {
        this.result = new LinkedHashMap<>();
    }

    public void initialize(String[] carNames) {
        for(String carName : carNames) {
            result.put(carName, new StringBuilder());
        }
    }

    public Map<String, StringBuilder> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public void moveCarsIfQualified() {
        for (String carName : result.keySet()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= THRESHOLD) {
                result.put(carName, result.get(carName).append(MOVE_INDICATOR));
            }
        }
    }
}
