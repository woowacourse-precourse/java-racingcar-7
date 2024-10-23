package racingcar.model;

public class Car {

    private String name;
    private int pos;

    public Car(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void go(){
        this.pos++;
    }
}
