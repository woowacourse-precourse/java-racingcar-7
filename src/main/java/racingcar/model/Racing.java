package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.view.OutputView;

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
            OutputView.printRace(raceStatus);
        }
    }

    public void determineWinner() {
        int maxForwardCount = calculateMaxForwardCount();

        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : raceStatus.entrySet()) {
            calculateWinner(entry, maxForwardCount);
        }

        OutputView.printWinner(winners);
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

    private int calculateMaxForwardCount() {
        return Collections.max(raceStatus.values());
    }

    private String calculateWinner(Map.Entry<String, Integer> entry, int maxForwardCount) {
        if(entry.getValue() == maxForwardCount) {
            return entry.getKey();
        }
        return null;
    }
}
