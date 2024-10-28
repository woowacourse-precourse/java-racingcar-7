package racingcar.domain.car;

import java.util.ArrayList;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.dto.RacingCarNamesDTO;

public class Cars {
    private ArrayList<Car> cars = new ArrayList<>();

    public Cars(RacingCarNamesDTO racingCarNamesDTO) {
        for(String name : racingCarNamesDTO.getCarNames()){
            cars.add(new Car(name, new RandomMoveStrategy()));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int size(){
        return cars.size();
    }

    public Car getCarByNumber(int number){
        return cars.get(number);
    }
}
