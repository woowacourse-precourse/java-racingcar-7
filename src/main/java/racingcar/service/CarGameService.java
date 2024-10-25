package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Consumer;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarGameService {

    public void play(Cars cars, int rounds, Consumer<Cars> consumer) {
        for (int i = 0; i < rounds; i++) {
            consumer.accept(processRound(cars));
        }
    }

    public Cars processRound(Cars cars) {
        for (Car car : cars.getCarList()) {
            checkAndMove(car, Randoms.pickNumberInRange(0, 9));
        }
        return cars;
    }

    public void checkAndMove(Car car, int number) {
        if (number >= 4) {
            car.move();
        }
    }

    public Cars findWinners(Cars cars) {
        List<Car> carList = cars.getCarList();
        int maxPosition = findMaxPosition(carList);
        return cars.findCarsByPosition(maxPosition);
    }

    private int findMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for(Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
