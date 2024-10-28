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

    public int size(){
        return cars.size();
    }

    public Car findCarByNumber(int number){
        return cars.get(number);
    }
}
