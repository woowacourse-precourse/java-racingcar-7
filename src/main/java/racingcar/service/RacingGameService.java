package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class RacingGameService {
    public void play(List<Car> cars){
        for (Car car : cars) {
            randomMove(car);
        }
    }

    public List<Car> findWinner(List<Car> cars){
        int max = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == max).toList();
    }

    private void randomMove(Car car){
        car.move(Randoms.pickNumberInRange(0, 9) >= 4);
    }
}
