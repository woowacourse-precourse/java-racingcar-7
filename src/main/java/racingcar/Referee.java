package racingcar;

import java.util.List;
import java.util.Map;

public class Referee {

    private static final String NUMBER_REGULAR_EXPRESSION = "\\d+";

    private int round;

    public Referee(String round) {
        checkRoundNull(round);
        checkNumber(round);
        this.round = Integer.parseInt(round);
    }

    public int getRound() {
        return round;
    }

    public List<String> judgmentWinner(Map<String, Integer> carsDecision) {
        return carsDecision
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition(carsDecision))
                .map(Map.Entry::getKey)
                .toList();
    }

    private Integer maxPosition(Map<String, Integer> carsDecision) {
        return carsDecision
                .values()
                .stream()
                .max(Integer::compareTo)
                .get();
    }

    private void checkRoundNull(String round) {
        if (round == null) {
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }

    private void checkNumber(String round) {
        if (!round.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("라운드 입력은 숫자만 가능합니다.");
        }
    }
}
