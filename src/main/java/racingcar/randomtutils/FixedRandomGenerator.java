package racingcar.randomtutils;

public class FixedRandomGenerator implements RandomGenerator{
    private final int fixedNumber;

    public FixedRandomGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }
    @Override
    public int generate() {
        return fixedNumber;
    }




}
