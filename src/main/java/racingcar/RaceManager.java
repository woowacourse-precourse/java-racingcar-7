package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RaceManager {
    private final List<String> carNames;
    private final int raceRound;
    private final String[] currentRaceImage;
    private final int[] currentScores;
    private int currentRound;

    public RaceManager(List<String> carNames, int raceRound) {
        this.carNames = carNames;
        this.raceRound = raceRound;
        this.currentRaceImage = new String[carNames.size()];
        this.currentScores = new int[carNames.size()];
        this.currentRound = 0;
        conductRace();
    }

    private void conductRace() {
        for (int i = 0; i < carNames.size(); i++) {
            currentRaceImage[i] = carNames.get(i) + " : ";
            currentScores[i] = 0;
        }
        while (currentRound < raceRound) {
            currentRound++;
            displayCurrentRace();
        }
    }

    private void displayCurrentRace() {
        for (int i = 0; i < currentRaceImage.length; i++) {
            if (isMoveForward()) {
                this.currentRaceImage[i] += "-";
                this.currentScores[i]++;
            }
            System.out.println(currentRaceImage[i]);
        }
        System.out.println();
    }

    private boolean isMoveForward() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        return pickedNumber >= 4;
    }

    public int[] getCurrentScores() {
        return currentScores;
    }
}
