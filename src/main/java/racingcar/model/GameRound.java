package racingcar.model;

public class GameRound {
    private final Integer round;

    public GameRound(String round) {
        this.round = validateRound(round);
    }

    private Integer validateRound(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력해야 합니다.");
        }
    }

    public Integer getRound(){
        return round;
    }
}
