package racingcar.model;

import racingcar.config.Config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGame {
    private final List<Car> cars =new ArrayList<>();
    private final Set<String> userNames= new HashSet<>();
    Config config=new Config();

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(String s){
        if (userNames.contains(s)){
            throw new IllegalArgumentException("이미 존재하는 이름 입니다.");
        }
        Car car=config.car(s);
        cars.add(car);
        userNames.add(s);
    }

}
