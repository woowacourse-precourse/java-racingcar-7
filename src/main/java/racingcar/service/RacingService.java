package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.RacingResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingService {

    public RacingResponse racing(String[] carName, int attemptCount) {
        List<Car> cars = getCars(carName);
        Map<String, List<Integer>> moveData = getMoveData(attemptCount, cars);
        List<String> winners = getWinners(cars);

        return new RacingResponse(moveData, winners);
    }

    private Map<String, List<Integer>> getMoveData(int attemptCount, List<Car> cars) {
        Map<String, List<Integer>> m = new HashMap<>();

        for(Car car : cars){
            List<Integer> move = new ArrayList<>();
            for(int i = 0; i< attemptCount; i++){
                car.move();
                move.add(car.getLen());
            }
            m.put(car.getName(), move);
        }

        return m;
    }

    private List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int max = -1;

        for(Car car : cars){
            if(max < car.getLen()){
                max = car.getLen();
                winners.clear();
                winners.add(car.getName());
            }
            else if(max == car.getLen()){
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private List<Car> getCars(String[] carName) {
        List<Car> cars = new ArrayList<>();
        for(String name : carName){
            Car car = new Car(name);
            cars.add(car);
        }

        return cars;
    }
}
