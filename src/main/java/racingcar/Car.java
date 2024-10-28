package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public Car(String name){
        this.name = name;
        this.distance = new ArrayList<>();
    }

    private final String name;

    private List<Character> distance;

    public String getName() {
        return name;
    }

    public List<Character> getDistance() {
        return distance;
    }

    public void moveForward(){
        this.distance.add('-');
    }

}
