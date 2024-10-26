package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public String toString(){
        return cars.stream().map(Car::toString).collect(Collectors.joining());
    }

}
