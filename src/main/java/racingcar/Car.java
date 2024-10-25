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
        String racingInfo = this.name + " : " + this.makeHyphen();
        System.out.println(racingInfo);
    }

    public String makeHyphen() {
        if (this.advanceCount == 0) {
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
