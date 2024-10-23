package racingcar.domain;

public class Movement {
    static final String MARK = "-";
    private int count = 0;

    public void advance(int number) {
        validateAdvanceNumber(number);
        if (number < 4) {
            return;
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return MARK.repeat(count);
    }

    private void validateAdvanceNumber(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException();
        }
    }
}
