package racingcar;

public class Car {
    private final String name;

    private int advanceCount;
    private StringBuilder streaks;

    public Car(String name) {
        this.name = name;
        streaks = new StringBuilder();
    }

    public void move() {
        int n = (int) (Math.random() * 10);
        if (n >= 4) {
            advanceCount += 1;
            streaks.append("-");
        }
    }

    public String getName() {
        return name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void print() {
        System.out.println(name + " : " + streaks);
    }
}
