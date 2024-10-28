package racingcar;

import java.util.Objects;

public class MoveCount implements Comparable<MoveCount>{
    private final int moveCount;

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public MoveCount add() {
        return new MoveCount(moveCount + 1);
    }

    public void print() {
        for (int i = 0; i<moveCount; i++){
            System.out.print("-");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveCount moveCount1 = (MoveCount) o;
        return moveCount == moveCount1.moveCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount);
    }

    @Override
    public int compareTo(MoveCount o) {
        return this.moveCount - o.moveCount;
    }
}
