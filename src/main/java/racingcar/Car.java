package racingcar;

import java.util.List;

public class Car {

    private final String name;
    private List<Integer> position;

    public void move(){
        position.add(position.get(position.size()-1)+1);
    }

    public Car(String name ){
        this.name = name;
    }

}
