package racingcar.model.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        Position position = values.get(index);
        position.increase();
    }

    public List<Integer> calculateWinners() {
        long maxPosition = calculateMax();
        return IntStream.range(0, values.size())
                .filter(index -> getValue(index) == maxPosition)
                .boxed()
                .toList();
    }

    public long calculateMax() {
        return values.stream()
                .map(Position::value)
                .max(Long::compare)
                .get();
    }

    private long getValue(final int index) {
        return values.get(index).value();
    }

    public List<Position> getValues() {
        return Collections.unmodifiableList(values);
    }
}
