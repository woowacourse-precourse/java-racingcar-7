package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RaceManager {
    private final List<String> carNames;
    private final int raceRound;
    private String[] currentScores;
    private int currentRound;

    public RaceManager(List<String> carNames, int raceRound) {
        this.carNames = carNames;
        this.raceRound = raceRound;
        this.currentScores = new String[carNames.size()];
        this.currentRound = 0;
        conductRace();
    }

    private void conductRace() {
        for (int i = 0; i < carNames.size(); i++) {
            currentScores[i] = carNames.get(i) + " : ";
        }

        while (currentRound < raceRound) {
            currentRound++;
            displayCurrentRace();
        }
    }

    private void displayCurrentRace() {
        for (int i = 0; i < currentScores.length; i++) {
            if (isMoveForward()) {
                this.currentScores[i] += "-";
            }
            System.out.println(currentScores[i]);
        }
        System.out.println();
    }

    private boolean isMoveForward() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        return pickedNumber >= 4;
    }
}
