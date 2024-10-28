package racingcar.model;

public class Car {
    private static final boolean FORWARD = true;
    private final String name;
    private int currentPosition;

    public Car(String name){
        this.name = name;
        this.currentPosition = 0;
    }

    public void moveForward(boolean command){
        if(command == FORWARD){
            currentPosition++;
        }
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

    public String getName(){
        return name;
    }
}
