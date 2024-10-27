package racingcar;

public class Car {
    private String name;
    private int location;

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void move(){
        this.location++;
    }

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }
}
