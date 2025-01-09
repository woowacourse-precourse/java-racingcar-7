package util;

public class FakeGenerator implements NumberGenerator {

    private int number;

    public FakeGenerator(int number) {
        this.number = number;
    }

    @Override
    public int makeNumber() {
        return number;
    }
}
