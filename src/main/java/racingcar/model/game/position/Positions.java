package racingcar.model.game.position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Positions {

    private final List<Position> values;

    public Positions(final List<Position> values) {
        this.values = new ArrayList<>(values);
    }

    public static Positions initialize(long count) {
        List<Position> zeroPositions = new ArrayList<>();
        for (long i = 0; i < count; i++) {
            zeroPositions.add(Position.zero());
        }
        return new Positions(zeroPositions);
    }

    public Positions deepCopy() {
        Positions newPositions = new Positions(new ArrayList<>());
        for (Position position : values) {
            newPositions.add(position.deepCopy());
        }
        return newPositions;
    }

    public void add(Position position) {
        values.add(position);
    }

    public void increase(final int index) {
        Position position = value(index);
        position.increase();
    }

    public List<Integer> calculateWinners() {
        long maxPosition = calculateMax();
        return IntStream.range(0, values.size())
                .filter(index -> value(index).isValue(maxPosition))
                .boxed()
                .toList();
    }

    public long longValue(final int index) {
        return value(index).value();
    }

    private long calculateMax() {
        return values.stream()
                .map(Position::value)
                .max(Long::compare)
                .orElseThrow(IllegalStateException::new);
    }

    private Position value(final int index) {
        return values.get(index);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Positions positions = (Positions) o;
        return Objects.equals(values, positions.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
