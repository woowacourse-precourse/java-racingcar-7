package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> carNameList) {
        this.carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars(){
        return this.carList;
    }

    public void moveCars(){
        for(Car car:carList){
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if(randomValue >= 4){
                car.move();
            }
        }
    }

    public List<String> getWinner() {
        return carList.stream()
                .collect(Collectors.groupingBy(
                        Car::getDistance,
                        Collectors.mapping(Car::getName, Collectors.toList())
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new IllegalArgumentException("자동차 목록이 비어 있습니다."));
    }

}
