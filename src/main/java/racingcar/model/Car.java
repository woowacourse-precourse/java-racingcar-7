package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.Validator;

import java.util.*;

public class Car {

    Map<String, Integer> cars = new HashMap<>();
    List<String> winnerCars = new ArrayList<>();

    public Map<String, Integer> carNameSplit(String carNames){
        String[] tokens = carNames.split(",");

        for(String car : tokens){
            Validator.checkNameLength(car);
            cars.put(car, 0);
        }

        return cars;
    }

    public Map<String, Integer> racingTry(Map<String, Integer> cars){

        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                cars.put(entry.getKey(), entry.getValue() + 1);
            }
        }

        return cars;
    }

    public List<String> getWinningCars(Map<String, Integer> cars){
        Optional<Integer> maxDistance = cars.values().stream()
                .max(Integer::compare);

        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            if (Objects.equals(entry.getValue(), maxDistance.get())) {
                winnerCars.add(entry.getKey());
            }
        }
        return winnerCars;
    }
}
