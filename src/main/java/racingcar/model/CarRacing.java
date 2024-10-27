package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final List<Car> racingCars;

    public CarRacing(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    // 전진 여부 결정
    public void moverCarsForwardRandomly() {
        for (Car car : racingCars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                car.goForward();
            }
        }
    }

    // 경주 우승자 결정
    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        winners.add(racingCars.getFirst());
        int maxDistance = racingCars.getFirst().getTotalDistance();

        // 총 전진 거리가 최대인 자동차가 우승
        for (int i = 1; i < racingCars.size(); i++) {
            Car car = racingCars.get(i);
            int carDistance = car.getTotalDistance();
            if (carDistance == maxDistance) {
                winners.add(car);
            }
            if (carDistance > maxDistance) {
                maxDistance = carDistance;
                winners.clear();
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

}
