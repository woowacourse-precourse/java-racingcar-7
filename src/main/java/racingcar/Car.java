package racingcar;

public class Car {

    private String name;
    private int pos = 0;
    public Car(String name) {
        this.name = name;
    }

    public void move(){
        this.pos += 1;
    }
    public String getName() {
        return this.name;
    }
    public int getPos(){
        return this.pos;
    }

}