package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private final List<Car> winnerCars;

    public Cars(List<String> carNames) {
        cars = new ArrayList<>();
        winnerCars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void startRacingCars() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    public void endRacingCars() {
        for (Car car : cars) {
            car.endRacing();
        }
    }

    public void decisionWinnerCars() {
        //최대 전진 횟수 구하기
        int maxTotalForwordCount = 0;
        for (Car car : cars) {
            maxTotalForwordCount = Math.max(maxTotalForwordCount, car.getTotalForwordCount());
        }

        //우승자 가려내기
        for (Car car : cars) {
            if (maxTotalForwordCount == car.getTotalForwordCount()) {
                winnerCars.add(car);
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinnerCars() {
        return winnerCars;
    }


}
