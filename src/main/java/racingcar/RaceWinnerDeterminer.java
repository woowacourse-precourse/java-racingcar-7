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
        hasMultipleWinners();
    }

    private void selectWinner() {
        int maxWin = Arrays.stream(currentScores).max().getAsInt();
        for (int i = 0; i < carNames.size(); i++) {
            if (currentScores[i] == maxWin) {
                this.winners.add(carNames.get(i));
            }
        }
    }

    private void hasMultipleWinners() {
        if (winners.size() > 1) {
            announceMultipleWinners();
        } else {
            announceSingleWinner();
        }
    }

    private void announceSingleWinner() {
        System.out.println("최종 우승자 : " + winners.getFirst());
    }

    private void announceMultipleWinners() {
        String winnerString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerString);
    }
}