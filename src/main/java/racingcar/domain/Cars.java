package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static List<Car> winner;

    public Cars() {
        this.winner = new ArrayList<>();
    }

    public List<Car> getWinnerList(List<Car> carArray){
        setWinnerList(carArray);
        return winner;
    }

    public void setWinnerList(List<Car> carArray) {
        int maxDistance = getMaxDistance(carArray);
        this.winner = carArray.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int getMaxDistance(List<Car> carArray) {
        return carArray.stream()
                .map(Car::getDistance)
                .max(Integer::compare) // getDistance는 int를 반환하지만 map Integer로 변환시킴
                .orElse(0);
    }
}
