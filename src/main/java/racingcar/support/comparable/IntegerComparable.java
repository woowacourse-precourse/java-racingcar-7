package racingcar.support.comparable;

public class IntegerComparable implements NumberComparable<Integer> {
    @Override
    public boolean meetsThreshold(final Integer value, final Integer threshold) {
        return value >= threshold;
    }
}
