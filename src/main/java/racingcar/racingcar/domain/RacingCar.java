package racingcar.racingcar.domain;

import java.util.Objects;

public class RacingCar {
    private final Name name;
    private final Move move;
    private RacingCar(Name name) {
        this.name = name;
        this.move = new Move();
    }
    public static RacingCar of(String name) {
        return new RacingCar(
                new Name(name)
        );
    }
    public int getMove() {
        return move.getMove();
    }
    public String getName() {
        return name.getName();
    }
    public void increaseMoveCount() {
        move.increaseMoveCount();
    }
    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(move.getMove()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof RacingCar that) {
            return this.name.equals(that.name);
        }
        return false;
    }
}
