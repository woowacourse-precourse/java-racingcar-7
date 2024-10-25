package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.RacingTrackException;

public class RacingTrack {
    private final List<Car> cars;

    public RacingTrack(){
        this.cars = new ArrayList<>();
    }

    public void addCar(List<String> carNames){
        for(String carName : carNames){
            checkDuplicatedCarName(carName);
            cars.add(new Car(carName));
        }
    }

    public void checkDuplicatedCarName(String name){
        var duplicatedName = cars.stream()
                .anyMatch(car -> car.getName().equals(name));
        if(duplicatedName){
            throw new IllegalArgumentException(RacingTrackException.DUPLICATED_CAR_NAME.getMessage());
        }
    }
}
