package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {

    private final List<String> carNames;
    private final int attempts;
    private final Map<String, Integer> carScores;

    public RacingGame(List<String> carNames, int attempts) {
        this.carNames = carNames;
        this.attempts = attempts;
        this.carScores = initializeCarScores(carNames);
    }

    public void startRace() {
        System.out.println("\n실행 결과");

        for (int i = 0; i < attempts; i++) {
            raceRound();
            System.out.println();
        }
    }

    private void raceRound() {
        for (String carName : carNames) {
            int move = pickNumberInRange(0, 9);
            if (move >= 4) {
                carScores.put(carName, carScores.get(carName) + 1);
            }
            displayCarPosition(carName);
        }
    }

    private Map<String, Integer> initializeCarScores(List<String> carNames) {
        Map<String, Integer> scores = new HashMap<>();
        for (String carName : carNames) {
            scores.put(carName, 0);
        }
        return scores;
    }

    private void displayCarPosition(String carName) {
        System.out.print(carName + " : ");
        int position = carScores.get(carName);
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public Map<String, Integer> getCarScores() {
        return carScores;
    }
}
