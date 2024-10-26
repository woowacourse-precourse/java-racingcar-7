package racingcar.service;

import org.junit.jupiter.api.AfterAll;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsService {
    private final int startIndex = 0;

    private Cars cars;

    public CarsService(Cars cars) {
        this.cars = cars;
    }

    public List<String> carsDetail(){
        List<String> carsDetailList = new ArrayList<>();
        for(int i = startIndex; i < cars.getCarsSize(); i++){
            String carName = cars.getCarsName().get(i);
            int carPosition = cars.getCarsPosition().get(i);
            carsDetailList.add(carName + " : ");
            for(int j = startIndex; j < carPosition; j++){
                carsDetailList.add("-");
            }
            carsDetailList.add("\n");
        }

        return carsDetailList;
    }

}
