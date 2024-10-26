package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    List<Car> cars = new ArrayList<>();

    public Race(List<String> names){
        cars = names.stream().map(Car::new).toList();
    }

    public Race(String input){
        this(List.of(input.split(",")));
    }

    public void run(){
        for(Car car : cars){
            car.move();
        }
    }

}
