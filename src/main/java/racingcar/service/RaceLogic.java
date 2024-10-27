package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class RaceLogic {

    private static List<Integer> raceResult;

    private static List<String> names;
    private static int number;
    private MoveDecision moveDecision;

    public RaceLogic(List<String> names, int number, MoveDecision moveDecision) {
        this.raceResult = new ArrayList<>();
        this.number = number;
        this.names = names;
        this.moveDecision = moveDecision;
        for (int i = 0; i < names.size(); i++) {
            raceResult.add(0);
        }
    }

    public void race(List<Boolean> isFourResult) {
        for (int i = 0; i < raceResult.size(); i++) {
            if (isFourResult.get(i)) {
                raceResult.set(i, raceResult.get(i) + 1);
            }
        }
    }

    public List<Integer> findWinners() {
        List<Integer> maxIndex = new ArrayList<>();
        int max = 0;

        for (int score : raceResult) {
            if (max < score) {
                max = score;
            }
        }
        for (int i = 0; i < raceResult.size(); i++) {
            if (raceResult.get(i) == max) {
                maxIndex.add(i);
            }
        }

        return maxIndex;
    }

    public List<Integer> getRaceResult() {
        return raceResult;
    }
}
