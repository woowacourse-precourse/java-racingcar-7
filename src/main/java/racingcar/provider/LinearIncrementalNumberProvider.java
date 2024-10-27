package racingcar.provider;

public class LinearIncrementalNumberProvider implements NumberProvider {
    private int number;
    private int incremental;

    public LinearIncrementalNumberProvider(int initialValue, int incremental) {
        this.number = initialValue;
        this.incremental = incremental;
    }

    @Override
    public int getNumber() {

        number += incremental;

        return number - incremental;
    }
}
