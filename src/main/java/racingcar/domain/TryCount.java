package racingcar.domain;

public class TryCount {

    private Integer count;

    public void set(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }

    public void playRound() {
        count--;
    }

    public boolean remain() {
        return count > 0;
    }
}
