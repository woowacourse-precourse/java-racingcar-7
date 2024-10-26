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

    public String carsDetail(){
        StringBuilder carDetail = new StringBuilder();
        for(int i = startIndex; i < cars.getCarsSize(); i++){
            String carName = cars.getCarsName().get(i);
            int carPosition = cars.getCarsPosition().get(i);
            carDetail.append(carName + " : ");

            for(int j = startIndex; j < carPosition; j++){
                carDetail.append("-");
            }

            carDetail.append("\n");
        }

        return carDetail.toString();
    }

    public List<String> winnerList(){
        List<String> winner = new ArrayList<>();
        for(int i = startIndex; i < cars.getCarsSize(); i++) {
            if(cars.getCarsPosition().get(i) == getMaxPosition())
                winner.add(cars.getCarsName().get(i));
        }

        return winner;
    }

    private int getMaxPosition(){
        int max = 0;
        for(int i = startIndex; i < cars.getCarsSize(); i++) {
            if(max < cars.getCarsPosition().get(i))
                max = cars.getCarsPosition().get(i);
        }

        return max;
    }

}
