package racingcar.model.cars;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.car.Car;

public class Cars {
    public static final String ERROR_INVALID_NUMBER_OF_CARS = "2대 이상의 자동차를 입력해 주세요.";
    public static final String DELIMITER = ",";
    public static final int MIN_CAR = 2;

    private List<Car> cars;

    public Cars(String namesInput) {
        List<String> splitedNames = List.of(namesInput.split(DELIMITER, -1));

        this.cars = new ArrayList<Car>();

        for (String name : splitedNames) {
            cars.add(Car.from(name.strip()));
        }
        validateCarNames();
        validateNumberOfCars();
    }

    private void validateCarNames() {
        for (Car name : cars) {
            name.validateCarName();
        }
    }

    private void validateNumberOfCars() {
        if (cars.size() < MIN_CAR) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_OF_CARS);
        }
    }

    public boolean moveForward() {
        boolean moved = false;
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.changePosition();
                return moved = true;
            }
        }
        return moved;
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        Map<String, Integer> result = getResult();
        int maxPosition = Collections.max(result.values());

        for (String name : result.keySet()) {
            int position = result.get(name);
            if (position >= maxPosition) {
                winners.add(name);
            }
        }

        return winners;
    }

    public Map<String, Integer> getResult() {
        HashMap<String, Integer> carMap = new HashMap<String, Integer>();

        for (Car car : cars) {
            carMap.put(car.getName(), car.getPosition());
        }

        return Collections.unmodifiableMap(carMap);
    }
}
