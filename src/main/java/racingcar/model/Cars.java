package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Constants;

public class Cars {
    private List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void addCar(String name) {
        carList.add(new Car(name));
    }

    public void raceCars() {
        for (Car car : carList) {
            car.move();
        }
    }

    public List<String> getRaceInfos() {
        List<String> raceInfos = new ArrayList<>();
        for (Car car : carList) {
            raceInfos.add(car.getRaceInfo());
        }
        return raceInfos;
    }

    private int getMaxDistance() {
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public String getRaceWinner() {
        StringBuilder sb = new StringBuilder();

        for (Car car : carList) {
            if (car.getDistance() != getMaxDistance()) {
                continue;
            }

            if (sb.length() > 0) {
                sb.append(Constants.COMMA).append(Constants.WHITESPACE);
            }
            sb.append(car.getName());
        }
        return sb.toString();
    }
}
