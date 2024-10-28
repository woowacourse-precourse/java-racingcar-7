package racingcar.model.game.position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Positions {

    private final List<Position> positions;

    public Positions(final List<Position> positions) {
        this.positions = new ArrayList<>(positions);
    }

    public static Positions createWithNewRound(long count) {
        return new Positions(
                LongStream.range(0, count)
                        .mapToObj(i -> new Position(0))
                        .toList()
        );
    }

    public void increase(final int index) {
        at(index).increase();
    }

    public List<Integer> findWinnersIndices() {
        long maxPosition = findMaxPosition();
        return IntStream.range(0, positions.size())
                .filter(index -> at(index).is(maxPosition))
                .boxed()
                .toList();
    }

    private long findMaxPosition() {
        return positions.stream()
                .mapToLong(Position::position)
                .max()
                .orElseThrow(() -> new IllegalStateException("참여자가 없습니다."));
    }

    private Position at(final int index) {
        return positions.get(index);
    }

    public List<Long> values() {
        return positions.stream()
                .mapToLong(Position::position)
                .boxed()
                .toList();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Positions other = (Positions) o;
        return Objects.equals(positions, other.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
