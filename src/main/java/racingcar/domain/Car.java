package racingcar.domain;

public class Car {
    private final String name;
    private int dist = 0;

    public Car(String name) {
        this.name = name;
    }

    private void setDistance() {
        this.dist++;
    }

    public void printMyTrace(int dist) {
        if (dist >= 4) {
            setDistance();
        }
        System.out.println(this.name + " : " + "-".repeat(this.dist));
    }

    public String getName() {
        return name;
    }

    public int getDist() {
        return dist;
    }
}
