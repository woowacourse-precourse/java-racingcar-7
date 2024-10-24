package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private final int totalRaceTurn;
    private final Cars cars;
    private List<String> scoreBoard = new ArrayList<String>();
    private List<String> winners = new ArrayList<String>();

    public Race(int totalRaceTurn, Cars cars) {
        if (totalRaceTurn <= 0) {
            throw new IllegalArgumentException("자동차 경주는 1회 이상 진행되어야 합니다.");
        }
        this.totalRaceTurn = totalRaceTurn;
        this.cars = cars;
    }

    private int pickRandomNumber() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        return pickedNumber;
    }

    private boolean moveForwardOrNot() {
        int pickedNumber = pickRandomNumber();
        if (pickedNumber >= 4) {
            return true;
        }
        return false;
    }

    private List<String> renderScoreBoard() {
        for (int i = 0; i < totalRaceTurn; i++) {
            raiseScore();
            for (String carName: cars.getCars().keySet()) {
                System.out.println(carName + " : " + "-".repeat(cars.getCars().get(carName)));
                scoreBoard.add(carName + " : " + "-".repeat(cars.getCars().get(carName)));
            }
            System.out.println();
        }

        return scoreBoard;
    }

    private void raiseScore() {
        for (String carName : cars.getCars().keySet()) {
            if (moveForwardOrNot()) {
                cars.getCars().put(carName, cars.getCars().get(carName) + 1);
            }
        }
    }

    public String getWinner() {
        renderScoreBoard();

        int maxNum = cars.getCars().values().stream().mapToInt(x -> x).max().getAsInt();
        System.out.println(maxNum);

        for (String carName : cars.getCars().keySet()) {
            if (cars.getCars().get(carName) == maxNum) {
                winners.add(carName);
            }
        }

        System.out.print("최종 우승자 : ");
        for (String s : winners) {
            System.out.print(s + ", ");
        }

        return winners.toString();
    }
}
