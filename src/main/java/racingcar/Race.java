package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Race {
    private final int TOTAL_RACE_TURN;
    static final int DEFAULT_MOVE_POINT = 0;
    private static final int MOVE_FORWARD = 4;
    private LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
    private List<String> scoreBoard = new ArrayList<String>();
    private List<String> winners = new ArrayList<String>();

    public Race(int TOTAL_RACE_TURN, Cars cars) {
        if (TOTAL_RACE_TURN <= 0) {
            throw new IllegalArgumentException("자동차 경주는 1회 이상 진행되어야 합니다.");
        }

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (String car : cars.getCars()) {
            linkedHashMap.put(car, DEFAULT_MOVE_POINT);
        }

        this.TOTAL_RACE_TURN = TOTAL_RACE_TURN;
        this.linkedHashMap = linkedHashMap;
    }

    private int pickRandomNumber() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        return pickedNumber;
    }

    private boolean moveForwardOrNot() {
        int pickedNumber = pickRandomNumber();
        if (pickedNumber >= MOVE_FORWARD) {
            return true;
        }
        return false;
    }

    private List<String> renderScoreBoard() {
        for (int i = 0; i < TOTAL_RACE_TURN; i++) {
            raiseScore();
            for (String s : linkedHashMap.keySet()) {
                System.out.println(s + " : " + "-".repeat((linkedHashMap.get(s))));
                scoreBoard.add(s + " : " + "-".repeat(linkedHashMap.get(s)));
            }
            System.out.println();
        }

        return scoreBoard;
    }

    private void raiseScore() {
        for (String s : linkedHashMap.keySet()) {
            if (moveForwardOrNot()) {
                linkedHashMap.put(s, linkedHashMap.get(s) + 1);
            }
        }
    }

    public String getWinner() {
        renderScoreBoard();

        int maxNum = linkedHashMap.values().stream().mapToInt(x -> x).max().getAsInt();
        System.out.println(maxNum);

        for (String carName : linkedHashMap.keySet()) {
            if (linkedHashMap.get(carName) == maxNum) {
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
