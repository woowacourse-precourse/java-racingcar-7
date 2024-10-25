package racingcar.Model;

public class Car implements Participant{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
