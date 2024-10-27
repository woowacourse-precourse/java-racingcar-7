package racingcar;

public class Car {
    String name;
    int distance;

    public Car(String name){
        this.name = name;
        distance = 0;
    }

    public void Move(){
        distance++;
    }
}
