package racingcar;

public class Car {

    private String carName;
    private int distance;

    public Car(String name){
        this.carName = name;
        this.distance = 0;
    }

    public String getCarName(){
        return carName;
    }

    public int getDistance(){
        return distance;
    }

    public void takeTurn(){
        //Todo: 거리 1만큼 증가
    }

}
