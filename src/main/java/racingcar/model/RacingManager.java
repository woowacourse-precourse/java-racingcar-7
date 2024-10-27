package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class RacingManager {
    public List<Car>parseCarNamesToCar(String carNames){
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveOrStop(List<Car>carList){
        for(Car car : carList){
            car.moveOrStop();
        }
    }

}
