package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;

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
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.go(randomNumber);
        }
    }
}
