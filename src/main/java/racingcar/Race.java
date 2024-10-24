package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Race {
    private final int TOTAL_RACE_TURN;
    private static final int DEFAULT_MOVE_POINT = 0;
    private static final int MOVE_FORWARD = 4;

    private final LinkedHashMap<String, Integer> racingScoreBoard;
    private final List<String> winners = new ArrayList<>();

    public Race(int TOTAL_RACE_TURN, Cars cars) {
        validateNaturalNumber(TOTAL_RACE_TURN);

        LinkedHashMap<String, Integer> racingScoreBoard = new LinkedHashMap<>();
        for (String car : cars.getNameList()) {
            racingScoreBoard.put(car, DEFAULT_MOVE_POINT);
        }

        this.TOTAL_RACE_TURN = TOTAL_RACE_TURN;
        this.racingScoreBoard = racingScoreBoard;
    }

    public int getTOTAL_RACE_TURN() {
        return TOTAL_RACE_TURN;
    }

    private static void validateNaturalNumber(int TOTAL_RACE_TURN) {
        if (TOTAL_RACE_TURN <= 0) {
            throw new IllegalArgumentException("자동차 경주는 1회 이상 진행되어야 합니다.");
        }
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean moveForwardOrNot() {
        int pickedNumber = pickRandomNumber();
        return pickedNumber >= MOVE_FORWARD;
    }

    private void raiseScore() {
        for (String s : racingScoreBoard.keySet()) {
            if (moveForwardOrNot()) {
                racingScoreBoard.put(s, racingScoreBoard.get(s) + 1);
            }
        }
    }

    private void renderScoreBoard() {
        for (int i = 0; i < TOTAL_RACE_TURN; i++) {
            raiseScore();
            for (String s : racingScoreBoard.keySet()) {
                System.out.println(s + " : " + "-".repeat((racingScoreBoard.get(s))));
            }
            System.out.println();
        }
    }

    public List<String> getWinner() {
        renderScoreBoard();
        int maxNum = racingScoreBoard.values().stream().mapToInt(x -> x).max().orElse(0);

        for (String carName : racingScoreBoard.keySet()) {
            if (racingScoreBoard.get(carName) == maxNum) {
                winners.add(carName);
            }
        }

        System.out.print("최종 우승자 : " + String.join(", ", winners));

        return winners;
    }
}
