package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Racing {

    private final Map<String, Integer> raceStatus = new LinkedHashMap<>();

    public void initialize(List<String> input) {
        for (String name : input) {
            raceStatus.put(name, 0);
        }
    }

    public void race(int count) {
        for (int i = 0; i < count; i++) {
            singleRound();
        }
    }

    private boolean checkCondition() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void forward(String name) {
        if(checkCondition()) {
            raceStatus.replace(name, raceStatus.get(name) + 1);
        }
    }

    private void singleRound() {
        Set<String> names = raceStatus.keySet();
        for (String name : names) {
            forward(name);
        }
    }
}
