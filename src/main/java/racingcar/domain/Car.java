package racingcar.domain;

public class Car {

    public Car(String name) {
        this.name = name;
    }

    private int id;

    private String name;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
