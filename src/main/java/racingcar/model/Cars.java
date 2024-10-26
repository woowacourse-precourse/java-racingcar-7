package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.Message;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> carNameList) {
        this.carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.carList;
    }

    public static Cars setCars(List<String> carNameList) {
        return new Cars(carNameList);
    }

    public void moveCars() {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.go(randomNumber);
        }
    }

    public List<String> getWinner() {
        List<String> winner = new ArrayList<>();
        int maxDistance = getMaxDistance();

        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    public int getMaxDistance() {
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }
}
