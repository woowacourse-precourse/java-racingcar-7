package racingcar.logic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.validator.CarValidator;

public class RacingCarService {

    CarValidator carValidator = new CarValidator();

    public HashMap<String, Integer> saveCars(String carList) {

        List<String> cars = List.of(carList.split(",", -1)); // 공백도 허용

        HashMap<String, Integer> result = new HashMap<>();

        for (String car : cars) {
            carValidator.validateCarName(car);
            carValidator.checkDuplicateCarName(result, car);
            result.put(car, 0);
        }

        return result;
    }

    public HashMap<String, Integer> saveResult(HashMap<String, Integer> result) {

        for (String car : result.keySet()) {
            int randomNum = extractRandom();

            if (randomNum >= 4) {
                int afterRaceNum = result.get(car) + 1;
                result.put(car, afterRaceNum);
            }
        }

        return result;
    }

    public List<String> findWinner(HashMap<String, Integer> result) {

        int maxValue = 0;
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> car : result.entrySet()) {
            if (car.getValue() > maxValue) {
                maxValue = car.getValue();
            }
        }

        for (Map.Entry<String, Integer> car : result.entrySet()) {
            if (car.getValue() == maxValue) {
                winners.add(car.getKey());
            }
        }

        return winners;
    }

    public List<String> postWinnerProcess(List<String> winners) {

        for (int i = 1; i < winners.size(); i = i + 2) {
            winners.add(i, ", ");
        }

        return winners;
    }

    private int extractRandom() {

        return Randoms.pickNumberInRange(0, 9);
    }
}
