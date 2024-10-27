package racingcar;

import java.util.List;

public class RaceService {


    public Race initializeRace(List<String> carNames){
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Race(cars);
    }


    public void startRace(Race race, int rounds){

    }
}
