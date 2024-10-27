package racingcar.model;

public class RaceTurn {
    private int turn;
    private static String UNDER_ZERO_NUMBER_ERROR_MESSAGE = "0 이하의 수는 입력할 수 없습니다.";
    private static String OVER_SIX_NUMBER_ERROR_MESSAGE = "6 이상의 수는 입력할 수 없습니다.";

    public RaceTurn(int turn) {
        validTurn(turn);
        this.turn = turn;
    }

    private void validTurn(int turn) {
        if (turn <= 0) {
            throw new IllegalArgumentException(UNDER_ZERO_NUMBER_ERROR_MESSAGE);
        }
        if (turn >= 6) {
            throw new IllegalArgumentException(OVER_SIX_NUMBER_ERROR_MESSAGE);
        }
    }

    public int getTurn() {
        return this.turn;
    }

    public void minusOneTurn() {
        this.turn--;
    }
}
