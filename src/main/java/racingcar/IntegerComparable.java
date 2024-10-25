package racingcar;

public class IntegerComparable implements NumberComparable<Integer> {
    @Override
    public int compare(final Integer x, final Integer y) {
        return Integer.compare(x, y);
    }
}
