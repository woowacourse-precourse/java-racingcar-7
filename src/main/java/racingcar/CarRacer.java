package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class CarRacer {

    private final String[] carNames;
    private int[] carPositions;

    public CarRacer(String[] carNames) {
        this.carNames = carNames;
        this.carPositions = new int[carNames.length];
    }

    public void moveCars(int moveCount) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            for (int j = 0; j < carPositions.length; j++) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    carPositions[j]++;
                }
            }

            for (int j = 0; j < carPositions.length; j++) {
                System.out.println(carNames[j] + " : " + "-".repeat(carPositions[j]));
            }
            System.out.println();
        }
    }

    public String[] getWinners() {
        int maxPosition = 0;
        for (int position : carPositions) {
            maxPosition = Math.max(maxPosition, position);
        }

        ArrayList<String> winnersList = new ArrayList<>();
        for (int i = 0; i < carPositions.length; i++) {
            if (carPositions[i] == maxPosition) {
                winnersList.add(carNames[i]);
            }
        }

        return winnersList.toArray(new String[0]);
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}
