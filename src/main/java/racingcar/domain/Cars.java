package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
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
}
