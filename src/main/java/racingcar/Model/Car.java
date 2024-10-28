package racingcar.Model;

public class Car {
    public final String name;
    public int ongoingCount;

    public Car(String name) {
        this.name = name;
        ongoingCount = 0;
    }

    public String getName() {
        return name;
    }

    public void ongoing() {
        ongoingCount++;
    }

    public int getOngoingCount() {
        return ongoingCount;
    }


}