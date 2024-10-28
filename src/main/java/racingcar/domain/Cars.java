package racingcar.domain;

import java.util.ArrayList;
import racingcar.dto.RacingCarNamesDTO;

public class Cars {
    private ArrayList<Car> cars = new ArrayList<>();

    public Cars(RacingCarNamesDTO racingCarNamesDTO) {
        for(String name : racingCarNamesDTO.getCarNames()){
            cars.add(new Car(name));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
