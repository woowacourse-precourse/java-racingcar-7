package racingcar.model;

public class RaceTurn {
    private int turn;

    public RaceTurn(int turn) {
        validTurn(turn);
        this.turn = turn;
    }

    private void validTurn(int turn) {
        if (turn <= 0) {
            throw new IllegalArgumentException("0 이하의 수는 입력할 수 없습니다.");
        }
        if (turn >= 6) {
            throw new IllegalArgumentException("6 이상의 수는 입력할 수 없습니다.");
        }
    }
}
