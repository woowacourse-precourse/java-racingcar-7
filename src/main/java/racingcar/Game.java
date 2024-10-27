package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<String> carList;
    private final List<Integer> carPositions;

    public Game(List<String> carList) {
        this.carList = carList;
        this.carPositions = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            carPositions.add(0);
        }
    }

    public void attemptStatus() {
        for (int i = 0; i < carList.size(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                carPositions.set(i, carPositions.get(i) + 1);
            }
            System.out.print(carList.get(i) + " : ");
            System.out.println("-".repeat(carPositions.get(i)));
        }
        System.out.println();
    }

    public List<String> findWinners() {
        int winnerPosition = Collections.max(carPositions);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (carPositions.get(i) == winnerPosition) {
                winners.add(carList.get(i));
            }
        }
        return winners;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
