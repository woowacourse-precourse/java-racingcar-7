package racingcar;

public class Car {
    private String name;
    private int POSITION;

    public Car (String name, int position){
        this.name = name;
        this.POSITION = position;
    }

    public void moveForword(){
        this.POSITION += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return POSITION;
    }
}
