package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void raceOnce() {
        for(Car car : cars){
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<Car> getWinners(){
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars){
            if (car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

}
