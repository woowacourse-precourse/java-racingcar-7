package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Random;

public class Racing {
    private final List<Car> cars;

    public Racing(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getWinners(){
        int maxPosition = cars.stream()
                                .mapToInt(Car::getPosition)
                                .max()
                                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public boolean canMove(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

}
