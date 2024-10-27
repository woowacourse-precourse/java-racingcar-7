package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

public class MoveDecision {
    public List<Boolean> isFour(List<String> names) {
        List<Boolean> isFourResult = new LinkedList<>();

        for (String name : names) {
            int random = Randoms.pickNumberInRange(0, 9);
            isFourResult.add(random >= 4);
        }
        return isFourResult;
    }
}
