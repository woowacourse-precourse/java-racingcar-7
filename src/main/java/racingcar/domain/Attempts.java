package racingcar.domain;

public class Attempts {

    private int attempt;

    private Attempts(String attempt) {
        this.attempt = Integer.parseInt(attempt);
    }

    public void decrease() {
        attempt -= 1;
    }

    public boolean isLeft() {
        return !(attempt == 0);
    }

    public static Attempts from(String attempt) {
        return new Attempts(attempt);
    }
}
