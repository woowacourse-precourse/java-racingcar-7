package racingcar;

import static org.assertj.core.util.Strings.join;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public Car(String name){
        this.name = name;
        this.distance = new ArrayList<>();
    }

    private final String name;

    private List<String> distance;

    public String getName() {
        return name;
    }

    public List<String> getDistance() {
        return distance;
    }

    public void moveForward() {
        this.distance.add("-");
    }

    public void showDistance() {
        System.out.println(this.name + " : " + String.join("", this.distance));
    }

}
