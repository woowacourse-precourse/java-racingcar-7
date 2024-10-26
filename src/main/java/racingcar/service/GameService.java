package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.GameStatus;

public class GameService {

    public void saveCarName(GameStatus gameStatus, String[] carNameArray) {
        for (String carName : carNameArray) {
            Car car = new Car(carName.trim(), 0);
            gameStatus.addCar(car);
        }
    }

    public List<Map<String, String>> progressGame(GameStatus gameStatus, int tryCount) {
        Set<Car> cars = gameStatus.getCar();
        List<Map<String, String>> carsPosition = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            forwardCarByRandomNumber(cars);
            carsPosition.add(collectCarPosition(cars));
        }
        return carsPosition;
    }

    private void forwardCarByRandomNumber(Set<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.forwardCar();
            }
        }
    }

    private Map<String, String> collectCarPosition(Set<Car> cars) {
        Map<String, String> updatedCarPosition = new HashMap<>();

        for (Car car : cars) {
            updatedCarPosition.put(car.getName(), car.positionToString());
        }
        return updatedCarPosition;
    }

}
