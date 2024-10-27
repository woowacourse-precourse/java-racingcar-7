package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class CarRacer {

    private final String[] carNames;
    private final int[] carPositions;

    public CarRacer(String[] carNames) {
        this.carNames = carNames;
        this.carPositions = new int[carNames.length];
    }

    public void moveCars(int moveCount) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            racing();
            racingResultPrint();
        }
    }

    private void racingResultPrint() {
        for (int j = 0; j < carPositions.length; j++) {
            System.out.println(carNames[j] + " : " + "-".repeat(carPositions[j]));
        }
        System.out.println();
    }

    private void racing() {
        for (int j = 0; j < carPositions.length; j++) {
            if (moveOrStop()) {
                carPositions[j]++;
            }
        }
    }

    private static boolean moveOrStop() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String[] getWinners() {
        int maxPosition = findWinnerIdx();

        return findWinnerCarNames(maxPosition);
    }

    private String[] findWinnerCarNames(int maxPosition) {
        ArrayList<String> winnersList = new ArrayList<>();
        for (int i = 0; i < carPositions.length; i++) {
            if (carPositions[i] == maxPosition) {
                winnersList.add(carNames[i]);
            }
        }

        return winnersList.toArray(new String[0]);
    }

    private int findWinnerIdx() {
        int maxPosition = 0;
        for (int position : carPositions) {
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}
