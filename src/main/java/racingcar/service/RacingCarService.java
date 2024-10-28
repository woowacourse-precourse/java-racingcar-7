package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;

public class RacingCarService {

    public List<Car> initializeCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .toList();
    }

    public void moveCars(List<Car> carList) {
        carList.forEach(this::tryToMoveCar);
    }

    private void tryToMoveCar(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.move();
        }
    }

    public List<String> determineWinners(List<Car> carList) {
        return getWinnerList(carList, getMaxPosition(carList));
    }

    private List<String> getWinnerList(List<Car> carList, int maxPosition) {
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
