package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceWinnerDeterminer {
    private final List<String> carNames;
    private final int[] currentScores;
    private final List<String> winners;

    public RaceWinnerDeterminer(List<String> carNames, int[] currentScores) {
        this.carNames = carNames;
        this.currentScores = currentScores;
        this.winners = new ArrayList<>();
        selectWinner();
    }

    private void selectWinner() {
        int maxWin = Arrays.stream(currentScores).max().getAsInt();
        for (int i = 0; i < carNames.size(); i++) {
            if (currentScores[i] == maxWin) {
                this.winners.add(carNames.get(i));
            }
        }
    }
}

