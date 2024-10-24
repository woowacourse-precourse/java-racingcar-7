package racingcar;

public class Car {
    private final String name;
    private int advanceCount;

    public Car(String name) {
        this.name = name;
    }

    public void addAdvanceCount() {
        this.advanceCount++;
    }

    public void printRacingInfo() {
        String sb = this.name + " : " + this.makeHyphen();
        System.out.println(sb);
    }

    public String makeHyphen() {
        if (this.advanceCount < 1) {
            return "";
        }
        return "-".repeat(advanceCount);
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public String getName() {
        return name;
    }
}
