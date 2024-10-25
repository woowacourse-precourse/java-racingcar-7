package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Utils {

    public String[] convertToCarNameArray(String carNames) {
        return carNames.split(",");
    }

    public void saveCarNamesToList(String[] carNames, List<Car> cars) {
        for (String carName : carNames) {
            cars.add(new Car(carName, ""));
        }
    }

    public void attemptCarMove(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.addCount();
        }
    }

    public List<String> getCarsWithHighestCount(List<Car> cars) {
        int max = findMaxCount(cars);
        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCount().length() == max) {
                winnerList.add(car.toString());
            }
        }
        return winnerList;
    }

    private int findMaxCount(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getCount().length()) {
                max = car.getCount().length();
            }
        }
        return max;
    }

    public String getWinnersAsString(List<String> winnerList) {
        return String.join(",", winnerList);
    }
}
