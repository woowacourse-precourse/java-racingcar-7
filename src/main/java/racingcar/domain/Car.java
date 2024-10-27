package racingcar.domain;


public class Car {
    private final String name;
    private int distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public void move(){
        this.distance++;
    }

    public String getName(){
        return this.name;
    }

    public int getDistance(){
        return this.distance;
    }

}
