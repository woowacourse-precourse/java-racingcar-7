package racingcar.model;

public class Car {
    private final int MOVE_VALUE = 4;
    private String name;
    private int distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getDistance(){
        return this.distance;
    }

    public void go(int distance){
        if(canMove(distance)){
            this.distance += distance;
        }
    }

    public boolean canMove(int number){
        return number >= MOVE_VALUE;
    }

}
