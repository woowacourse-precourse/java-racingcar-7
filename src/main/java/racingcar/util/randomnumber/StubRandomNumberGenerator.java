package racingcar.util.randomnumber;

public class StubRandomNumberGenerator implements RandomNumberStrategy {

    private final int randomNumber;

    public StubRandomNumberGenerator(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public int generateNumber() {
        return this.randomNumber;
    }
}
