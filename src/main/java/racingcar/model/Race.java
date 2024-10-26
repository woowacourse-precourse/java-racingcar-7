package racingcar.model;

import java.util.List;

public class Race {
    List<RacingCar> racingCarList;
    public Race(List<String> racingCarsName){
        this.racingCarList = racingCarsName.stream()
                .map(RacingCar::new).toList();
    }
//    public void executeRace()
}
