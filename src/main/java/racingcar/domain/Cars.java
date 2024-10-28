package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public void setCarList(String inpuString) {
        List<String> carName = Arrays.asList(inpuString.split(",",-1));
        for (String name : carName) {
            this.carList.add(new Car(name));
        }
    }

    public List<String> getWinnerList() {
        int maxDistance = getMaxDistance(carList);
        List<Car> winnerCarList = carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
        return winnerCarList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxDistance(List<Car> carArray) {
        return carArray.stream()
                .map(Car::getDistance)
                .max(Integer::compare) // getDistance는 int를 반환하지만 map Integer로 변환시킴
                .orElse(0);
    }

    public List<Car> getCarList() {
        return List.copyOf(carList);
    }

}
