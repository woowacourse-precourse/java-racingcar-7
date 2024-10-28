package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    private final List<String> carNames;
    private final int raceRound;
    private final List<String> currentRaceImages;
    private final List<Integer> currentScores;
    private int currentRound;

    public RaceManager(List<String> carNames, int raceRound) {
        this.carNames = carNames;
        this.raceRound = raceRound;
        this.currentRaceImages = new ArrayList<>();
        this.currentScores = new ArrayList<>();
        this.currentRound = 0;
        conductRace();
    }

    private void conductRace() {
        for (String carName : carNames) {
            currentRaceImages.add(carName + " : ");
            currentScores.add(0);
        }
        while (currentRound < raceRound) {
            currentRound++;
            displayCurrentRace();
        }
    }

    private void displayCurrentRace() {
        for (int i = 0; i < currentRaceImages.size(); i++) {
            if (isMoveForward()) {
                currentRaceImages.set(i, currentRaceImages.get(i) + "-");
                currentScores.set(i, currentScores.get(i) + 1);
            }
            System.out.println(currentRaceImages.get(i));
        }
        System.out.println();
    }

    private boolean isMoveForward() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        return pickedNumber >= 4;
    }

    public List<Integer> getCurrentScores() {
        return currentScores;
    }
}
