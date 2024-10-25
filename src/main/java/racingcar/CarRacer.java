package racingcar;

import java.util.ArrayList;

public class CarRacer {

    private final String[] carNames;
    private int[] carPositions;

    public CarRacer(String[] carNames) {
        this.carNames = carNames;
        this.carPositions = new int[carNames.length];
    }

    public void moveCars(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            for (int j = 0; j < carPositions.length; j++) {
                if (Math.random() >= 0.4) {
                    carPositions[j]++;
                }
            }
        }
    }

    public ArrayList<String> getWinners() {
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

        return winnersList;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}
