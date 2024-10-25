package racingcar.model.number;

import java.util.Objects;

public class MoveNumber {
    private static final int FRONT_MOVE_NUMBER = 4;

    private int number;

    public MoveNumber(int number) {
        this.number = number;
    }

    public void move(int number) {
        if(number >= FRONT_MOVE_NUMBER) {
            this.number += 1;
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveNumber that = (MoveNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "MoveNumber{" +
                "number=" + number +
                '}';
    }
}
