package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class CarController {
    private List<Car>carList;
    public CarController(List<Car>carList){
        this.carList = carList;
    }
    public void raceStart(){
        for(Car car : carList){
            int num = Randoms.pickNumberInRange(0, 9);
            if(num >= 4){
                car.goForward();
            }
        }
    }
    public List<Car> getCarList(){
        return carList;
    }

}
