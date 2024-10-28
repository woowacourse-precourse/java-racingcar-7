package racingcar;

public class Car {
    private static final String PREFIX = " : ";
    private final String name;
    private final StringBuilder builder;
    private int winCount;

    Car(String name) {
        this.name = name;
        this.winCount = 0;
        this.builder = new StringBuilder(name);

        builder.append(PREFIX);
    }

    public int getWinCount() {
        return this.winCount;
    }

    public String getName() {
        return this.name;
    }

    public StringBuilder getStringBuilder() {
        return this.builder;
    }

    public void increaseWinCount() {
        this.winCount++;
    }


}
