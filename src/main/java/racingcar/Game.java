package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<String> carList;
    private final List<Integer> carPositions;
    private final int attemptsNum;

    public Game(List<String> carList, int attemptsNum) {
        this.carList = carList;
        this.attemptsNum = attemptsNum;
        this.carPositions = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            carPositions.add(0);
        }
    }

    public void startGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < attemptsNum; i++) {
            moveCars();
            printCarsPosition();
        }
        List<String> winners = findWinners();
        printWinners(winners);
    }

    public void moveCars() {
        for (int i = 0; i < carList.size(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                carPositions.set(i, carPositions.get(i) + 1);
            }
        }
    }

    public void printCarsPosition() {
        for (int i = 0; i < carList.size(); i++) {
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

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
