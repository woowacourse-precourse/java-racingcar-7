package racingcar.racingcar.domain;

public class Move {
    private int move = 0;

    public int getMove() {
        return move;
    }
    public void increaseMoveCount() {
        move++;
    }
}
