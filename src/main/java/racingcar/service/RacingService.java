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
        List<Map<String, Integer>> moveData = getMoveData(attemptCount, cars);
        List<String> winners = getWinners(cars);

        return new RacingResponse(moveData, winners);
    }

    private List<Map<String, Integer>> getMoveData(int attemptCount, List<Car> cars) {
        List<Map<String, Integer>> moveData = new ArrayList<>();

        for(int i=0; i<attemptCount; i++) {
            Map<String, Integer> move = new HashMap<>();
            for (Car car : cars) {
                car.move();
                move.put(car.getName(), car.getDistance());
            }
            moveData.add(move);
        }

        return moveData;
    }

    private List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int max = -1;

        for(Car car : cars){
            if(max < car.getDistance()){
                max = car.getDistance();
                winners.clear();
                winners.add(car.getName());
            }
            else if(max == car.getDistance()){
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
