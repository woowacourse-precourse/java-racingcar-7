package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {

    private final Map<String, Integer> raceStatus = new HashMap<>();

    public void initialize(List<String> input) {
        for (String name : input) {
            raceStatus.put(name, 0);
        }
    }

}
