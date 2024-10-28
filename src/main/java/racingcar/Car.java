package racingcar;

public class Car {
    private final String name;
    private int position;
    private int winCount;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.winCount = 0;
    }

    public void setZeroPosition() {
        this.position = 0;
    }

    public void increasePosition() {
        this.position++;
    }

    public void increaseWinCount() {
        this.winCount++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int getWinCount() {
        return this.winCount;
    }





}
