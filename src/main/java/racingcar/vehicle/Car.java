package racingcar.vehicle;

public class Car {
    private String name;
    private int cnt;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > 6) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        cnt = 0;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }

}
