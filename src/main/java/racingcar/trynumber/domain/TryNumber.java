package racingcar.trynumber.domain;

public class TryNumber {
    private final int count;
    private TryNumber(int count) {
        this.count = count;
    }
    public static TryNumber of(int count) {
        return new TryNumber(count);
    }
    public int getCount() {
        return count;
    }
    @Override
    public String toString() {
        return ""+count;
    }
}
