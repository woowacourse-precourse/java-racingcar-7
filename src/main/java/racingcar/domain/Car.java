package racingcar.domain;

public class Car {

    private String name;
    private String count = "";

    public Car(String name, String count) {
        this.name = name;
        this.count = count;
    }

    public void addCount() {
        this.count += "-";
    }

    public String getName() {
        return name;
    }

    public String getCount() {
        return count;
    }

    @Override
    public String toString() {
        return name;
    }
}
