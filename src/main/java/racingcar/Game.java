package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    public List<RacingCar> init(List<String> carNames) {
        return initCars(carNames);
    }

    public List<RacingCar> initCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(RacingCar.createRacingCar(name));
        }
        return racingCars;
    }

    public Integer randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public Boolean isForward(Integer number) {
        return number >= 4;
    }

    public Map<String, Integer> executeLogic(List<RacingCar> racingCars) {
        Map<String, Integer> result = new HashMap<>();
        for (RacingCar racingCar : racingCars) {
            Integer randomNumber = randomNumber();
            if (isForward(randomNumber)) {
                racingCar.addScore();
            }
            result.put(racingCar.getName(), randomNumber);
        }
        return result;
    }
}
