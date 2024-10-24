package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import racingcar.model.RandomRange;

public class RaceService {

    public void race(List<Integer> progress) {
        int size = progress.size();
        for (int i = 0; i < size; i++) {
            int randomNumber = Randoms.pickNumberInRange(RandomRange.MIN.getNumber(), RandomRange.MAX.getNumber());
            move(progress, randomNumber, i);
        }
    }

    public static void move(List<Integer> progress, int randomNumber, int index) {
        if (randomNumber >= 4) {
            int currentProgress = progress.get(index);
            progress.set(index, currentProgress + 1);
        }
    }

    public void findWinner(List<String> players, List<Integer> progress, List<String> winner) {
        int maxValue = findMaxValue(progress);
        for (int i = 0; i < players.size(); i++) {
            if (progress.get(i) == maxValue) {
                winner.add(players.get(i));
            }
        }
    }

    private int findMaxValue(List<Integer> progress) {
        return progress.stream().max(Comparator.comparing(i -> i)).orElseThrow(NoSuchElementException::new);
    }
}
