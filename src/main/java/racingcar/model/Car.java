package racingcar.model;

public class Car {
    private final int MOVE_VALUE = 4;
    private String name;
    private int distance = 0;

    public Car(String name, int distance){
        this.name = name;
        this.distance =distance;
    }

    public String getName(){
        return name;
    }

    public int getDistance(){
        return distance;
    }

    public void move(int distance){
        if(canMove(distance)){
            this.distance += distance;
        }
    }

    public boolean canMove(int number){
        return number >= MOVE_VALUE;
    }

}
