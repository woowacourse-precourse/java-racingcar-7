package racingcar.model;

public class Car {
    private final CarName name;
    private static final int MOVE=4;
    private int position=0;

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position =position;
    }

    public Car(String name) {
        this.name = new CarName(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
    public void move(int i){
        if(i>=MOVE) position++;
    }
}
