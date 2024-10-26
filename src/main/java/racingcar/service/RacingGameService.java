package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import camp.nextstep.edu.missionutils.Randoms;


public class RacingGameService {

    public void play(List<Car> cars) {
        for (Car car : cars) {
            car.moveTry(randomIntGenerator());
        }
    }

    public List<Car> findWinner(List<Car> cars) {
        int max = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == max).toList();
    }

    private int randomIntGenerator(){
        return Randoms.pickNumberInRange(0, 9);
    }


}
